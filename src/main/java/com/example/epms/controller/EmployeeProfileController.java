package com.example.epms.controller;

import com.example.epms.model.EmployeeProfile;
import com.example.epms.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/epms")
public class EmployeeProfileController {

    @Autowired
    private EmployeeProfileService service;

    @PostMapping("/addOne")
    public EmployeeProfile addOne(@RequestBody EmployeeProfile ep) {
        return service.save(ep);
    }

    @GetMapping("/findById/employeeProfileId={id}")
    public Optional<EmployeeProfile> findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    public List<EmployeeProfile> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/deleteById/employeeProfileId={id}")
    public String deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/findByName/{name}")
    public List<EmployeeProfile> findByName(@PathVariable String name) {
        return service.findByName(name);
    }
}
