package com.github.matgor.workshop.Domain.Model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank @Size(min = 3) @Column(name = "first_name")
    private String firstName;

    @NotNull @NotBlank @Size(min = 3) @Column(name = "last_name")
    private String lastName;

    @Email @NotNull @Column(unique = true)
    private String email;

    @Column(name = "phone_number", unique = true)
    private Long phoneNumber;

    @NotNull @NotBlank
    private String password;
}
