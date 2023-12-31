package com.brigadeApp.petAdoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brigadeApp.petAdoption.Entity.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Integer> {

}
