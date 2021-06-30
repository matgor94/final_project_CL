package com.github.matgor.workshop.Domain.Model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "repairs")
@RequiredArgsConstructor
@Setter
@Getter
@ToString(exclude = {"mechanic", "vehicle"})
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicle;
    private String task;
    private String user;
    
    /*@ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    @ManyToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "task")
    private Task task;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
*/
}

