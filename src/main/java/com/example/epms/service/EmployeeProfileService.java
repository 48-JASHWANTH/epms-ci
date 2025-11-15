package com.example.epms.service;

import com.example.epms.model.EmployeeProfile;
import com.example.epms.repository.EmployeeProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeProfileService {

    @Autowired
    private EmployeeProfileRepository repo;

    public EmployeeProfile save(EmployeeProfile ep) {
        return repo.save(ep);
    }

    public Optional<EmployeeProfile> findById(Integer id) {
        return repo.findById(id);
    }

    public List<EmployeeProfile> findAll() {
        return repo.findAll();
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public List<EmployeeProfile> findByName(String name) {
        return repo.findByName(name);
    }
}
