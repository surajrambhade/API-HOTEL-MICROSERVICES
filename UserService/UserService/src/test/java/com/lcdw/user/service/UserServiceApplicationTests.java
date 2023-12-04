package com.lcdw.user.service;

import com.lcdw.user.service.entites.Rating;
import com.lcdw.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;


	/*@Test
	void createRating(){

		Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("This si testing using feign clint ").build();
		ResponseEntity<Rating> ratingResponseEntity = ratingService.createRating(rating);
		System.out.println("New rating created ...");
	}
*/
	/*@Test
	void createRating(){

		Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("This si testing using feign clint ").build();
		Rating savedRating = ratingService.createRating(rating);
		System.out.println("New rating created ...");
	}*/

}
