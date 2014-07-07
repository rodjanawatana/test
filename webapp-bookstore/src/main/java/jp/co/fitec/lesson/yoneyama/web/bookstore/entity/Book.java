package jp.co.fitec.lesson.yoneyama.web.bookstore.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 5656378917801190660L;

	@Id
	private String isbn;
	
	private String title;
	
	@ManyToOne
	private Publisher publisher;
	
	private Double price;
	
	@Column(name="release_date")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	@ManyToMany(targetEntity=Author.class)
	@JoinTable(name="book_author", 
		joinColumns=@JoinColumn(name="isbn"), 
		inverseJoinColumns=@JoinColumn(name="author_code"))
	private Set<Author> authors;

	public Book() {}

	public Book(String isbn, String title, Publisher publisher, Double price,
			    Date releaseDate, Set<Author> authors) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.releaseDate = releaseDate;
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price
				+ ", authors=" + authors + ", publisher=" + publisher + "]";
	}
}
