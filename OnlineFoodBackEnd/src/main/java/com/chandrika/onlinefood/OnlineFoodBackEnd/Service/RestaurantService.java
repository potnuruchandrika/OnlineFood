package com.chandrika.onlinefood.OnlineFoodBackEnd.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.Restaurant;
import com.chandrika.onlinefood.OnlineFoodBackEnd.Repository.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo resrepo;
	
	public String RegisterRestaurant(Restaurant restaurant) {
		resrepo.save(restaurant);
		return  restaurant.getResName();
	}
	
	public List<Restaurant> GetAllRestaurants(){
		List<Restaurant> restaurants =  resrepo.findAll();
		return restaurants;
	}
	
	public Optional<Restaurant> GetResDetailsByPhNo(String resPhoneNo){
		Optional<Restaurant> res = resrepo.findByresPhoneNo(resPhoneNo);
		return res;
	}
}
	


