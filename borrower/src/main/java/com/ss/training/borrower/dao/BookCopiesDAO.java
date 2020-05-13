package com.ss.training.borrower.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.training.borrower.entity.BookCopies;
import com.ss.training.borrower.entity.BookCopiesKey;

@Repository
public interface BookCopiesDAO extends JpaRepository<BookCopies, BookCopiesKey>{

}
