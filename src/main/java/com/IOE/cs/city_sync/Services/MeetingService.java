package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.MeetingsDTO;
import com.IOE.cs.city_sync.DTOs.MessageDTO;
import com.IOE.cs.city_sync.Entities.Meetings;
import com.IOE.cs.city_sync.Entities.Message;
import com.IOE.cs.city_sync.Repos.*;
import com.IOE.cs.city_sync.enums.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private CSUserRepo csUserRepo;
    @Autowired
    private MeetingRepo meetingRepo;


    public MeetingsDTO getDetailsFromMessage(Integer messageId) {
        MeetingsDTO meetingsDTO = new MeetingsDTO();
        Message message = messageRepo.getMessageById(messageId);
        meetingsDTO.setMessageId(messageId);
        meetingsDTO.setProjectId(message.getProject().getId());
        meetingsDTO.setParticipatingUser(message.getRecepientUser().getUsername());
        return meetingsDTO;
    }

    public void addMeetingInvite(MeetingsDTO meetingsDTO , String username ) {
        System.out.println(meetingsDTO.toString());
        Meetings meetings = new Meetings();
        meetings.setProject(projectRepo.getProjectById(meetingsDTO.getProjectId()));
        meetings.setParticipatingUser(csUserRepo.getByUsername(meetingsDTO.getParticipatingUser()));
        meetings.setMeetingDate(meetingsDTO.getMeetingDate());
        meetings.setAddedBy(csUserRepo.getByUsername(username));
        meetings.setMeetingStartTime(meetingsDTO.getMeetingStartTime());
        meetings.setMeetingEndTime(meetingsDTO.getMeetingEndTime());
        meetings.setLink(meetingsDTO.getLink());
        meetingRepo.save(meetings);
        Message message = messageRepo.getMessageById(meetingsDTO.getMessageId());
        message.setResponse(Response.INVITED);
        messageRepo.save(message);
    }

    public List<MeetingsDTO> getMeetingInvitation(String name) {
        List<Meetings> meetingsList = meetingRepo.getMeetingByParticipatingUser(csUserRepo.getByUsername(name));
        System.out.println(meetingsList.toString());
        List<MeetingsDTO> meetingsDTOS = new ArrayList<>();
        for(Meetings meeting : meetingsList){
            MeetingsDTO meetingsDTO = new MeetingsDTO();
            meetingsDTO.setProjectName(meeting.getProject().getName());
            meetingsDTO.setLink(meeting.getLink());
            meetingsDTO.setMeetingDate(meeting.getMeetingDate());
            meetingsDTO.setMeetingStartTime(meeting.getMeetingStartTime());
            meetingsDTO.setMeetingEndTime(meeting.getMeetingEndTime());
            meetingsDTOS.add(meetingsDTO);
        }
        return meetingsDTOS;
    }
}
