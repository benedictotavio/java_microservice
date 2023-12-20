package com.br.auth_control.services;

import com.br.auth_control.model.User;
import com.br.auth_control.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
