package ru.library.libraryapp.service;

import org.springframework.stereotype.Service;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepo;

    public AuthorService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> getAuthorSetById() {
        return authorRepo.getAuthorSetById();
    }
}
