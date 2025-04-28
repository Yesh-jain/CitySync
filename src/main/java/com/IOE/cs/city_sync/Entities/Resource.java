package com.IOE.cs.city_sync.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESOURCES")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Project_Id", referencedColumnName = "id")
    private Project project;

    @Column(name = "DESCRIPTION")
    private String Description;

    @Column(name = "isAvailable")
    private Boolean isAvailable;

    @Column(name = "ALLOTTED_Quantity")
    private Integer allottedQuantity;

    @Column(name = "USED_Quantity")
    private Integer usedQuantity;

}
