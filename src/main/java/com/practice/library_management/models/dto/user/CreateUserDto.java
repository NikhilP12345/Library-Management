package com.practice.library_management.models.dto.user;

import com.practice.library_management.models.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateUserDto {
    private String username;
    private UserType userType; // can be enum, in real scenerio we would have create api for every user;
}
