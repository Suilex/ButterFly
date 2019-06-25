package entity;

public class BookAuthor {

    private long authorId;
    private long bookId;

    public BookAuthor() {

    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookAuthor bookAuthor = (BookAuthor) o;

        if (authorId != bookAuthor.authorId) return false;
        return bookId == bookAuthor.bookId;
    }

    @Override
    public int hashCode() {
        int result = (int) (authorId ^ (authorId >>> 32));
        result = 31 * result + (int) (bookId ^ (bookId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "BookAuthor{" +
                "authorId=" + authorId +
                ", bookId=" + bookId +
                '}';
    }
}
