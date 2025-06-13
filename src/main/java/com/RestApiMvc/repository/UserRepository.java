 package com.RestApiMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApiMvc.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
