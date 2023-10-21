package com.brigadeApp.petAdoption.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

	@OneToMany(mappedBy = "pet")
	@JsonIgnore
	private List<Application> applicationList;


}
