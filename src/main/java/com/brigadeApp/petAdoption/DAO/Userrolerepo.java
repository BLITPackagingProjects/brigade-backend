package com.brigadeApp.petAdoption.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brigadeApp.petAdoption.Entity.User_Role;
@Repository
public interface Userrolerepo extends JpaRepository<User_Role , Integer> {

}
