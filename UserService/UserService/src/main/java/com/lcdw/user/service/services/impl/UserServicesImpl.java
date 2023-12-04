package com.lcdw.user.service.services.impl;

import com.lcdw.user.service.entites.Rating;
import com.lcdw.user.service.entites.User;
import com.lcdw.user.service.exception.ResourceNotFoundException;
import com.lcdw.user.service.external.services.HotelService;
import com.lcdw.user.service.repository.UserRepository;
import com.lcdw.user.service.services.UserServices;
import com.lcwd.hotel.entities.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;   //@LoadBalanced lgana hoga clint service k name ko use krna, aur load balance krne
                                        // aur fir hme localhost aur port no. change ho gya toh bhi mtlb nhi

    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServicesImpl.class);

    @Override
    public User saveUser(User user) {
        // Genrate Unique user id
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);

        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        // implement RATING SERVICE cALL : USING RSET TEMPLATE

        return this.userRepository.findAll();
    }



    //get single user
    @Override
    public User getUser(String userId) {
        //get user from DB with the help of user repository
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on serever !! : " + userId));
        // get fetching rating of the about user frok RATING SERVICE
        // http://localhost:8003/ratings/users/8abdefe0-55e5-49fb-abdc-0260cb870b62


        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGS-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to service to get the hotel
            // http://localhost:8002/hotels/95186623-107e-45ed-b948-49d726216a9c


            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8002/hotels/"+rating.getHotelId(), Hotel.class);

           // Hotel hotel = forEntity.getBody();
           // logger.info("responce status code: {}",forEntity.getStatusCode());


            Hotel hotel = hotelService.getHotel(rating.getHotelId());


            //set the hotel to rating
            rating.setHotel(hotel);

            // return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        //user.setRatings(ratingsOfUser);

        return  user;
    }
}
