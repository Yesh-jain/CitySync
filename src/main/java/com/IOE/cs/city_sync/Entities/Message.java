package com.IOE.cs.city_sync.Entities;

import com.IOE.cs.city_sync.enums.Response;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MESSAGE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "id")
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Recepient_Users", referencedColumnName = "id")
    private CSUser recepientUser;

    @Column(name = "RESPONSE")
    private Response response;
}
