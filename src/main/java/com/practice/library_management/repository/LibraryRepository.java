package com.practice.library_management.repository;


import com.practice.library_management.models.entity.Book;
import com.practice.library_management.models.entity.Issue;
import com.practice.library_management.models.entity.User.dao.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibraryRepository {
    private Map<String, Book> availableBooksMap = new HashMap<>();
    private Map<String, Issue> issueBookMap = new HashMap<>();


    public ArrayList<Book> getAllBooks(){
        return (ArrayList<Book>) availableBooksMap.values();
    }

    public void addBookToShelf(Book book) throws Exception {
        if(isBookAlreadyInShelf(book)){
            throw new Exception("Book Already in shelf");
        }

        availableBooksMap.put(book.getName(), book);
    }

    public void removeBookFromShelf(Book book) throws Exception {
        if(!isBookAlreadyInShelf(book)){
            throw new Exception("Book Already in shelf");
        }

        availableBooksMap.remove(book.getName());
    }

    private boolean isBookAlreadyInShelf(Book book) throws Exception {
        return availableBooksMap.containsKey(book.getName());
    }

    public void reserveBook(Book book, User user) throws Exception {
        Issue issue = new Issue(user, book);
        issueBookMap.put(String.valueOf(issue.getId()), issue);
    }

    public void returnedBook(String issueId){
        issueBookMap.remove(issueId);
    }

    public ArrayList<Issue> getAllIssuedBooks(){
        return (ArrayList<Issue>) issueBookMap.values();
    }
}
