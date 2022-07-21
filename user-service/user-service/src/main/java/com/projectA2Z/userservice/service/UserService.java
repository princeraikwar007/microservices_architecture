package com.projectA2Z.userservice.service;

import com.projectA2Z.userservice.VO.Department;
import com.projectA2Z.userservice.VO.ResponseTemplateVO;
import com.projectA2Z.userservice.entity.User;
import com.projectA2Z.userservice.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepo  userRepo;

    @Autowired
    RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("saveuser method in user service");
        return userRepo.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO rt = new ResponseTemplateVO();
        User user = userRepo.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        rt.setUser(user);
        rt.setDepartment(department);
        return rt;
    }


    public User getUser(Long id) {
        User user = userRepo.findByUserId(id);
        return user;
    }
}
