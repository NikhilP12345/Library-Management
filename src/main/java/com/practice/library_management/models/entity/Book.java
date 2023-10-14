package com.practice.library_management.models.entity;

import com.practice.library_management.models.entity.User.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Book {
    @Builder.Default
    private UUID id = UUID.randomUUID();
    private String name;
    private String title;
    private Author author;

    @Builder.Default
    private Boolean isIssued = false;

    public Book(String name, String title, Author author) {
        this.name = name;
        this.title = title;
        this.author = author;
    }

    public void issueBook(){
        this.isIssued = true;
    }

    public void returnBook(){
        this.isIssued = false;
    }
}