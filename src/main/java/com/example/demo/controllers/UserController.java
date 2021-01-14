package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("user/{id}/posts")
    public List<Post> getPostsByUser(@PathVariable Integer id){
        Optional<User> user = userService.getUserById(id);
        return user.map(User::getPosts).orElse(null);
    }

    @GetMapping("users/location/{id}/users")
    public List<User> getUserByLocation(@PathVariable Integer id){
        return userService.getUsersByLocation(id);
    }

    @PostMapping("/users/addNew")
    public void AddUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/users/{id}/update")
    public void UpdateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}/delete")
    public void DeleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
