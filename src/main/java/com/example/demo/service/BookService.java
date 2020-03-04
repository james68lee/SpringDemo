package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	/**
	 * Find all Book
	 * @return
	 */
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	/**
	 * Save/update a new Book
	 * @param book
	 * @return
	 */
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
//	/**
//	 * 
//	 * @param id
//	 * @return
//	 */
	public Book getOne(long id) {
		return bookRepository.getOne(id);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(long id) {
		bookRepository.deleteById(id);
	}
	
	/**
	 * 
	 * @param author
	 * @return
	 */
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
		
	}
	
	/**
	 * 
	 * @param author
	 * @param status
	 * @return
	 */
	public List<Book> findByAuthorAndStatus(String author, int status) {
		return bookRepository.findByAuthorAndStatus(author, status);
	}
	
//	/**
//	 * 
//	 * @param description
//	 * @return
//	 */
//	public List<Book> findByDescriptionEndwith(String description) {
//		return bookRepository.findByDescriptionEndwith(description);
//	}
	
	/**
	 * 
	 * @param len
	 * @return
	 */
	public List<Book> findByJPQL(int len) {
		return bookRepository.findJPQL(len);
	}
	
	/**
	 * 
	 * @param status
	 * @param id
	 * @return
	 */
	@Transactional
	public int updateByJPQL(int status, long id) {
		return bookRepository.updateByJPQL(status, id);
	}
	
	/**
	 * 
	 * @param status
	 * @param id
	 * @return
	 */
	@Transactional
	public int deleteByJPQL(long id) {
		return bookRepository.deleteByJPQL(id);
	}
}
