package com.github.matgor.workshop.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate registrationDate;

    @Column(name = "date_repair")
    private LocalDate dateRepair;

    private String desctription;

    @ManyToOne
    private Vehicle vehicle;

}
