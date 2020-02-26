package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;
import com.example.demo.domain.Book;
@RestController
@RequestMapping("/api/v1")
public class BookApp {

	@Autowired
	private BookService bookService;
	
	/**
	 * Get all Books
	 * @return
	 */
	@GetMapping("/books")
	public List<Book> getAll(){
		return bookService.findAll();
	}
	
	/**
	 * Save a new book
	 * @param name
	 * @param autor
	 * @param description
	 * @param status
	 * @return
	 */
	@PostMapping("/books")
	public Book post(@RequestParam String name,
			@RequestParam String autor,
			@RequestParam String description,
			@RequestParam int status) {
		
		Book book = new Book();
		book.setName(name);
		book.setAuthor(autor);
		book.setDescrtion(description);
		book.setStatus(status);
		
		return bookService.save(book);
	}
	
//	/**
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@GetMapping("/book/{id}")
//	public Book getOne(@PathVariable Long id) {
//		return bookService.findOne(id);
//	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param autor
	 * @param description
	 * @param status
	 * @return
	 */
	@GetMapping("/book/{id}")
	public Book update(@RequestParam long id,
			@RequestParam String name,
			@RequestParam String autor,
			@RequestParam String description,
			@RequestParam int status) {
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(autor);
		book.setDescrtion(description);
		book.setStatus(status);
		
		return bookService.save(book);
		
	}
	/**
	 * Delete a book
	 * @param id
	 */
	@DeleteMapping("/book/{id}")
	public void deleteOne(@PathVariable Long id) {
		bookService.delete(id);
	}
	
	/**
	 * 
	 * @param author
	 * @return
	 */
	@PostMapping("/books/by")
	public List<Book> findBy(@RequestParam String author){
		return bookService.findByAuthor(author);
	}
	
//	@PostMapping("/books/byAuthorAndStatus")
//	public List<Book> findBy(@RequestParam String author,
//			@RequestParam int status){
//		return bookService.findByAuthorAndStatus(author, status);
//	}
	
//	@PostMapping("/books/byDescription")
//	public List<Book> findByDescriptionEndwith(@RequestParam String description){
//		return bookService.findByDescriptionEndwith(description);
//	}
	
//	@PostMapping("/books/by")
//	public List<Book> findBy(@RequestParam int len){
//		return bookService.findByJPQL(len);
//	}
	
	
	@PostMapping("/books/updateByJPQL")
	public int updateByJPQL(@RequestParam int status,
			@RequestParam long id){
		return bookService.updateByJPQL(status, id);
	}
	
	@PostMapping("/books/deleteByJPQL")
	public int deleteByJPQL(@RequestParam long id){
		return bookService.deleteByJPQL(id);
	}
}
