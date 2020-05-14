package com.ss.training.borrower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.training.borrower.entity.BookCopies;
import com.ss.training.borrower.entity.BookCopiesKey;
import com.ss.training.borrower.entity.BookLoan;
import com.ss.training.borrower.entity.BookLoansKey;
import com.ss.training.borrower.entity.Borrower;
import com.ss.training.borrower.entity.LibraryBranch;
import com.ss.training.borrower.service.BorrowerService;

@RestController
public class BorrowerController {

	@Autowired
	BorrowerService borrowerService;
	
	@RequestMapping(path = "/lms/public/borrower/borrowers")
	public ResponseEntity<List<Borrower>> findAllBorrowers() {
		return new ResponseEntity<List<Borrower>>(borrowerService.findAllBorrowers(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/lms/public/borrower/borrowers/{cardNo}")
	public ResponseEntity<Borrower> findBorrower(@PathVariable Long cardNo) {
		return new ResponseEntity<Borrower>(borrowerService.findBorrowerByCardNo(cardNo), HttpStatus.OK);
	}

	@RequestMapping(path = "/lms/public/borrower/borrowers/{cardNo}/loans")
	public ResponseEntity<List<BookLoan>> findActiveLoans(@PathVariable Long cardNo) {
		return new ResponseEntity<List<BookLoan>>(borrowerService.findActiveLoansByBorrower(cardNo), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/lms/public/borrower/branches")
	public ResponseEntity<List<LibraryBranch>> findAllBranches() {
		return new ResponseEntity<List<LibraryBranch>>(borrowerService.findAllBranches(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/lms/public/borrower/branches/{branchId}")
	public ResponseEntity<LibraryBranch> findBranchById(@PathVariable Long branchId) {
		return new ResponseEntity<LibraryBranch>(borrowerService.findBranchById(branchId), HttpStatus.OK);
	}

	@RequestMapping(path = "/lms/public/borrower/branches/{branchId}/books")
	public ResponseEntity<List<BookCopies>> findBooksByBranch(@PathVariable Long branchId) {
		return new ResponseEntity<List<BookCopies>>(borrowerService.findAvailibleBooksByBranch(branchId), HttpStatus.OK);
	}

	@PostMapping(path = "/lms/public/borrower/borrowers/{cardNo}/loans/return")
	public ResponseEntity<BookLoan> returnBookLoan(@RequestBody BookLoansKey id) {
		return new ResponseEntity<BookLoan>(borrowerService.returnBookLoan(id), HttpStatus.OK);
	}

	@PostMapping(path = "/lms/public/borrower/borrowers/{cardNo}/borrow")
	public ResponseEntity<BookLoan> borrowBookLoan(@RequestBody BookCopiesKey id, @PathVariable Long cardNo) {
		return new ResponseEntity<BookLoan>(borrowerService.borrowBookLoan(id, cardNo), HttpStatus.OK);
	}

}
