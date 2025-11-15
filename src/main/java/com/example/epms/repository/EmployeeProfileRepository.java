package com.example.epms.repository;

import com.example.epms.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Integer> {
    List<EmployeeProfile> findByName(String name);
}
