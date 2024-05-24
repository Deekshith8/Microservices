package com.microservicesDemo.UserService.userService;

import com.microservicesDemo.UserService.userEntity.UserEntity;
import com.microservicesDemo.UserService.userRepo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepo userRepo;

    @Override
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity>users=userRepo.findAllUsers();


        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> saveUser(UserEntity user) {
        userRepo.save(user);
        return new ResponseEntity<>(user.getUserId(),HttpStatus.CREATED) ;
    }

    @Override
    public ResponseEntity<HttpStatus> updateUser(int id, UserEntity user) {

        if (userRepo.existsById(id)){
            UserEntity tempUser=userRepo.findById(id).get();
            tempUser.setUserName(user.getUserName());
            tempUser.setUserCity(user.getUserCity());
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<HttpStatus> deleteUserById(int id) {

        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }




}
