package com.anthonycano.studysync.service;

import org.springframework.stereotype.Service;
import com.anthonycano.studysync.repository.UserRepository;
import com.anthonycano.studysync.model.User;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Methods for data handling etc
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id"));
    }
}
