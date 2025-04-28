package com.IOE.cs.city_sync.DTOs;

import com.IOE.cs.city_sync.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor

public class ProjectListDTO {
    private Integer projectId;

    private String projectName;

    private String departmentName;

    private String location;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private ProjectStatus projectStatus;

    public ProjectListDTO(Integer projectId , String projectName, String departmentName, String location, String description, LocalDate startDate, LocalDate endDate , ProjectStatus projectStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.departmentName = departmentName;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
    }
}
