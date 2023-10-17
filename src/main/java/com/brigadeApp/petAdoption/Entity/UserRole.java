package com.brigadeApp.petAdoption.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Getter
@Setter
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;

	@Column
	private String roleName;
}
