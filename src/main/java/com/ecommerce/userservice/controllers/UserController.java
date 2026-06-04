package com.ecommerce.userservice.controllers;

import com.ecommerce.userservice.dtos.*;
import com.ecommerce.userservice.models.Token;
import com.ecommerce.userservice.models.User;
import com.ecommerce.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

  /*  Take the requests from the users
    1. signup
    2. login
    3. logout
    4. validate token */

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto) {

        User user = userService.signUp(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        // Converting from user to UserDto
        return UserDto.from(user);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto) {

        Token token = userService.login(
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setToken(token.getValue());
        return responseDto;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logOut(@RequestBody LogoutRequestDto requestDto) {

        userService.logout(requestDto.getTokenValue());

        return ResponseEntity.ok("Logged out successfully");
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<UserDto> validateToken(@PathVariable("token") String tokenValue) {

        User user = userService.validateToken(tokenValue);
        if(user == null) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                UserDto.from(user),
                HttpStatus.OK
        );
    }

}
