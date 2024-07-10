package com.chandrika.onlinefood.OnlineFoodBackEnd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.Restaurant;

//import com.chandrika.onlinefood.OnlineFoodBackEnd.Service.List;
//import com.chandrika.onlinefood.OnlineFoodBackEnd.Service.Restaurant;

//public class RestaurantRepo {


@Repository
@EnableJpaRepositories
public interface restaurantRepo extends JpaRepository<Restaurant, Integer>{
	
	public Optional<Restaurant> findByresPhoneNo(String resPhoneNo);
}
