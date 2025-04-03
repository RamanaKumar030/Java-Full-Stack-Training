//Librarymanage\Library\Books\Books.java
package Library.Books;

public class Books {
    private String title;
    private String author;
    private int bookId;

    public Books(String title, String author, int bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}

//Librarymanage\Library\Books\Members.java
package Library.Members;

public class Members {
    private String name;
    private int memberId;

    public Members(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
}

    public void displayMember() {
        System.out.println("Member ID: " + memberId + ", Name: " + name);
    }
}

//Librarymanage\Library\Books\Utils.java
package Library.Utils;

import java.util.Random;

public class Utils {
    public static int generateId() {
        return new Random().nextInt(9000) + 1000; // Generates a 4-digit ID
    }
}


//Librarymanage\Library\Main.java
package Library; // Place Main.java in "Library" folder

import Library.Books.Books;
import Library.Members.Members;
import Library.Utils.Utils;

public class Main {
    public static void main(String[] args) {
        // Creating a book
        Books book1 = new Books("The Great Gatsby", "F. Scott Fitzgerald", Utils.generateId());
        book1.displayBook();

        // Creating a member
        Members member1 = new Members("John Doe", Utils.generateId());
        member1.displayMember();
    }
}
