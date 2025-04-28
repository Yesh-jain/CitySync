package com.IOE.cs.city_sync.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Entity
@Table(name = "Users")
public class CSUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Department_ID", referencedColumnName = "id")
    private Department department;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String username;

    public CSUser() {

    }

    public void setUsername() {
        this.username = this.email.substring(0, this.email.indexOf('@'));
    }

    @Column(name = "ROLE")
    private String role;

    public void setRole(String role) {
        this.role = role.toUpperCase();
    }

    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PART_USERS" ,referencedColumnName = "id")
    private Meetings meeting;

    @Override
    public String toString() {
        return "CSUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
