package ru.library.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class LibraryappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryappApplication.class, args);
    }

}
