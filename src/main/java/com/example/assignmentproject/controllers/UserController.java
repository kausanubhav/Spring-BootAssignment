package com.example.assignmentproject.controllers;

import com.example.assignmentproject.beans.User;
import com.example.assignmentproject.services.TimeClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

//Controller class will interact with the TimeClubService
@RestController //shows that this is a controller class
public class UserController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TimeClubService timeclubService;

    //implement all requests

    //all users request
    @GetMapping("/get-users")
    public List<User> getUsers() {
        return timeclubService.getAllUsers();
    }

    //request user by id
    @GetMapping("/get-user/{id}")
    public User getUsersById(@PathVariable(value = "id") int id) {
        try {
            User user = timeclubService.getUsersById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK).getBody();
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND).getBody();
        }

    }


    //insert user

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return timeclubService.addUser(user);
    }

    //update user
    @PutMapping("/update-user/{id}")
    public User updateUser(@PathVariable(value = "id") int id, @RequestBody User user) {
        try {
            User userToBeUpdated = timeclubService.getUsersById(id);
            userToBeUpdated.setName(user.getName());
            userToBeUpdated.setAddress(user.getAddress());
            userToBeUpdated.setPincode(user.getPincode());
            userToBeUpdated.setState(user.getState());
            userToBeUpdated.setRow_creation_timestamp(LocalDateTime.now());
            User updatedUser = timeclubService.updateUser(userToBeUpdated);
            return new ResponseEntity<User>(updatedUser, HttpStatus.OK).getBody();
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT).getBody();
        }
    }

    //delete user
    @DeleteMapping("/delete-user/{id}")
    public AddResponse deleteUser(@PathVariable(value = "id") int id) {
        return timeclubService.deleteUser(id);
    }


}
