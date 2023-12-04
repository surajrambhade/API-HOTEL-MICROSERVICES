package com.lcdw.user.service.controllers;


import com.lcdw.user.service.entites.User;
import com.lcdw.user.service.services.UserServices;
import com.lcdw.user.service.services.impl.UserServicesImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;


    private Logger logger= LoggerFactory.getLogger(UserController.class);


    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = this.userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }



    // single user get
    //int retryCount=1;

    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    //@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){

        //logger.info("Retry Count: {} ", retryCount);
        //retryCount++;

      //  return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
        User user = userServices.getUser(userId);
        return ResponseEntity.ok(user);
    }



    //creating falll back method for circuitbreaker


    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        logger.info("fallback is exceuted because serivec is down: ", ex.getMessage());
        ex.printStackTrace();
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down")
                .UserId("1212121")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);


    }


    //all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userServices.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
