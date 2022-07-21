package com.projectA2Z.userservice.controller;

import com.projectA2Z.userservice.VO.Department;
import com.projectA2Z.userservice.VO.LoadConfig;
import com.projectA2Z.userservice.VO.ResponseTemplateVO;
import com.projectA2Z.userservice.entity.User;
import com.projectA2Z.userservice.repository.UserRepo;
import com.projectA2Z.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
@LoadBalancerClient(value = "ribbon-server",configuration = LoadConfig.class)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
      log.info("saveuser method in user controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long id){
       return userService.getUserWithDepartment(id);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping("/ribbon-balancer")
    public String getRibbonServer(Long userId) {
    	
    	StringBuffer sf =new StringBuffer("List: ");
    	
    	for (int i = 0; i < 8 ; i++) {
			
    		 String s1 = restTemplate.getForObject("http://ribbon-server/backend",String.class);
    		 sf.append(s1+"\n");
		}
       // return restTemplate.getForObject("http://ribbon-server/backend",String.class);
    	return sf.toString();
    }
}
