package com.IOE.cs.city_sync.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserListDTO {

    private Integer id;

    private String name;

    private String email;

    private String username;

    private String department;

    public UserListDTO(String name, String email, Integer id, String username, String department) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.department = department;
        this.username = username;
    }
}
