package com.jamesluty.booksapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jamesluty.booksapi.models.Book;
import com.jamesluty.booksapi.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books/{id}")
	public String books(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("book", book);
		return "Show.jsp";
	}
}
