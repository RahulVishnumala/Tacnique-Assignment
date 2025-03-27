package com.rr.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rr.model.Book;

public class LibraryManagementSystem {
	private static final List<Book> books = new ArrayList<>();
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 : addBook();
                case 2 : viewAllBooks();
                case 3 : searchBook();
                case 4 : updateBook();
                case 5 : deleteBook();
                case 6 : {
                    System.out.println("Exiting system...");
                    return;
                }
                default : System.out.println("Invalid choice. Please try again.");
            }
        }
	}
	
	private static void addBook() {
        System.out.print("Enter Book ID: ");
        String bookID = sc.nextLine();
        if (books.stream().anyMatch(book -> book.getBookID().equals(bookID))) {
            System.out.println("Book ID must be unique.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = sc.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter Author: ");
        String author = sc.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("Author cannot be empty.");
            return;
        }

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        System.out.print("Enter Availability (Available/Checked Out): ");
        String availability = sc.nextLine();
        if (!availability.equalsIgnoreCase("Available") && !availability.equalsIgnoreCase("Checked Out")) {
            System.out.println("Invalid availability status.");
            return;
        }

        books.add(new Book(bookID, title, author, genre, availability));
        System.out.println("Book added successfully.");
    }
	
	private static void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.forEach(System.out::println);
    }

    private static void searchBook() {
        System.out.print("Enter Book ID or Title: ");
        String query = sc.nextLine();
        books.stream()
                .filter(book -> book.getBookID().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query))
                .forEach(System.out::println);
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookID = sc.nextLine();
        Book book = books.stream().filter(b -> b.getBookID().equals(bookID)).findFirst().orElse(null);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("Enter new Title (leave empty to keep current): ");
        String title = sc.nextLine().trim();
        if (!title.isEmpty()) book.setTitle(title);

        System.out.print("Enter new Author (leave empty to keep current): ");
        String author = sc.nextLine().trim();
        if (!author.isEmpty()) book.setAuthor(author);

        System.out.print("Enter new Genre (leave empty to keep current): ");
        String genre = sc.nextLine().trim();
        if (!genre.isEmpty()) book.setGenre(genre);

        System.out.print("Enter new Availability (Available/Checked Out): ");
        String availability = sc.nextLine();
        if (availability.equalsIgnoreCase("Available") || availability.equalsIgnoreCase("Checked Out")) {
            book.setAvailability(availability);
        } else {
            System.out.println("Invalid availability status.");
        }

        System.out.println("Book updated successfully.");
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookID = sc.nextLine();
        if (books.removeIf(book -> book.getBookID().equals(bookID))) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}
