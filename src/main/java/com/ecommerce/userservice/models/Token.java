package com.ecommerce.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity(name = "tokens")
public class Token extends BaseModel {

    private String value;

    @ManyToOne
    private User user;

    private LocalDateTime expiryDateTime;

}

/*
  1            M
 User  ----- Token
  1            1

 */
