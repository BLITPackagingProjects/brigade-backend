package com.brigadeApp.petAdoption.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brigadeApp.petAdoption.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select * from user where role_id =?")
    public User findUserByRole(int id);
}