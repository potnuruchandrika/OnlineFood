package com.chandrika.onlinefood.OnlineFoodBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.User;
import com.chandrika.onlinefood.OnlineFoodBackEnd.Repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userrepo;
	public String register(User user) {
		userrepo.save(user);
		return "Register Successfull";
	}

}
