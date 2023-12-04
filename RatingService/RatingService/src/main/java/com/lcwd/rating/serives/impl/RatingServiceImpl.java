package com.lcwd.rating.serives.impl;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.serives.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingServices {


    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return this.repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return this.repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getratingByHotelId(String hotelId) {
        return this.repository.findByHotelId(hotelId);
    }
}
