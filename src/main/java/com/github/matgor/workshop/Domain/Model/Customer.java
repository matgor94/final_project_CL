package com.github.matgor.workshop.Domain.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString/*(exclude = {"vehicles"})*/
public class Customer extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


/*    @OneToMany(mappedBy = "customers")
    private List<Vehicle> vehicles = new ArrayList<>();*/
}
