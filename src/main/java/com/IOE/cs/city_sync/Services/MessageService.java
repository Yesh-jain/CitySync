package com.IOE.cs.city_sync.Services;

import com.IOE.cs.city_sync.DTOs.MessageDTO;
import com.IOE.cs.city_sync.Entities.Message;
import com.IOE.cs.city_sync.Repos.CSUserRepo;
import com.IOE.cs.city_sync.Repos.MessageRepo;
import com.IOE.cs.city_sync.enums.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private CSUserRepo csUserRepo;

    public List<MessageDTO> showMyMessages(String username) {
        Integer deptId = csUserRepo.getDepartmentIdByUsername(username);
        return messageRepo.getMessagesByResponse(username, deptId, Response.UNANSWERED);
    }

    public List<MessageDTO> showMessagesByResponse(String username, Response response) {
        Integer deptId = csUserRepo.getDepartmentIdByUsername(username);
        return messageRepo.getMessagesByResponse(username, deptId, response);
    }

    public void updateByResponse(Integer messageId, String name, Response response) {
        messageRepo.updateResponse(messageId, name, response);
    }

    public List<MessageDTO> getAllMessages() {
        List<MessageDTO> allMessages = messageRepo.getAllMessages();
        return allMessages;
    }

    public List<MessageDTO> myProjectResponse(Integer projectId) {
        List<MessageDTO> myProjectResponses = messageRepo.myProjectResponses(projectId);
        return myProjectResponses;
    }

}
