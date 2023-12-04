package com.lcwd.rating.controllers;


import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.serives.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;

    // create rating
    //@PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(rating));

    }

    //get All
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingServices.getRatings());
    }


    //getall UserId
    @GetMapping("/users/{userId}")
   // @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')" )

    public ResponseEntity<List<Rating>> getRatingsUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingServices.getRatingByUserId(userId));
    }


    //get all hotel
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingServices.getratingByHotelId(hotelId));
    }


}
