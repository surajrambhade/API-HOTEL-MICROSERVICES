package com.lcdw.user.service.external.services;


import com.lcdw.user.service.entites.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;
import java.util.Objects;

@Service
@FeignClient(name="RATINGS-SERVICE")
public interface RatingService {

    //get


    // POST

    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(Rating values);   //  http se related info dega ye testing k main floder mai use kr k dekha hai esko

   /* @PostMapping("/ratings")
    Rating createRating(Rating values);   //  testing k main floder mai use kr k dekha hai esko
*/


    //PUT or update
    @PutMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable String ratingId, Rating rating);


    // delete

    @DeleteMapping("/ratings/ratingId")
    void deleteRating(@PathVariable String ratingId);


}
