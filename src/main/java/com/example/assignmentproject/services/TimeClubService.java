package com.example.assignmentproject.services;

import com.example.assignmentproject.beans.User;
import com.example.assignmentproject.controllers.AddResponse;
import com.example.assignmentproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Service
public class TimeClubService {
    //to access the UserRepository, we need to create a reference variable
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UserRepository userRep;

    //get all users
    public List getAllUsers() {
        return userRep.findAll();
    }

    //get users by id
    public User getUsersById(int id) {
        return userRep.findById(id).get();
    }

    //insert
    public User addUser(User user) {
        user.setId(getMaxId());
        user.setRow_creation_timestamp(LocalDateTime.now());
        userRep.save(user);
        return user;
    }

    //function to get the current id
    public int getMaxId() {
        return userRep.findAll().size() + 1;
    }

    //update user
    public User updateUser(User user) {
        userRep.save(user);
        return user;
    }

    //delete user
    public AddResponse deleteUser(int id) {
        userRep.deleteById(id);
        AddResponse response = new AddResponse();
        response.setMsg("User deleted..");
        response.setId(id);
        return response;
    }


}
