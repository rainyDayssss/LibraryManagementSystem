// TALISIC, JHON ROSELL B.
public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private int availableCopies = 0;
    private int originalCopies = 0;


    public Book(String title, String author, String isbn, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        setAvailableCopies(availableCopies);
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    // for initializing available copies and adding future copies of the book
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies += availableCopies;
        originalCopies += availableCopies;
    }

    public void borrowCopies(int copies) {
        availableCopies -= copies;
    }

    public void returnCopies(int copies) {
        availableCopies += copies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public int getOriginalCopies() {
        return originalCopies;
    }


    public int getBorrowedCopies() {
        return originalCopies - availableCopies;
    }


}
