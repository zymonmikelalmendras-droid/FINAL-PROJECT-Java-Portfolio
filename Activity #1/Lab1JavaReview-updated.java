import java.util.Scanner;

public class Lab1JavaReview {
    static final int MAX_BOOKS = 5;
    static String[] titles = new String[MAX_BOOKS];
    static String[] status = new String[MAX_BOOKS];
    static int count = 0;

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 5) {
            showMenu();

            if (!in.hasNextInt()) {
                System.out.println("Please enter a number (1-5).");
                in.next(); 
                continue;
            }

            choice = in.nextInt();
            in.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBookStatus();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Closing system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Enter 1-5 only.");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n=== Library Menu ===");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book Status");
        System.out.println("3. Show All Books");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    static void addBook() {
        if (count >= MAX_BOOKS) {
            System.out.println("Library full (max " + MAX_BOOKS + " books).");
            return;
        }

        System.out.print("Enter title: ");
        titles[count] = in.nextLine().trim();

        if (titles[count].isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        status[count] = "Available";
        System.out.println("Book \"" + titles[count] + "\" added!");
        count++;
    }

    static void updateBookStatus() {
        if (count == 0) {
            System.out.println("No books to update.");
            return;
        }

        showBooks();
        System.out.print("Enter book number: ");

        if (!in.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            in.next();
            return;
        }

        int num = in.nextInt();
        in.nextLine();

        if (num < 1 || num > count) {
            System.out.println("Invalid book number.");
            return;
        }

        int idx = num - 1;

        // FIX: ensure status toggles correctly
        if (status[idx].equals("Available")) {
            status[idx] = "Borrowed";
        } else {
            status[idx] = "Available";
        }

        System.out.println("Book \"" + titles[idx] + "\" is now " + status[idx] + ".");
    }

    static void showBooks() {
        if (count == 0) {
            System.out.println("No books stored.");
            return;
        }
        System.out.println("\n--- Books ---");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + titles[i] + " - " + status[i]);
        }
    }

    static void generateReport() {
        int available = 0, borrowed = 0;

        for (int i = 0; i < count; i++) {
            if (status[i].equals("Available")) {
                available++;
            } else {
                borrowed++;
            }
        }

        System.out.println("\n--- Report ---");
        System.out.println("Total: " + count);
        System.out.println("Available: " + available);
        System.out.println("Borrowed: " + borrowed);
    }
}