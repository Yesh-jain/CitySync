package com.IOE.cs.city_sync.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ACKNOWLEDGEMENTS")
public class Acknowledgements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "STATUS")
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "id")
    private Project Project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "id")
    private Department DepartmentId;

    @Column(name = "REMARK")
    private String Remark;

    @Column(name = "REMINDER_COUNT")
    private Integer reminderCount;
}