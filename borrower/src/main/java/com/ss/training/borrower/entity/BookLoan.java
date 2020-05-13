/**
 * 
 */
package com.ss.training.borrower.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_book_loans")
public class BookLoan implements Serializable {

	private static final long serialVersionUID = -326651163829760200L;

	@EmbeddedId
	BookLoansKey id;

	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "bookid")
	@JsonBackReference
	private Book book;

	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "branchid")
	@JsonBackReference
	private LibraryBranch branch;

	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "cardno")
	@JsonBackReference
	private Borrower borrower;

	@Column(name = "duedate", columnDefinition = "DATE")
	private LocalDate dueDate;

	@Column(name = "datein", columnDefinition = "DATE")
	private LocalDate dateIn;

	public BookLoansKey getId() {
		return id;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getDateIn() {
		return dateIn;
	}

	public void setDateIn(LocalDate dateIn) {
		this.dateIn = dateIn;
	}

	public void setId(BookLoansKey id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LibraryBranch getBranch() {
		return branch;
	}

	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BookLoan)) {
			return false;
		}
		BookLoan other = (BookLoan) obj;
		return Objects.equals(id, other.id);
	}

}
