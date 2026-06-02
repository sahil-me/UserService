package com.ecommerce.userservice.services;

import com.ecommerce.userservice.models.Token;
import com.ecommerce.userservice.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {

    //Test
//    public User signUp(String name, String email, String password);

    public User signUp(String name, String email, String password) throws JsonProcessingException;

    public Token login(String email, String password);

    User authenticateUser(String email, String password);

    public User validateToken(String tokenValue);

    User getUserByEmail(String email);

    public void logout(String tokenValue);

}
