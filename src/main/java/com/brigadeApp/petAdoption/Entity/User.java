package com.brigadeApp.petAdoption.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @JoinColumn(name = "role_id")
    @ManyToOne
    private UserRole role;

    @Column
    private String username;

    @Column
    private String password;
}
