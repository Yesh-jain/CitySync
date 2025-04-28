package com.IOE.cs.city_sync.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Integer id;

    private String name;

    private String description;

    private Long phoneNumber;
}
