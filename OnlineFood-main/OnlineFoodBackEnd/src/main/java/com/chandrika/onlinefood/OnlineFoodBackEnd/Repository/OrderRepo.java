package com.chandrika.onlinefood.OnlineFoodBackEnd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.Order;

@Repository
@EnableJpaRepositories

public interface OrderRepo extends JpaRepository<Order, Integer> {
	
	@Query("SELECT o FROM Orders o WHERE o.userId.userId = :userId")
	List<Order> findByUserId(@Param("userId") Integer userId);
	
	 @Query("SELECT o FROM Orders o WHERE o.restaurant.resId = :resId")
	    List<Order> findByResId(@Param("resId") Integer resId);
}