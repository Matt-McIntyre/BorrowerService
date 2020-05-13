package com.ss.training.borrower.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookCopiesKey implements Serializable {

	private static final long serialVersionUID = -625558072058895677L;

	@Column(name = "bookid")
	private Long bookId;

	@Column(name = "branchid")
	private Long branchId;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, branchId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BookCopiesKey)) {
			return false;
		}
		BookCopiesKey other = (BookCopiesKey) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(branchId, other.branchId);
	}

}
