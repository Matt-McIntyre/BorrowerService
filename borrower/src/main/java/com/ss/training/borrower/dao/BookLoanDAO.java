package com.ss.training.borrower.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.training.borrower.entity.BookLoan;
import com.ss.training.borrower.entity.BookLoansKey;

@Repository
public interface BookLoanDAO extends JpaRepository<BookLoan, BookLoansKey>{

}
