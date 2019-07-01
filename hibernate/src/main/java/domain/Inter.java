package domain;

import connect.HibernateConnect;
import dao.BookDao;
import dao.impl.AuthorDaoImpl;
import dao.impl.BookDaoImpl;
import entity.Author;
import entity.Book;
import org.hibernate.Session;
import service.ShowCommand;

import java.util.Scanner;

class Inter {
    private long id;
    private long year;
    private long authorId;
    private long bookId;
    private String name;
    private String firstName;
    private String lastName;
    private String published;
    private String description;

    private static final Scanner scanner = new Scanner(System.in);

    private static void menu(){
        System.out.println("------------------------------");
        System.out.println("Add Author: 1");
        System.out.println("Update Author: 2");
        System.out.println("Delete Author: 3");
        System.out.println("Show All Author: 4");
        System.out.println("------------------------------");
        System.out.println("Add Book: 5");
        System.out.println("Update Book: 6");
        System.out.println("Delete Book: 7");
        System.out.println("Show all Book: 8");
        System.out.println("------------------------------");
        System.out.println("Show all Author by Book id: 9");
        System.out.println("Show all Book by Author id: 10");
        System.out.println("------------------------------");
        System.out.println("Exit: 11");
        System.out.println("------------------------------");
        System.out.println();
    }

    private static boolean comingSoon(){
        while (true) {
            System.out.println();
            System.out.println("continue? y/n");
            String ans = scanner.next();
            System.out.println();
            if (ans.equals("n")) return true;
            if (ans.equals("y")) return false;
        }
    }

    private static int getParam(String Names){
        System.out.println("Enter "+ Names +": ");
        return scanner.nextInt();
    }

    private static String getName(String Names){
        System.out.println("Enter "+ Names +": ");
        return scanner.next();
    }

    private void addAuthor(AuthorDaoImpl authorDaoImpl) {
        Author author = new Author();
        firstName = getName("FirstName");
        lastName = getName("lastName");
        year = getParam("year");
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setYear(year);

        authorDaoImpl.add(author);
    }

    private void updateAuthor(AuthorDaoImpl authorDaoImpl) {
        Author author = new Author();
        id = getParam("Id");
        firstName = getName("FirstName");
        lastName = getName("lastName");
        year = getParam("year");
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setYear(year);
        author.setId(id);
        authorDaoImpl.update(author);
    }

    private void deleteAuthor(AuthorDaoImpl authorDaoImpl) {
        Author author = new Author();
        id = getParam("id");
        author.setId(id);
        authorDaoImpl.delete(author);
    }

    private void outputAuthor() {
        System.out.println();
        new ShowCommand<>()
                .show(new AuthorDaoImpl(new HibernateConnect()).getAll());
        System.out.println();
    }

    private void addBook(BookDaoImpl bookDaoImpl) {
        Book book = new Book();
        name = getName("name");
        description = getName("description");
        published = getName("published");
        year = getParam("year");
        outputAuthor();
        authorId = getParam("authorId");
        book.setName(name);
        book.setDescription(description);
        book.setPublished(published);
        book.setYear(year);

        bookDaoImpl.add(book, authorId);
    }

    private void updateBook(BookDao bookDao) {
        Book book = new Book();
        id = getParam("id");
        name = getName("name");
        description = getName("description");
        published = getName("published");
        year = getParam("year");
        book.setName(name);
        book.setDescription(description);
        book.setPublished(published);
        book.setYear(year);
        book.setId(id);
        bookDao.update(book);
    }

    private void deleteBook(BookDaoImpl bookDaoImpl) {
        Book book = new Book();
        id = getParam("id");
        book.setId(id);
        bookDaoImpl.delete(book);
    }

    private void outputBook() {
        System.out.println();
        new ShowCommand<>()
                .show(new BookDaoImpl(new HibernateConnect()).getAll());
        System.out.println();
    }

    private void outputAuthorsByBookId() {
        bookId = getParam("bookId");
        new ShowCommand<Author>()
                .show(new AuthorDaoImpl(new HibernateConnect()).getAllByBookId(bookId));
    }

    private void outputBooksByAuthorId() {
        authorId = getParam("authorId");
        new ShowCommand<Book>()
                .show(new BookDaoImpl(new HibernateConnect()).getAllByAuthorId(authorId));
    }

    void setAction() {
        Session session = HibernateConnect.getSessionFactory().openSession();
        session.beginTransaction();

        AuthorDaoImpl authorDaoImpl = new AuthorDaoImpl(new HibernateConnect());
        BookDaoImpl bookDaoImpl = new BookDaoImpl(new HibernateConnect());

        while (true) {
            menu();
            int change = scanner.nextInt();
            switch (change) {
                case 1:
                    addAuthor(authorDaoImpl);
                    if(comingSoon()) return;
                    break;
                case 2:
                    updateAuthor(authorDaoImpl);
                    if(comingSoon()) return;
                    break;
                case 3:
                    deleteAuthor(authorDaoImpl);
                    if(comingSoon()) return;
                    break;
                case 4:
                    outputAuthor();
                    if(comingSoon()) return;
                    break;
                case 5:
                    addBook(bookDaoImpl);
                    if(comingSoon()) return;
                    break;
                case 6:
                    updateBook(bookDaoImpl);
                    if(comingSoon()) return;
                    break;
                case 7:
                    deleteBook(bookDaoImpl);
                    if(comingSoon()) return;
                    break;
                case 8:
                    outputBook();
                    if(comingSoon()) return;
                    break;
                case 9:
                    outputBooksByAuthorId();
                    if(comingSoon()) return;
                    break;
                case 10:
                    outputAuthorsByBookId();
                    if(comingSoon()) return;
                    break;
                case 11:
                    return;
            }
        }
    }
}
