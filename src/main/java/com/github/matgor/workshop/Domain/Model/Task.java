package com.github.matgor.workshop.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO  Wykorzystać @DateTimeFormat do kontroli formatu daty/czasu
    //      Domyślny format w HTTP: yyyy-MM-dd
    //      Domyślny format LocalDate: dd.mm.yyyy
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "date_repair")
    private LocalDate dateRepair;

    private String desctription;

    @ManyToOne
    private Vehicle vehicle;

}
