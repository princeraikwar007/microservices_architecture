package com.projectA2Z.departmentservice.controller;

import com.projectA2Z.departmentservice.entity.Department;
import com.projectA2Z.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department){
        log.info("saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id) {
        log.info("findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(id);
    }

}
