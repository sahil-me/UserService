package com.ecommerce.userservice.services;

import com.ecommerce.userservice.models.Token;
import com.ecommerce.userservice.models.User;

public interface UserService {

    public Token login(String email, String password);

    public User signUp(String name, String email, String password);

}
