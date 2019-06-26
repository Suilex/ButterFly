import dao.connect.DBConnector;
import dao.impl.AuthorDaoImpl;
import dao.impl.BookAuthorDaoImpl;
import dao.impl.BookDaoImpl;
import entity.BookAuthor;
import service.ShowCommand;
import entity.Author;
import entity.Book;

import java.util.Scanner;

class Inter {

    private long id;
    private long year;
    private long authorId;
    private String name;
    private String firstName;
    private String lastName;
    private String published;
    private String description;

    private static final Scanner scanner = new Scanner(System.in);

    private static void menu(){
        System.out.println("------------------------------");
        System.out.println("Add Author, press key: 1");
        System.out.println("Update Author, press key: 2");
        System.out.println("Delete Author, press key: 3");
        System.out.println("Show All Author, press key: 4");
        System.out.println("------------------------------");
        System.out.println("Add Book, press key: 5");
        System.out.println("Update Book, press key: 6");
        System.out.println("Delete Book, press key: 7");
        System.out.println("Show all Book, press key: 8");
        System.out.println("------------------------------");
        System.out.println("Show all Author by Book id: 9");
        System.out.println("Show all Book by Author id: 10");
        System.out.println("------------------------------");
        System.out.println("Exit, press key: 11");
        System.out.println("------------------------------");
        System.out.println();
    }

    private static boolean comingSoon(){
        while (true) {
            System.out.println();
            System.out.println("continue? y/n");
            String ans = scanner.next();
            System.out.println();
            if (ans.equals("n")) return false;
            if (ans.equals("y")) return true;
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

    private void deleteAuthor(AuthorDaoImpl authorDaoImpl, BookAuthorDaoImpl bookAuthorDaoImpl) {
        Author author = new Author();
        BookAuthor bookAuthor = new BookAuthor();
        id = getParam("id");
        author.setId(id);
        authorDaoImpl.delete(author);
        bookAuthor.setAuthorId(id);
        bookAuthorDaoImpl.deleteAuthor(bookAuthor);
    }

    private void outputAuthor() {
        System.out.println();
        new ShowCommand<Author>()
                .show(new AuthorDaoImpl(new DBConnector()).getAll());
        System.out.println();
    }

    private void outputAuthorsByBookId() {
        outputBook();
        id = getParam("BookId");
        new ShowCommand<Author>()
                .show(new AuthorDaoImpl(new DBConnector()).getAllByBookId(id));
    }

    private void addBook(BookDaoImpl bookDaoImpl, BookAuthorDaoImpl bookAuthorDaoImpl) {
        Book book = new Book();
        BookAuthor bookAuthor = new BookAuthor();
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
        book.setAuthorId(authorId);
        bookDaoImpl.add(book);

        bookAuthor.setAuthorId(authorId);
        bookAuthor.setBookId(new BookDaoImpl(new DBConnector()).getBookIdByBookName(name));
        bookAuthorDaoImpl.add(bookAuthor);
    }

    private void updateBook(BookDaoImpl bookDaoImpl) {
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
        bookDaoImpl.update(book);
    }

    private void deleteBook(BookDaoImpl bookDaoImpl, BookAuthorDaoImpl bookAuthorDaoImpl) {
        Book book = new Book();
        BookAuthor bookAuthor = new BookAuthor();
        id = getParam("id");
        book.setId(id);
        bookDaoImpl.delete(book);
        bookAuthor.setBookId(id);
        bookAuthorDaoImpl.deleteBook(bookAuthor);
    }

    private void outputBook() {
        System.out.println();
        new ShowCommand<Book>()
                .show(new BookDaoImpl(new DBConnector()).getAll());
        System.out.println();
    }

    private void outputBooksByAuthorId() {
        outputAuthor();
        id = getParam("AuthorId");
        new ShowCommand<Book>()
                .show(new BookDaoImpl(new DBConnector()).getBooksByAuthor(id));
    }

    void setAction() {
        DBConnector conn = new DBConnector();
        AuthorDaoImpl authorDaoImpl = new AuthorDaoImpl(conn);
        BookDaoImpl bookDaoImpl = new BookDaoImpl(conn);
        BookAuthorDaoImpl bookAuthorDaoImpl = new BookAuthorDaoImpl(conn);

        while (true) {
            menu();
            int change = scanner.nextInt();
            switch (change) {
                case 1:
                    addAuthor(authorDaoImpl);
                    if(!comingSoon()) return;
                    break;
                case 2:
                    updateAuthor(authorDaoImpl);
                    if(!comingSoon()) return;
                    break;
                case 3:
                    deleteAuthor(authorDaoImpl, bookAuthorDaoImpl);
                    if(!comingSoon()) return;
                    break;
                case 4:
                    outputAuthor();
                    if(!comingSoon()) return;
                    break;
                case 5:
                    addBook(bookDaoImpl, bookAuthorDaoImpl);
                    if(!comingSoon()) return;
                    break;
                case 6:
                    updateBook(bookDaoImpl);
                    if(!comingSoon()) return;
                    break;
                case 7:
                    deleteBook(bookDaoImpl, bookAuthorDaoImpl);
                    if(!comingSoon()) return;
                    break;
                case 8:
                    outputBook();
                    if(!comingSoon()) return;
                    break;
                case 9:
                    outputBooksByAuthorId();
                    if(!comingSoon()) return;
                    break;
                case 10:
                    outputAuthorsByBookId();
                    if(!comingSoon()) return;
                    break;
                case 11:
                    return;
            }
        }
    }
}

