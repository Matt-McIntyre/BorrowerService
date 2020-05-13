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
@Table(name = "tbl_publisher")
public class Publisher implements Serializable {

	private static final long serialVersionUID = -8393917397273467905L;

	@Id
	@Column(name = "publisherid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long publisherId;

	@Column(name = "pulbishername")
	private String publisherName;

	@Column(name = "publisheraddress")
	private String publisherAddress;

	@Column(name = "publisherphone")
	private String publisherPhone;

	@OneToMany(mappedBy = "publisher")
	@JsonBackReference
	private List<Book> publishedBooks;

	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public String getPublisherPhone() {
		return publisherPhone;
	}

	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}

	public List<Book> getPublishedBooks() {
		return publishedBooks;
	}

	public void setPublishedBooks(List<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(publisherId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Publisher)) {
			return false;
		}
		Publisher other = (Publisher) obj;
		return Objects.equals(publisherId, other.publisherId);
	}

}