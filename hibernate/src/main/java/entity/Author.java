package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "year")
    private long year;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   /* @JoinTable(
            name = "BA",
            joinColumns = @JoinColumn(name = "AuthorId"),
            inverseJoinColumns = @JoinColumn(name = "BookId"),
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"AuthorId", "BookId"})
            }
    )*/

    @MapKeyJoinColumns(
            value = {
            @MapKeyJoinColumn(name = "AuthorId"),
            @MapKeyJoinColumn(name = "BookId")
    })

     /*@JoinTable (
             name = "BA",

             joinColumns = @JoinColumn(name = "AuthorId"),
             inverseJoinColumns = @JoinColumn(name = "BookId")
    )*/



    private Set<Book> bookSet;

    public Author() {

    }

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                //", bookSet=" + bookSet +
                '}';
    }

}