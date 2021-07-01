package com.github.matgor.workshop.Domain.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "repairs")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"mechanic", "vehicle", "user"})
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private BigDecimal partsCost;
    
    @NotNull
    private BigDecimal jobCost;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @NotNull @Enumerated(EnumType.STRING)
    private Status status;
}

