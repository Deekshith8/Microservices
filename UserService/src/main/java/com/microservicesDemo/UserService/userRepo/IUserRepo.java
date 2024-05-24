package com.microservicesDemo.UserService.userRepo;

import com.microservicesDemo.UserService.userEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends JpaRepository<UserEntity,Integer> {

    @Query(value = "Select *  from Users",  nativeQuery = true)
    List<UserEntity> findAllUsers();
}
