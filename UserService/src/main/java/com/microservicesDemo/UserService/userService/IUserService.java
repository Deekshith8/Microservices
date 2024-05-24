package com.microservicesDemo.UserService.userService;

import com.microservicesDemo.UserService.userEntity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<List<UserEntity>> getAllUsers();

    ResponseEntity<Integer> saveUser(UserEntity user);

    ResponseEntity<HttpStatus> updateUser(int id, UserEntity user);

    ResponseEntity<HttpStatus> deleteUserById(int id);
}
