package com.IOE.cs.city_sync.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CSUserDTO {

    private Integer id;

    private String name;

    private Integer departmentid;

    private String email;

    private String role;

    private String password;

}
