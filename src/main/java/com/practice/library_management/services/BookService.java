package com.practice.library_management.services;

import com.practice.library_management.models.entity.User.Author;
import com.practice.library_management.models.entity.User.Librarian;
import com.practice.library_management.models.entity.User.dao.User;
import com.practice.library_management.repository.LibraryRepository;
import com.practice.library_management.models.dto.book.CreateBookDto;
import com.practice.library_management.repository.UserManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private LibraryRepository libraryRepository;
    private UserManagerRepository userManagerRepository;

    BookService(LibraryRepository libraryRepository, UserManagerRepository userManagerRepository) {
        this.libraryRepository = libraryRepository;
        this.userManagerRepository = userManagerRepository;
    }
    public void createBook(CreateBookDto createBookDto) throws Exception {
        try{
            User user = userManagerRepository.getUser(createBookDto.getUserName());
            if(!(user instanceof Librarian)){
                throw new Exception("Access Denied");
            }
            User author = userManagerRepository.getUser(createBookDto.getAuthorName());
            if(!(user instanceof Author)){
                throw new Exception("Invalid Author");
            }
            ((Librarian) user).addBook(
                    createBookDto.getName(),
                    createBookDto.getTitle(),
                    (Author) author
            );
        }
        catch (Exception error){
            System.out.println("Error at createBook");
            throw error;
        }
    }
}
