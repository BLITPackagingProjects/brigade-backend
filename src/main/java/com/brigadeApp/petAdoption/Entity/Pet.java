package com.brigadeApp.petAdoption.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pet_id;

	@Column
	private String name;

	@Column
	private String type;
	
	@Column
	private String color;

	@Column
	private int age;
	@Column
	private String breed;

	@Column
	private String image;
	
	
}