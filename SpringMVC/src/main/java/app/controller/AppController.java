package app.controller;

import app.entity.Author;
import app.entity.Book;
import app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.service.AuthorService;
import vo.AuthorWithBookId;
import vo.BookWithAuthor;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    public AuthorService authorService;

    @Autowired
    public BookService bookService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/author")
    public String getAllAuthor (Model model){
        model.addAttribute("authors", authorService.getAll());
        return "author";
    }

    @GetMapping("/book")
    public String getAllBook (Model model){
        model.addAttribute("books", bookService.getAll());
        return "book";
    }

    @GetMapping("/author/{Id}")
    public String deleteAuthor(@PathVariable("Id") int Id){
        Author author = new Author();
        author.setId((long)Id);
        authorService.delete(author);
        return "redirect:/author";
    }

    @GetMapping("/book/{Id}")
    public String deleteBook(@PathVariable("Id") int Id){
        Book book = new Book();
        book.setId((long)Id);
        bookService.delete(book);
        return "redirect:/book";
    }

    @GetMapping("/editAuthor/{Id}")
    public String editAuthor(Model model, @PathVariable("Id") int Id){
        model.addAttribute("author", authorService.getAuthorByAuthorId(Id));
        List<Book> added= bookService.getAllByAuthorId(Id);
        model.addAttribute("bookList", added);
        List<Book> all = bookService.getAll();
        for(Book item : added)
            for (Book book : all)
                if(item.getId() == book.getId()){
                    all.remove(book);
                    break;
                }
        model.addAttribute("books", all);
        return "editAuthor";
    }

    @PostMapping("/editAuthor/{Id}")
    public String editAuthor(@ModelAttribute("author") AuthorWithBookId authorWithBookId){
        Author author = new Author();
        author.setId(authorWithBookId.getId());
        author.setFirstName(authorWithBookId.getFirstName());
        author.setLastName(authorWithBookId.getLastName());
        author.setYear(authorWithBookId.getYear());
        authorService.update(author, authorWithBookId.getBookId());
        return "redirect:/author";
    }

    @GetMapping("/editBook/{Id}")
    public String editBook(Model model, @PathVariable("Id") int Id){
        model.addAttribute("book", bookService.getBookByBookId(Id));
        List<Author> added= authorService.getAllByBookId((long)Id);
        model.addAttribute("authorList", added);
        List<Author> all = authorService.getAll();
        for(Author item : added)
            for (Author author : all)
                if(item.getId() == author.getId()){
                    all.remove(author);
                    break;
                }
        model.addAttribute("authors", all);
        return "editBook";
    }

    @PostMapping("/editBook/{Id}")
    public String editBook(@ModelAttribute("book") BookWithAuthor bookWithAuthor){
        Book book = new Book();
        book.setId(bookWithAuthor.getId());
        book.setName(bookWithAuthor.getName());
        book.setDescription(bookWithAuthor.getDescription());
        book.setPublished(bookWithAuthor.getPublished());
        book.setYear(bookWithAuthor.getYear());
        bookService.update(book, bookWithAuthor.getAuthorId());
        return "redirect:/book";
    }

    @PostMapping("/addauthor")
    public String addAuthor(@ModelAttribute("author") Author author){
        authorService.add(author);
        return "redirect:/author";
    }

    @GetMapping("/addbook")
    public String addBook(Model model){
        model.addAttribute("authorList", authorService.getAll());
        return "addBook";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute("book") BookWithAuthor bookWithAuthor){
        Book book = new Book();
        book.setName(bookWithAuthor.getName());
        book.setDescription(bookWithAuthor.getDescription());
        book.setPublished(bookWithAuthor.getPublished());
        book.setYear(bookWithAuthor.getYear());
        bookService.add(book, bookWithAuthor.getAuthorId());
        return "redirect:/book";
    }

    @GetMapping("/pageAuthor/{Id}")
    public String pageAuthor(@PathVariable("Id") int Id, Model model){
        model.addAttribute("Name", authorService.getAuthorByAuthorId((long)Id));
        model.addAttribute("books", bookService.getAllByAuthorId((long)Id));
        return "pageAuthor";
    }

    @GetMapping("/pageBook/{Id}")
    public String pageBook(@PathVariable("Id") int Id, Model model){
        model.addAttribute("Name", bookService.getBookByBookId((long)Id));
        model.addAttribute("authors", authorService.getAllByBookId((long)Id));
        return "pageBook";
    }
}
