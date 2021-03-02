package com.eunchae.restaurantbooker.application;

import com.eunchae.restaurantbooker.domain.User;
import com.eunchae.restaurantbooker.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new EmailNotExistedException(email));


        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordWrongException();
        }

        return user;
    }

}
