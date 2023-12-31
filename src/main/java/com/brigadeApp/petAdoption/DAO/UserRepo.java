package com.brigadeApp.petAdoption.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brigadeApp.petAdoption.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE role_id =?", nativeQuery = true)
    public List<User> findUsersByRole(int id);
}