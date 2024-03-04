package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
