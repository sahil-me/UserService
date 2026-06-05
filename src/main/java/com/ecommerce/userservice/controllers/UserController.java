package com.ecommerce.userservice.controllers;

import com.ecommerce.userservice.dtos.*;
import com.ecommerce.userservice.models.Token;
import com.ecommerce.userservice.models.User;
import com.ecommerce.userservice.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
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
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto) throws JsonProcessingException {

        User user = userService.signUp(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        // Converting from user to UserDto
        return UserDto.from(user);
    }

    /* All the authentication is now handled by JWT/oAUth
    Clients must use OAuth flow now to get the JWT token */

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile(JwtAuthenticationToken token) {

        String userEmail = token.getName();
        User user = userService.getUserByEmail(userEmail);

        return ResponseEntity.ok(UserDto.from(user));
    }

//    @GetMapping("/profile")
//    public ResponseEntity<String> getProfile(JwtAuthenticationToken token) {
//
//        return ResponseEntity.ok(
//                "Hello " + token.getName() + "! You are accessing a profile endpoint"
//        );
//    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN')")
    public ResponseEntity<String> adminEndpoint(JwtAuthenticationToken token) {

        return ResponseEntity.ok(
                "Hello " + token.getName() + "! You are accessing a admin endpoint"
        );
    }

//    @PostMapping("/login")
//    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto) {
//
//        Token token = userService.login(
//                requestDto.getEmail(),
//                requestDto.getPassword()
//        );
//
//        LoginResponseDto responseDto = new LoginResponseDto();
//        responseDto.setToken(token.getValue());
//        return responseDto;
//    }

//    @PostMapping("/logout")
//    public ResponseEntity<String> logOut(@RequestBody LogoutRequestDto requestDto) {
//
//        userService.logout(requestDto.getTokenValue());
//
//        return ResponseEntity.ok("Logged out successfully");
//    }

//    @GetMapping("/validate/{token}")
//    public ResponseEntity<UserDto> validateToken(@PathVariable("token") String tokenValue) {
//
//        User user = userService.validateToken(tokenValue);
//        if(user == null) {
//            return new ResponseEntity<>(
//                    null,
//                    HttpStatus.NOT_FOUND
//            );
//        }
//
//        return new ResponseEntity<>(
//                UserDto.from(user),
//                HttpStatus.OK
//        );
//    }

}
