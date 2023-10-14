package com.practice.library_management.models.entity.User;

import com.practice.library_management.models.entity.Book;
import com.practice.library_management.models.entity.Issue;
import com.practice.library_management.models.entity.User.dao.User;
import com.practice.library_management.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    @Autowired
    LibraryRepository libraryRepository;
    private List<Book> issuedBooks = new ArrayList<>();
    public Member(String username) {
        super(username);
    }

    public void issueBook(Book book) throws Exception {
        if(book.getIsIssued()){
            throw new Exception("Book already issued");
        }
        libraryRepository.reserveBook(book, this);
        issuedBooks.add(book);
        book.setIsIssued(true);
    }

    public void returnBook(Issue issue) throws Exception {
        if(!issue.getBook().getIsIssued()){
            throw new Exception("Book already returned");
        }
        libraryRepository.returnedBook(String.valueOf(issue.getId()));

        issuedBooks.remove(issue.getBook());
        issue.getBook().setIsIssued(false);
    }
}
