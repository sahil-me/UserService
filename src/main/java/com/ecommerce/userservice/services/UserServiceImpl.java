package com.ecommerce.userservice.services;

import com.ecommerce.userservice.models.Token;
import com.ecommerce.userservice.models.User;
import com.ecommerce.userservice.repositories.TokenRepository;
import com.ecommerce.userservice.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token login(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isEmpty()) {

//            Throw and exception here that user does not exists
//            Redirect to signUp
            return null;
        }

        User user = userOptional.get();

        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {

//            Throw an exception of invalid password
            return null;
        }

        Token token = new Token();
        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        token.setUser(user);

//        Token to expire in 30 days
        LocalDateTime thirtyDaysFromNow = LocalDateTime.now().plusDays(30);

        token.setExpiryDateTime(thirtyDaysFromNow);

        return tokenRepository.save(token);
    }

    @Override
    public User signUp(String name, String email, String password) {

//        Check if the user already exists
        Optional<User> userOptional = userRepository.findByEmail(email);

//        If, the user exists -> return existing User object
        if(userOptional.isPresent()) {
            return userOptional.get();
        }

//        Else, create a new user with the details and return the User object
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    @Override
    public User validateToken(String tokenValue) {

        Optional<Token> tokenOptional = tokenRepository.findByValueAndExpiryDateTimeGreaterThan(tokenValue,
                LocalDateTime.now());
        return tokenOptional.map(Token::getUser).orElse(null);
    }

    @Override
    public void logout(String tokenValue) {

    }

}
