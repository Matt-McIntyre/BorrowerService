package com.ss.training.borrower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.training.borrower.dao.BookDAO;
import com.ss.training.borrower.dao.PublisherDAO;
import com.ss.training.borrower.entity.Book;
import com.ss.training.borrower.entity.Publisher;

@RestController
@RequestMapping("/lms")
public class TestController {
	
	@Autowired
	private PublisherDAO publisherDAO;
	
	@Autowired
	private BookDAO bookDAO;
	
	@GetMapping("/publisher")
	public List<Publisher> getAllPublishers() {
	    return publisherDAO.findAll();
	}
	
	@GetMapping("/book")
	public List<Book> getAllBooks() {
	    return bookDAO.findAll();
	}


}
