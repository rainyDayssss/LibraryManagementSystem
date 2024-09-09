// TALISIC, JHON ROSELL B.
import java.util.ArrayList;
import java.util.Scanner;

public class LMS {
    Scanner scan = new Scanner(System.in);
    private final ArrayList<Book> bookList = new ArrayList<>();
    private boolean inBookList = false;

    public LMS() {
        startApp();
    }

    public void startApp() {
        boolean isExiting = false;
        do {
            try {
                System.out.println("\n======================================");
                System.out.println("|  LIBRARY MANAGEMENT SYSTEM         |");
                System.out.println("======================================");
                System.out.println("|  1. Create Book                    |");
                System.out.println("|  2. Borrow Book                    |");
                System.out.println("|  3. Return Book                    |");
                System.out.println("|  4. View Book Detail               |");
                System.out.println("|  5. Exit App                       |");
                System.out.println("======================================");
                System.out.print("|  Enter the number: ");
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        createBook();
                        break;
                    case 2:
                        borrowBook();
                        break;
                    case 3:
                        returnBook();
                        break;
                    case 4:
                        viewBookDetail();
                        break;
                    case 5:
                        isExiting = true;
                        break;
                    default:
                        System.out.println("\n======================================");
                        System.out.println("   INVALID INPUT!");
                }
            }
            catch (Exception e) {
                System.out.println("\n======================================");
                System.out.println("   INVALID INPUT!");
                scan.nextLine();
            }
            finally {
                System.out.println("======================================");
            }
        } while (!isExiting);
        System.out.println("\n   ENDED APP");
    }

    public void createBook() {
        try {
            scan.nextLine();
            System.out.println("\n======================================");
            System.out.print("|  Title: ");
            String title = scan.nextLine();
            if (!isTitleValid(title)) {
                System.out.println("\n   INVALID TITLE!");
                return;
            }

            System.out.print("|  Author: ");
            String author = scan.nextLine();
            if (!isAuthorValid(author)) {
                System.out.println("\n   INVALID AUTHOR!");
                return;
            }

            System.out.print("|  Internation Standard Book Number \n|  (ISBN - 13 Digits Format): ");
            ISBN isbn = new ISBN();
            isbn.setIsbn();
            if (!isIsbnValid(isbn.getIsbnStr())) {
                System.out.println("\n   INVALID ISBN!");
                return;
            }


            System.out.print("|  Available Copies: ");
            String availableCopies = scan.nextLine();
            if (!isAvailableCopiesValid(availableCopies)) {
                System.out.println("\n   AT LEAST 1 COPY IS NEEDED!");
                return;
            }

            addBook(new Book(title, author, isbn.getIsbnStr(), Integer.parseInt(availableCopies)));

            }
        catch (Exception e) {
            System.out.println("\n======================================");
            System.out.println("   INVALID COPIES!");
        }
    }

    public void addBook(Book book) {
        inBookList = false;
        for (Book bookIterator : bookList) {
            if (bookIterator.getIsbn().equals(book.getIsbn())) {
                inBookList = true;
                System.out.println("\n   THE BOOK WAS ALREADY CREATED!");
                break;
            }

        }
        if (!inBookList) {
            bookList.add(book);
            System.out.println("\n   SUCCESSFULLY CREATED THE BOOK!");
        }
    }

    public void borrowBook() {
        scan.nextLine();
        System.out.println("\n======================================");
        if (isBookListEmpty())
            return;
        inBookList = false;
        System.out.print("|  ISBN: ");
        String isbn = scan.nextLine();

        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                inBookList = true;
                if (book.getAvailableCopies() == 0) {
                    System.out.println("\n   CANNOT BORROW A BOOK!");
                    System.out.println("   AVAILABLE COPIES: " + book.getAvailableCopies());
                    break;
                }
                book.borrowCopies(1);
                System.out.println("\n   SUCCESSFULLY BORROWED A BOOK!");
                break;
            }
        }

        if (!inBookList)
            System.out.println("\n   THE BOOK HAS NOT BEEN CREATED YET!");
    }

    public void returnBook() {
        scan.nextLine();
        System.out.println("\n======================================");
        if (isBookListEmpty())
            return;
        inBookList = false;
        System.out.print("|  ISBN: ");
        String isbn = scan.nextLine();

        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                inBookList = true;
                if (book.getBorrowedCopies() == 0) {
                    System.out.println("\n   CANNOT RETURN THE BOOK!");
                    System.out.println("   BORROWED COPIES: " + book.getBorrowedCopies());
                    break;
                }
                book.returnCopies(1);
                System.out.println("\n   SUCCESSFULLY RETURNED THE BOOK!" );
                System.out.println("   TITLE: " + book.getTitle());
                break;
            }
        }

        if (!inBookList)
            System.out.println("\n   THE BOOK HAS NOT BEEN CREATED YET!");
    }

    public void viewBookDetail() {
        scan.nextLine();
        System.out.println("\n======================================");
        if (isBookListEmpty())
            return;

        inBookList = false;
        System.out.print("|  ISBN: ");
        String isbn = scan.nextLine();

        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                inBookList = true;
                System.out.println("\n   BOOK DETAIL: ");
                System.out.println("   Title: " + book.getTitle());
                System.out.println("   Author: " + book.getAuthor());
                System.out.println("   ISBN: " + book.getIsbn());
                System.out.println("   Available Copies: " + book.getAvailableCopies());
                break;
            }
        }
        if (!inBookList)
            System.out.println("\n   THE BOOK HAS NOT BEEN CREATED YET!");
    }

    private boolean isTitleValid(String title) {
        return !title.isEmpty();
    }


    private boolean isAuthorValid(String author) {
        return !author.isEmpty();
    }

    private boolean isIsbnValid(String isbn) {
        return isbn.length() == 17;
    }

    private boolean isAvailableCopiesValid(String copies) {
        return Integer.parseInt(copies) > 0;
    }

    private boolean isBookListEmpty() {
        if (bookList.isEmpty()) {
            System.out.println("   THE ARE NO BOOKS CREATED YET!");
            return true;
        }
        else
            return false;
    }


}
