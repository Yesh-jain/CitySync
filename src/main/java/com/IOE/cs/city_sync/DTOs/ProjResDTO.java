package com.IOE.cs.city_sync.DTOs;

import com.IOE.cs.city_sync.Entities.Resource;
import com.IOE.cs.city_sync.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjResDTO {

    private String projectName;

    private Integer departmentid;

    private String projDescription;

    private String location;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate uploadDate;

    private Boolean isInterdepartmental;

    private ProjectStatus projectStatus;

    private List<ResourceDTO> resourcesdto;
}
