package com.chandrika.onlinefood.OnlineFoodBackEnd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByPhoneNo(String phoneNo);
	
	
}
