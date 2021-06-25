package com.github.matgor.workshop.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "date_repair")
    private LocalDateTime dateRepair;

    @ManyToOne
    private Vehicle vehicle;
}
