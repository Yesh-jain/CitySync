package com.IOE.cs.city_sync.Controllers;


import com.IOE.cs.city_sync.DTOs.MeetingsDTO;
import com.IOE.cs.city_sync.Services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/inviteForm")
    public String inviteForMeeting(@RequestParam("messageId") Integer messageId ,  Model model) {
        MeetingsDTO meetingsDTO =  meetingService.getDetailsFromMessage(messageId);
        model.addAttribute("meetingsDTO", meetingsDTO);
        return "user/meeting";
    }

    @PostMapping("/invite")
    public String invite(@ModelAttribute MeetingsDTO meetingsDTO , Principal user){
        meetingService.addMeetingInvite(meetingsDTO , user.getName());
        return "redirect:/user/project/myProjects";
    }

    @GetMapping("/meetingInvites")
    public String meetingInvites(Principal user , Model model){
        List<MeetingsDTO> meetingsDTO = meetingService.getMeetingInvitation(user.getName());
        model.addAttribute("meetingsDTO",meetingsDTO);
        return "user/meetingInvitation";
    }
}
