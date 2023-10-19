package com.brigadeApp.petAdoption.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long user_id;

	    public long getUser_id() {
			return user_id;
		}

		public void setUser_id(long user_id) {
			this.user_id = user_id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public User_Role getRole() {
			return role;
		}

		public void setRole(User_Role role) {
			this.role = role;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<Application> getApplicationLis() {
			return applicationLis;
		}

		public void setApplicationLis(List<Application> applicationLis) {
			this.applicationLis = applicationLis;
		}

		@Column
	    private String first_name;

	    @Column
	    private String last_name;

	    @JoinColumn(name = "role_id")
	    @ManyToOne
	    private User_Role role;

	    @Column(unique = true)
	    private String username;

	    @Column
	    private String password;

	    @OneToMany(mappedBy = "user")
	    private List<Application> applicationLis;

}