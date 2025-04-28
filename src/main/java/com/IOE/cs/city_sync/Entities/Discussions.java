package com.IOE.cs.city_sync.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DISCUSSIONS")
public class Discussions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Topic")
    private String Topic;

    @Column(name = "Content")
    private String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Meeting_Id", referencedColumnName = "id")
    private Meetings meetings;
}