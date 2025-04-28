package com.IOE.cs.city_sync.Entities;

import com.IOE.cs.city_sync.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Department", referencedColumnName = "id")
    private Department department;

    @Column(name = "DESCRIPTION")
    private String Description;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "PROJECT_START_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "PROJECT_END_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "UPLOAD_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate uploadDate;

    @Column(name = "isInterdepartmental")
    private Boolean isInterdepartmental;

    @Column(name = "STATUS")
    private ProjectStatus projectStatus;

}

