package com.ss.training.borrower.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookLoansKey implements Serializable {

	private static final long serialVersionUID = -2149958063479848070L;

	@Column(name = "bookid")
	private Long bookId;

	@Column(name = "branchid")
	private Long branchId;

	@Column(name = "cardno")
	private Long cardNo;
	
	@Column(name = "dateout", columnDefinition = "DATE")
	private LocalDate dateOut;

	public LocalDate getDateOut() {
		return dateOut;
	}

	public void setDateOut(LocalDate dateOut) {
		this.dateOut = dateOut;
	}

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

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, branchId, cardNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BookLoansKey)) {
			return false;
		}
		BookLoansKey other = (BookLoansKey) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(branchId, other.branchId)
				&& Objects.equals(cardNo, other.cardNo);
	}

}
