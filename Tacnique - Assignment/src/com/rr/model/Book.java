package com.rr.model;

public class Book {
	
	private String bookID;
	private String title;
	private String author;
	private String genre;
	private String availability;
	
	// Constructor
	public Book(String bookID, String title, String author, String genre, String availability) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.availability = availability;
	}
	
	public Book() {
		
	}

	public String getBookID() {
		return bookID;
	}
	public void setBookId(String bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Library [bookID=" + bookID + ", title=" + title + ", author=" + author + ", genre=" + genre
				+ ", isAvailable=" + availability + "]";
	}
	
}
