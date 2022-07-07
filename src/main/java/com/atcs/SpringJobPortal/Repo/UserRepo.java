package com.atcs.SpringJobPortal.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atcs.SpringJobPortal.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	List<User> findByexp(int exp);

//	List<User> findByAddress(String Address);

	List<User> findByqualifications(String degree);
	
	
}