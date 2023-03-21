package com.example.proyectoBackendOdontolo.service;

import com.example.proyectoBackendOdontolo.entities.security.Roll;
import com.example.proyectoBackendOdontolo.entities.security.UserEntity;
import com.example.proyectoBackendOdontolo.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoadUsers implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public LoadUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass1 = passwordEncoder.encode("password1");
        userRepository.save(new UserEntity("pepita", "fulano", "pepita@ggmail.com", pass1, Roll.ROLL_USER));

        String pass2 = passwordEncoder.encode("password2");
        userRepository.save(new UserEntity("pepito", "fulano", "pepito@ggmail.com", pass2, Roll.ROLL_ADMIN));
    }
}
