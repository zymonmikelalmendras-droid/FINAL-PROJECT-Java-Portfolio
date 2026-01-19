

public class MyBookList {
    public static void main(String[] args) {

        // 1.) Create Book objects
        Book b1 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 1997);
        Book b2 = new Book("The Power of Habit", "Charles Duhigg", 2012);
        Book b3 = new Book("Atomic Habits", "James Clear", 2018);
        Book b4 = new Book("Java Programming", "John Doe", 2020);
        Book b5 = new Book("The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016);

        // 2.) Display all books
        System.out.println("=== Book List ===");
        b1.displayDetails();
        b2.displayDetails();
        b3.displayDetails();
        b4.displayDetails();
        b5.displayDetails();

        // 3.) Change pages for some books
        b1.changePage(50);
        b3.changePage(100);

        System.out.println("\n=== Updated Pages ===");
        b1.displayDetails();
        b3.displayDetails();

        // 4.) Change page of favorite book
        b5.changePage(77);
        System.out.println("\n=== Favorite Book Updated ===");
        b5.displayDetails();

        // 5.) Change author of Java Programming
        b4.setAuthor("Jane Smith");
        System.out.println("\n=== Updated Author ===");
        b4.displayDetails();

        // 6.) Create array of all books
        Book[] books = { b1, b2, b3, b4, b5 };

        System.out.println("\n=== Books Published After 2010 ===");
        for (Book book : books) {
            if (book.getYearPublished() > 2010) {
                System.out.println(book.getTitle());
            }
        }
    }
}