package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;



@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public String getAll(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "books";
	}
	
	@GetMapping("/books/{id}")
	public String getOne(@PathVariable long id, Model model) {
		Book books = bookService.getOne(id);
		model.addAttribute("book", books);
		return "books";
	}

	@GetMapping("/books/input")
	public String inputPage(){
		return "input";
	}
	@PostMapping("/books")
	public String post(Book book){
		bookService.save(book);
		return "redirect:/books";
	
	}
}
