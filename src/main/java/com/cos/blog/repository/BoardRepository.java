package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}











//JPA Naming 쿼리
//SELECT * FROM user WHERE username = ?1 AND password = ?2; 
//User findByUsernameAndPassword(String username, String password);	
//@Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//User login(String username, String password);
