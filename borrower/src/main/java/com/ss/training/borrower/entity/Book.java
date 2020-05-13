package com.ss.training.borrower.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_book")
public class Book implements Serializable {

	private static final long serialVersionUID = -5416431360670324092L;

	@Id
	@Column(name = "bookid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	@Column(name = "title")
	private String title;

	@ManyToMany
	@JoinTable(name = "tbl_book_authors", joinColumns = @JoinColumn(name = "bookid"), inverseJoinColumns = @JoinColumn(name = "authorid"))
	private List<Author> authors;

	@ManyToMany
	@JoinTable(name = "tbl_book_genres", joinColumns = @JoinColumn(name = "bookid"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres;

	@ManyToOne
	@JoinColumn(name = "pubid", nullable = false)
	private Publisher publisher;

	@OneToMany(mappedBy = "book")
	@JsonBackReference
	private List<BookCopies> bookLoans;

	@OneToMany(mappedBy = "book")
	@JsonBackReference
	private List<BookLoan> bookCopies;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<BookCopies> getBookLoans() {
		return bookLoans;
	}

	public void setBookLoans(List<BookCopies> bookLoans) {
		this.bookLoans = bookLoans;
	}

	public List<BookLoan> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookLoan> bookCopies) {
		this.bookCopies = bookCopies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(bookId, other.bookId);
	}

}