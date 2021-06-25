package com.github.matgor.workshop.Domain.Model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "repairs")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = {"mechanic", "vehicle"})
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;
*/
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    /*@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
*/
}

