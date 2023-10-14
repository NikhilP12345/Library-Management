package com.practice.library_management.repository;

import com.practice.library_management.models.dto.user.CreateUserDto;
import com.practice.library_management.models.entity.User.Author;
import com.practice.library_management.models.entity.User.Librarian;
import com.practice.library_management.models.entity.User.Member;
import com.practice.library_management.models.entity.User.dao.User;
import com.practice.library_management.models.enums.UserType;

import java.util.HashMap;
import java.util.Map;


//direct factory pattern, can make one more layer as abstract factory
public class UserManagerRepository {
    private Map<String, User> users = new HashMap<>();

    public void createUser(CreateUserDto createUserDto) throws Exception {
        String username = createUserDto.getUsername();
        UserType userType = createUserDto.getUserType();
        if(this.ifUserExistByUsername(username)){
            throw new Exception("Username already exists");
        }


        User user;

        switch (userType){
            case AUTHOR:
                user = new Author(username);
                break;
            case LIBRARIAN:
                user = new Librarian(username);
                break;
            case MEMBER:
                user = new Member(username);
                break;
            default:
                throw new Exception("User Type " + userType + " not exist");
        }
        this.setUser(username, user);
    }

    public User getUser(String username) throws Exception {
        User user =  users.get(username);
        if(user == null){
            throw new Exception("Username not exist");
        }
        return user;
    }

    public void setUser(String username, User user) {
        users.put(username, user);
    }

    public boolean ifUserExistByUsername(String username){
        return users.containsKey(username);
    }



}
