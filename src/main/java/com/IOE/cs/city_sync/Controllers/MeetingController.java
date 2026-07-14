package com.IOE.cs.city_sync.Controllers;


import com.IOE.cs.city_sync.DTOs.MeetingsDTO;
import com.IOE.cs.city_sync.Services.MeetingService;
import com.IOE.cs.city_sync.Services.ProjectService;
import com.IOE.cs.city_sync.Services.CSUserService;
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

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CSUserService csUserService;

    @GetMapping("/createDirect")
    public String createDirect(Principal user, Model model) {
        MeetingsDTO meetingsDTO = new MeetingsDTO();
        model.addAttribute("meetingsDTO", meetingsDTO);
        model.addAttribute("myProjects", projectService.myProjects(user.getName()));
        model.addAttribute("allUsers", csUserService.getAllUsers());
        model.addAttribute("currentUser", user.getName());
        return "user/meetingDirect";
    }

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
