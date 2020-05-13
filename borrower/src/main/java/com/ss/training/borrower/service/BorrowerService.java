package com.ss.training.borrower.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.training.borrower.dao.BookCopiesDAO;
import com.ss.training.borrower.dao.BookDAO;
import com.ss.training.borrower.dao.BookLoanDAO;
import com.ss.training.borrower.dao.BorrowerDAO;
import com.ss.training.borrower.dao.LibraryBranchDAO;
import com.ss.training.borrower.entity.BookCopies;
import com.ss.training.borrower.entity.BookCopiesKey;
import com.ss.training.borrower.entity.BookLoan;
import com.ss.training.borrower.entity.BookLoansKey;
import com.ss.training.borrower.entity.Borrower;
import com.ss.training.borrower.entity.LibraryBranch;

@Component
public class BorrowerService {

	@Autowired
	BorrowerDAO borrowerDAO;

	@Autowired
	LibraryBranchDAO libraryBranchDAO;

	@Autowired
	BookLoanDAO bookLoanDAO;

	@Autowired
	BookCopiesDAO copiesDAO;

	@Autowired
	BookDAO bookDAO;

	public Borrower findBorrowerByCardNo(Long cardNo) {
		return borrowerDAO.findById(cardNo).orElseThrow(() -> new EntityNotFoundException("No such borrower"));
	}

	public List<BookLoan> findActiveLoansByBorrower(Long cardNo) {
		return borrowerDAO.findById(cardNo).orElseThrow(() -> new EntityNotFoundException("No such borrower"))
				.getBookLoans().stream().filter(loan -> loan.getDateIn() == null).collect(Collectors.toList());
	}

	public List<LibraryBranch> findAllBranches() {
		return libraryBranchDAO.findAll();
	}

	public List<BookCopies> findAvailibleBooksByBranch(Long id) {
		return copiesDAO.findAll().stream()
				.filter(bookCopies -> bookCopies.getId().getBranchId() == id && bookCopies.getNoOfCopies() > 0)
				.collect(Collectors.toList());
	}
	
	@Transactional
	public BookLoan borrowBookLoan(BookCopiesKey id, Long cardNo) {
		BookCopies copyToBorrow = copiesDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("No such book_copies"));
		Borrower borrower = borrowerDAO.findById(cardNo).orElseThrow(() -> new EntityNotFoundException("No such borrower"));
		
		LocalDate borrowDate = LocalDate.now();
		
		BookLoansKey newLoanKey = new BookLoansKey();
		newLoanKey.setBookId(copyToBorrow.getBook().getBookId());
		newLoanKey.setBranchId(copyToBorrow.getBranch().getBranchId());
		newLoanKey.setCardNo(borrower.getCardNo());
		newLoanKey.setDateOut(borrowDate);		
		
		BookLoan newLoan = new BookLoan();
		newLoan.setId(newLoanKey);
		newLoan.setDueDate(borrowDate.plusDays(7));
		
		copyToBorrow.setNoOfCopies(copyToBorrow.getNoOfCopies() - 1);
		
		copiesDAO.save(copyToBorrow);
		bookLoanDAO.save(newLoan);
		
		return newLoan;
	}

	@Transactional
	public BookLoan returnBookLoan(BookLoansKey id) {
		BookLoan loan = bookLoanDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("No such loan"));

		BookCopiesKey bookCopiesKey = new BookCopiesKey();
		bookCopiesKey.setBookId(loan.getId().getBookId());
		bookCopiesKey.setBranchId(loan.getId().getBranchId());

		BookCopies copies = copiesDAO.findById(bookCopiesKey)
				.orElseThrow(() -> new EntityNotFoundException("No such book_copies"));

		loan.setDateIn(LocalDate.now());
		copies.setNoOfCopies(copies.getNoOfCopies() + 1);

		copiesDAO.save(copies);
		bookLoanDAO.save(loan);

		return loan;
	}

	public List<Borrower> findAllBorrowers() {
		return borrowerDAO.findAll();
	}

	public LibraryBranch findBranchById(Long branchId) {
		return null;
	}
}