package com.practice.library_management.models.entity.User;

import com.practice.library_management.models.dto.book.UpdateBookDto;
import com.practice.library_management.models.entity.Book;
import com.practice.library_management.models.entity.User.dao.User;

// Assuming Book has one author
public class Author extends User {

    public Author(String username){
        super(username);
    }

    void updateBook(UpdateBookDto updateBookDto, Book book){
        if(updateBookDto.getName() != null){
            book.setName(updateBookDto.getName());
        }
        if(updateBookDto.getTitle() != null){
            book.setTitle(updateBookDto.getTitle());
        }
    }

}
