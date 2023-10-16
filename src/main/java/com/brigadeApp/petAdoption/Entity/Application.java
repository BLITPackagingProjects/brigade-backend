package com.brigadeApp.petAdoption.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Application {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long app_id;

	    @Column(nullable=false)
	    
	    private String status;

	    @Column(nullable=false)
	    private Date date;

	    @ManyToOne
	    @JoinColumn(name = "user_id",nullable=false)
	    private User user;

	    @ManyToOne
	    @JoinColumn(name = "pet_id", nullable=false)
	    private Pet pet;

}





