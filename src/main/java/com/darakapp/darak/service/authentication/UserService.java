package com.darakapp.darak.service.authentication;

import com.darakapp.darak.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
   private final PasswordEncoder passwordEncoder;
   private final UserRepository userRepository;

   public boolean phoneNumberExists(String phoneNumber) {
       return userRepository.existsByPhoneNumberHash(passwordEncoder.encode(phoneNumber));
   }
}
