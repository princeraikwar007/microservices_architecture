package com.projectA2Z.userservice.repository;

import com.projectA2Z.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserId(Long userId);
}
