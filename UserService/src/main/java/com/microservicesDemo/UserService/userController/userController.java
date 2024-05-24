package com.microservicesDemo.UserService.userController;

import com.microservicesDemo.UserService.userEntity.UserEntity;
import com.microservicesDemo.UserService.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class userController {


    @Autowired
    private IUserService  userservice;


    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return  userservice.getAllUsers();
    }


    @PostMapping("/saveUser")
    public ResponseEntity<Integer>saveBook(@RequestBody UserEntity user){

        return  userservice.saveUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<HttpStatus>updateBook(@PathVariable int id,@RequestBody UserEntity user){
        return userservice.updateUser(id,user);
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus>deleteBookById(@PathVariable int id){
        return  userservice.deleteUserById(id);
    }


}
