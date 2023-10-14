package com.practice.library_management.models.entity.User;

import com.practice.library_management.models.entity.Book;
import com.practice.library_management.models.entity.User.dao.User;
import com.practice.library_management.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Librarian extends User {
    @Autowired
    LibraryRepository libraryRepository;
    public Librarian(String username) {
        super(username);
    }



    public void addBook(String name, String title, Author author) throws Exception {
        libraryRepository.addBookToShelf(new Book(
                name,
                title,
                author
        ));
    }

    public void removeBook(Book book) throws Exception {
        libraryRepository.removeBookFromShelf(book);
    }
}
