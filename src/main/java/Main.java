import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String bookName = scanner.nextLine();
            Optional<String> optAuthor = Book.getAuthor(bookName);
   
            // write conditional logic; if author is present 
            // return book name along with author
            // otherwise return 'unknown' string 

            optAuthor.ifPresentOrElse(
                (author) -> System.out.println(bookName + " written by " + author),
                () -> System.out.println("Unknown")
            );
        }
    }
}

// DO NOT MODIFY the code below //
class Book {
    private static final Map<String, String> books = new HashMap<>();

    static {
        books.put("Effective Java", "Joshua Bloch");
        books.put("Designing Data-Intensive Applications", "Martin Kleppmann");
        books.put("Modern Java in Action", "Raoul-Gabriel Urma");
    }

    static Optional<String> getAuthor(String name) {
        return Optional.ofNullable(books.get(name));
    }
}
