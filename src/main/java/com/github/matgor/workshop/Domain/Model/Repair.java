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
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull @Column(precision = 7, scale = 2)
    private BigDecimal partsCost;
    
    @NotNull @Column(precision = 7, scale = 2)
    private BigDecimal jobCost;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;


}

