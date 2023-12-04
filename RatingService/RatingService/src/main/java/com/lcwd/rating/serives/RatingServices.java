package com.lcwd.rating.serives;


import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingServices  {

    //create
    Rating create(Rating rating);


    // get all ratings
    List<Rating> getRatings();

    //get all by userId
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getratingByHotelId(String hotelId);

}
