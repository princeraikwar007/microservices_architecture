package com.projectA2Z.departmentservice.service;

import com.projectA2Z.departmentservice.entity.Department;
import com.projectA2Z.departmentservice.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalLong;

@Service
@Slf4j
public class DepartmentService {
    
    		
    @Autowired
    DepartmentRepo departmentRepo;

    public Department saveDepartment(@RequestBody Department department) {
        log.info("saveDepartment method of DepartmentService");
        return departmentRepo.save(department);
    }

    public Department findDepartmentById(Long id){
        Optional<Department> op = departmentRepo.findById(id);
        Department dp = op.get();
        return dp;
    }
}
