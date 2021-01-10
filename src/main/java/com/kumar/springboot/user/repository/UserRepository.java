package com.kumar.springboot.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.springboot.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
