package com.defteam.modal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.defteam.modal.User;


public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u where u.email=:email")
	User findByEmail(@Param("email")String email);

} 
