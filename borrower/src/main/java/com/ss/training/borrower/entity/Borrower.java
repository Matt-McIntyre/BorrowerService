package com.ss.training.borrower.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_borrower")
public class Borrower implements Serializable {

	private static final long serialVersionUID = -4691814048768809869L;

	@Id
	@Column(name = "cardno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardNo;

	@Column(name = "name")
	private String borrowerName;

	@Column(name = "address")
	private String borrowerAddress;

	@Column(name = "phone")
	private String borrowerPhone;

	@OneToMany(mappedBy = "book")
	@JsonBackReference
	private List<BookLoan> bookLoans;

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getBorrowerAddress() {
		return borrowerAddress;
	}

	public void setBorrowerAddress(String borrowerAddress) {
		this.borrowerAddress = borrowerAddress;
	}

	public String getBorrowerPhone() {
		return borrowerPhone;
	}

	public void setBorrowerPhone(String borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}

	public List<BookLoan> getBookLoans() {
		return bookLoans;
	}

	public void setBookLoans(List<BookLoan> bookLoans) {
		this.bookLoans = bookLoans;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Borrower)) {
			return false;
		}
		Borrower other = (Borrower) obj;
		return Objects.equals(cardNo, other.cardNo);
	}

}
