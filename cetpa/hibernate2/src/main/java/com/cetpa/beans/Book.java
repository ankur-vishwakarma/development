package com.cetpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// table "book_details" will be created inside database "books"  
@Table(name = "book_details")

// specify the hibernate that class "Book" will be associated with table
// "book_details"
@Entity
public class Book 
{
	// data-members (attribute of book)
	private int isbn, price;
	private String topic, author, publisher;

	// getters and setters
	// specify the primary-key (primary-key is always unique and not null)
	@Id	
	// create column "book_isbn" inside table "book_details"
	@Column(name="book_isbn")
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	// create column "book_price" inside table "book_details"
	@Column(name="book_price")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// create column "book_topic" inside table "book_details"
	@Column(name="book_topic")
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	// create column "book_author" inside table "book_details"
	@Column(name="book_author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// create column "book_publisher" inside table "book_details"
	@Column(name="book_publisher")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}