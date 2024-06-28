package com.chandrika.onlinefood.OnlineFoodBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.User;
import com.chandrika.onlinefood.OnlineFoodBackEnd.Service.UserService;

@Controller
@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	UserService userser;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		 userser.register(user);
		 return ResponseEntity.ok("Register Success");
	}
}
 