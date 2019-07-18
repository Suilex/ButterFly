package ru.library.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.library.libraryapp.entity.Author;
import ru.library.libraryapp.service.AuthorService;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/apps")
    public List<Author> book() {
        return authorService.getAuthorSetById();
    }
}
