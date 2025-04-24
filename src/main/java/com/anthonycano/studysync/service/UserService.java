package com.anthonycano.studysync.service;

import org.springframework.stereotype.Service;
import com.anthonycano.studysync.repository.UserRepository;
import com.anthonycano.studysync.model.User;
import java.util.List;
import java.util.Optional;

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

    public User updateUser(Long id, User updatedUser){

        // We will have the same user ID to save resources, but we will save the new data.
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id"));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }


}
