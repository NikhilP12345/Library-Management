package com.practice.library_management.models.entity.User.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class User {

    @Builder.Default
    private UUID id = UUID.randomUUID();
    private final String username;
}
