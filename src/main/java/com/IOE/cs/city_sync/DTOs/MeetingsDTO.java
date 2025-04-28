package com.IOE.cs.city_sync.DTOs;

import com.IOE.cs.city_sync.Entities.CSUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.parameters.P;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingsDTO {

    private String link;

    private Integer messageId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date meetingDate;

    private Integer projectId;

    private String projectName;

    private String addedBy;   // will define the Owner department

    private String participatingUser;

    private LocalTime meetingStartTime;

    private LocalTime meetingEndTime;
}
