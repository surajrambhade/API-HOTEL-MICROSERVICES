package com.lcdw.user.service.services;

import com.lcdw.user.service.entites.User;

import java.util.List;

public interface UserServices {


    // user operation

    // create

    User saveUser(User user);

    //get all User

    List<User> getAllUser();

    //set single user f given Userid;

    User getUser(String userId);

    //TODO : Delete
    //TODO : Update


}
