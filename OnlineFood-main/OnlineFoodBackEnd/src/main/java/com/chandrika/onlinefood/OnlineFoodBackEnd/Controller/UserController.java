package com.chandrika.onlinefood.OnlineFoodBackEnd.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.User;
import com.chandrika.onlinefood.OnlineFoodBackEnd.Repository.UserRepo;
import com.chandrika.onlinefood.OnlineFoodBackEnd.Service.UserService;

@Controller
@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	UserService userser;
	
	@Autowired
	UserRepo userrepo;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		String phoneNo = user.getPhoneNo();
	    Optional<User> existingUser = userrepo.findByPhoneNo(phoneNo);
	    if (existingUser.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("User with phone number " + phoneNo + " already exists.");
	    } else if (userser.register(user) != null) {
	        String message = "Registration Successful";
	        System.out.println(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body(user.getUserName() + " " + message);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Failed due to invalid data.");
	}
	
	@PostMapping("/updateuser")
	public ResponseEntity<String> updateUser( @RequestBody User user) {
		Optional<User> existingUser = userrepo.findById(user.getUserId());
		
		if (existingUser.isPresent()) {
			User uuser = existingUser.get();
			uuser.setUserId(uuser.getUserId());
			uuser.setUserName(user.getUserName());
			uuser.setEmailId(user.getEmailId());
			uuser.setPassword(user.getPassword());
			uuser.setPhoneNo(user.getPhoneNo());
			uuser.setAddress(user.getAddress());
			userrepo.save(uuser);
			
			String message = "User Details Updated Successfully";
			System.out.println(uuser);
			return ResponseEntity.status(HttpStatus.OK).body(user.getUserName() + " " + message);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Details Not Updated");	
		}
	}
}
	