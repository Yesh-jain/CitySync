package com.IOE.cs.city_sync.Controllers;

import com.IOE.cs.city_sync.DTOs.MessageDTO;
import com.IOE.cs.city_sync.Services.MessageService;
import com.IOE.cs.city_sync.enums.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;


    @GetMapping("/showMyMessages")
    public String showMyMessages(Principal user, Model model) {
        List<MessageDTO> myMessages = messageService.showMyMessages(user.getName());
        model.addAttribute("allMessages", myMessages);
        return "user/showMessages";
    }

    @GetMapping("/ApprovedMessages")
    public String showApprovedMessages(Principal user, Model model) {
        List<MessageDTO> approvedMessages = messageService.showMessagesByResponse(user.getName(), Response.APPROVE);
        model.addAttribute("approvedMessages", approvedMessages);
        return "user/showApprovedMessages";
    }

    @GetMapping("/CollabMessages")
    public String showCollabMessages(Principal user, Model model) {
        List<MessageDTO> collabMessages = messageService.showMessagesByResponse(user.getName(), Response.INVITED);
        model.addAttribute("collabMessages", collabMessages);
        return "user/showCollabMessages";
    }

    @PostMapping("/collab-Response")
    public String collabResponse(@RequestParam("messageId") Integer messageId, Principal user) {
        messageService.updateByResponse(messageId, user.getName(), Response.COLLAB);
        return "redirect:/user/messages/showMyMessages";
    }

    @PostMapping("/approve-Response")
    public String approveResponse(@RequestParam("messageId") Integer messageId, Principal user) {
        messageService.updateByResponse(messageId, user.getName(), Response.APPROVE);
        return "redirect:/user/messages/showMyMessages";
    }

    @GetMapping("/myProjects-Response")
    public String myProjectResponse(@RequestParam("projectId") Integer projectId, Model model) {
        List<MessageDTO> myProjectResponses = messageService.myProjectResponse(projectId);
        model.addAttribute("myProjectResponses",myProjectResponses);
        return "user/myProjectResponses";
    }
}
