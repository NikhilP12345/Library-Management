package com.practice.library_management.models.entity;

import com.practice.library_management.models.entity.User.dao.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Issue {
    @Builder.Default
    private UUID id = UUID.randomUUID();
    private User user;
    private Book book;

    public Issue(User user, Book book) {
        this.user = user;
        this.book = book;
    }
}
