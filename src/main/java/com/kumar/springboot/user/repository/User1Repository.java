package com.kumar.springboot.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.springboot.user.entity.User1;

@Repository
public interface User1Repository extends JpaRepository<User1, Integer>{

}
