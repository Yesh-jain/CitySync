package com.IOE.cs.city_sync.DTOs;

import com.IOE.cs.city_sync.Entities.CSUser;
import com.IOE.cs.city_sync.enums.Response;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDTO {

    private Integer messageId;

    private Response response;

    private String username;

    private String projName;

    private String projLocation;

    private String projDescription ;

    private String projDepartment;


    public MessageDTO(Integer messageId, String projName, String projDepartment, String projDescription, String projLocation) {
        this.messageId = messageId;
        this.projName = projName;
        this.projDepartment = projDepartment;
        this.projDescription = projDescription;
        this.projLocation = projLocation;
    }
     public MessageDTO(Integer messageId, String projName, String projDepartment, String projDescription, String projLocation
             , String username , Response response) {
        this.username = username;
        this.response = response;
        this.messageId = messageId;
        this.projName = projName;
        this.projDepartment = projDepartment;
        this.projDescription = projDescription;
        this.projLocation = projLocation;
    }

    public MessageDTO(Integer messageId, String projName,String projDepartment,String projLocation , String username , Response response) {
        this.username = username;
        this.response = response;
        this.messageId = messageId;
        this.projName = projName;
        this.projLocation = projLocation;
        this.projDepartment = projDepartment;
    }
}
