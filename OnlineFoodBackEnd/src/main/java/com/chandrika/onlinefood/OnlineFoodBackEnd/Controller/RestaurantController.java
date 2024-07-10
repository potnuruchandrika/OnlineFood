package com.chandrika.onlinefood.OnlineFoodBackEnd.Controller;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.Restaurant;
import com.chandrika.onlinefood.OnlineFoodBackEnd.Repository.restaurantRepo;
import com.chandrika.onlinefood.OnlineFoodBackEnd.Service.RestaurantService;

@RestController
@CrossOrigin
@RequestMapping("/api/restaurant")

public class RestaurantController {
	
	@Autowired
	RestaurantService resser;
	
	@Autowired
	restaurantRepo resrepo;
	
	@PostMapping("/registerrestaurant")
	public ResponseEntity<String> registerUser(@RequestBody Restaurant res)	{
		String resPhoneNo = res.getResPhoneNo();
		Optional<Restaurant> existingRestaurant = resrepo.findByresPhoneNo(resPhoneNo);
		if (existingRestaurant.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Restaurant with phone number " + resPhoneNo + " already exists.");
		} else if(resser.RegisterRestaurant(res) != null) {
			String message = "Registration Successful";
	        System.out.println(res);
	        return ResponseEntity.status(HttpStatus.CREATED).body(res.getResName() + " " + message);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration Failed due to invalid data.");
	}
	
	@PostMapping("/updaterestaurant")
	public ResponseEntity<String> updateRestaurant(@RequestBody Restaurant res){
		Optional<Restaurant> existingRestaurant = resrepo.findById(res.getResId());
		if(existingRestaurant.isPresent()) {
			Restaurant ures = existingRestaurant.get();
			ures.setResId(ures.getResId());
			ures.setResName(res.getResName());
			ures.setResPhoneNo(res.getResPhoneNo());
			ures.setResAddress(res.getResAddress());
			ures.setResAvgRating(res.getResAvgRating());
			ures.setResDelievryFee(res.getResDelievryFee());
			ures.setResDescription(res.getResDescription());
			ures.setResImage(res.getResImage());
			ures.setResOperationHours(res.getResOperationHours());
			ures.setResPassword(res.getResPassword());
			resrepo.save(ures);
			String message = "Restaurant Details Updated Successfully";
	        System.out.println(ures);
	        return ResponseEntity.status(HttpStatus.OK).body(ures.getResName() + " " + message);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant Details Not Updated");
		}
	}

	
	@PostMapping("/Login")
	public ResponseEntity<Restaurant> LoginRestaurant(@RequestBody Restaurant loginres) {
		String resPhoneNo = loginres.getResPhoneNo();
	    String resPassword = loginres.getResPassword();
	    Optional<Restaurant> res = resser.GetResDetailsByPhNo(resPhoneNo);
	    
	    if (res.isPresent()) {
	        Restaurant restaurant = res.get();
	        String storedPassword = restaurant.getResPassword();
	        
	        if (resPassword.equals(storedPassword)) {
	            System.out.println("Login Successful");
	            
	            return ResponseEntity.ok(restaurant);
	        } else {
	            System.out.println("Incorrect password");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
	    } else {
	        System.out.println("Restaurant not found");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
}

		
			
		
	
	
	


