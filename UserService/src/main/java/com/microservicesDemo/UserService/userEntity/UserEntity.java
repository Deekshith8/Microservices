package com.microservicesDemo.UserService.userEntity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "userdb")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    private String userCity;

    public UserEntity() {
    }

    public UserEntity(String userName, String userCity) {
        this.userName = userName;
        this.userCity = userCity;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

}
