package com.ecommerce.userservice.repositories;

import com.ecommerce.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    /*
   select * from tokens where value = tokenValue and expiryDateTime > localDateTime
    */

    Optional<Token> findByValueAndExpiryDateTimeGreaterThan(String tokenValue,
                                                            LocalDateTime localDateTime);


}
