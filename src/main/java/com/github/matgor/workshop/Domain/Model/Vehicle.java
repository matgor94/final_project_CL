package com.github.matgor.workshop.Domain.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "vehicles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotBlank
    private String producent;

    @NotNull @NotBlank
    private String model;

    @NotNull @NotBlank
    private Date yearOfProduction;

    @NotNull @NotBlank
    private Long km;

    @NotNull @NotBlank
    private int capacity;

}
