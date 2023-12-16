package com.unittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unittesting.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
