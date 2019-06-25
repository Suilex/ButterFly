import dao.connect.DBConnector;
import dao.impl.AuthorDaoImpl;
import dao.impl.BookAuthorDaoImpl;
import dao.impl.BookDaoImpl;
import service.ShowCommand;
import entity.Author;
import entity.Book;
import entity.BookAuthor;

import java.util.Scanner;

public class Inter {

    private static void menu(){
        System.out.println("------------------------------");
        System.out.println("add Author, press key: 1");
        System.out.println("Edit Author, press key: 2");
        System.out.println("delete Author, press key: 3");
        System.out.println("Show All Author, press key: 4");
        System.out.println("------------------------------");
        System.out.println("add Book, press key: 5");
        System.out.println("Edit Book, press key: 6");
        System.out.println("delete Book, press key: 7");
        System.out.println("Show All Book, press key: 8");
        System.out.println("------------------------------");
        System.out.println("add link to AuthorBook, press key: 9");
        System.out.println("delete link to AuthorBook, press key: 10");
        System.out.println("------------------------------");
        System.out.println("Exit, press key: 11");
        System.out.println("------------------------------");
        System.out.println();
    }

    private static boolean ans(){
        while (true) {
            System.out.println();
            System.out.println("continue? y/n");
            String ans = scanner.next();
            System.out.println();
            if (ans.equals("n")) return false;
            if (ans.equals("y")) return true;
        }
    }

    private static int insertId(String Names){
        System.out.println("Enter "+ Names +": ");
        return scanner.nextInt();
    }

    private static String InsertName(String Names){
        System.out.println("Enter "+ Names +": ");
        return scanner.next();
    }

    private static int deleteId(){
        System.out.println("Enter Id: ");
        return scanner.nextInt();
    }

    private static int editId(String Names){
        System.out.println("Enter edit " + Names + ": ");
        return scanner.nextInt();
    }

    private static String editName(String Names){
        System.out.println("Enter edit " + Names + ": ");
        return scanner.next();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public void ent() {
        DBConnector conn = new DBConnector();

        AuthorDaoImpl authorDaoImpl = new AuthorDaoImpl(conn);
        BookDaoImpl bookDaoImpl = new BookDaoImpl(conn);
        BookAuthorDaoImpl bookAuthorDaoImpl = new BookAuthorDaoImpl(conn);

        while (true) {
            Author author = new Author();
            Book book = new Book();
            BookAuthor bookAuthor = new BookAuthor();

            menu();
            int change = scanner.nextInt();
            switch (change) {
                case 1:
                    String firstName = InsertName("FirstName");
                    String lastName = InsertName("lastName");
                    int year = insertId("year");
                    author.setFirstName(firstName);
                    author.setLastName(lastName);
                    author.setYear(year);
                    authorDaoImpl.add(author);
                    if(!ans()) return;
                    break;
                case 2:
                    int id = editId("Id");
                    firstName = editName("FirstName");
                    lastName = editName("lastName");
                    year = editId("year");
                    author.setFirstName(firstName);
                    author.setLastName(lastName);
                    author.setYear(year);
                    author.setId(id);
                    authorDaoImpl.update(author);
                    if(!ans()) return;
                    break;
                case 3:
                    id = deleteId();
                    author.setId(id);
                    authorDaoImpl.delete(author);
                    if(!ans()) return;
                    break;
                case 4:
                    new ShowCommand<Author>()
                            .show(new AuthorDaoImpl(new DBConnector()).getAll());
                    if(!ans()) return;
                    break;
                case 5:
                    String name = InsertName("name");
                    String description = InsertName("description");
                    String puplished = InsertName("puplished");
                    year = insertId("year");
                    int authorId = insertId("authorId");
                    book.setName(name);
                    book.setDescription(description);
                    book.setPublished(puplished);
                    book.setYear(year);
                    book.setAuthorId(authorId);
                    bookDaoImpl.add(book);
                    if(!ans()) return;
                    break;
                case 6:
                    id = editId("Id");
                    name = editName("name");
                    description = editName("description");
                    puplished = editName("puplished");
                    year = editId("year");
                    authorId = insertId("authorId");
                    book.setName(name);
                    book.setDescription(description);
                    book.setPublished(puplished);
                    book.setYear(year);
                    book.setAuthorId(authorId);
                    book.setId(id);
                    bookDaoImpl.update(book);
                    if(!ans()) return;
                    break;
                case 7:
                    id = deleteId();
                    book.setId(id);
                    bookDaoImpl.delete(book);
                    if(!ans()) return;
                    break;
                case 8:
                    new ShowCommand<Book>()
                            .show(new BookDaoImpl(new DBConnector()).getAll());
                    if(!ans()) return;
                    break;
                case 9:
                    id = editId("AuthorId");
                    int id2 = editId("BookId");
                    bookAuthor.setAuthorId(id);
                    bookAuthor.setBookId(id2);
                    bookAuthorDaoImpl.add(bookAuthor);
                    break;
                case 10:
                    int a;
                    while (true) {
                        System.out.println("Who do you want to remove? (Author: 1, Book: 2)");
                        a = scanner.nextInt();
                        if (a == 1 || a == 2) break;
                    }
                    id = editId("Id");
                    if (a == 1) {
                        bookAuthor.setAuthorId(id);
                        bookAuthorDaoImpl.deleteAuthor(bookAuthor);
                    }
                    else {
                        bookAuthor.setBookId(id);
                        bookAuthorDaoImpl.deleteBook(bookAuthor);
                    }
                    break;
                case 11:
                    return;
                case 12:
                    id = editId("Id");
                    name = editName("Name BD");
                    new ShowCommand<BookAuthor>().show(new BookAuthorDaoImpl(new DBConnector()).getAllByParamNameAndValue(id, name));
                    if(!ans()) return;
                    break;
                case 13:
                    new ShowCommand<BookAuthor>().show(new BookAuthorDaoImpl(new DBConnector()).getAll());
                    if(!ans()) return;
                    break;
                case 14:
                    id = editId("Id");
                    new ShowCommand<Author>()
                            .show(new AuthorDaoImpl(new DBConnector()).getAllByBookId(id));
                    if(!ans()) return;
                    break;
            }
        }
    }
}

