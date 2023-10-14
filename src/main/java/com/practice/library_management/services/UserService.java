package com.practice.library_management.services;

import com.practice.library_management.repository.UserManagerRepository;
import com.practice.library_management.models.dto.user.CreateUserDto;
import com.practice.library_management.models.dto.user.GetUserDto;
import com.practice.library_management.models.entity.User.dao.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserManagerRepository userManagerRepository;

    UserService(UserManagerRepository userManagerRepository){
        this.userManagerRepository = userManagerRepository;
    }
    public void createUserAndSave(CreateUserDto createUserDto) throws Exception {
        try{
            this.userManagerRepository.createUser(createUserDto);
        }
        catch (Exception error){
            System.out.println("Error at createUser");
            throw error;
        }
    }

    public User getUserByUsername(GetUserDto getUserDto) throws Exception {
        try{
            return this.userManagerRepository.getUser(getUserDto.getUsername());
        }
        catch (Exception error){
            System.out.println("Error at getUserByUsername");
            throw error;
        }
    }
}
