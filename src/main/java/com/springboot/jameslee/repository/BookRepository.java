package com.springboot.jameslee.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jameslee.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
//	Book       findOne(long id);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByAuthorAndStatus(String author, int status);
	
////	//SQL : description like '%description'
//	List<Book> findByDescriptionEndwith(String description);
	
	
	@Query(value = "select * from book where LENGH(name) >?1", nativeQuery = true)
	List<Book> findJPQL(int len);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.status = ?1 where id = ?2")
	int updateByJPQL(int status, long id);
	
	@Transactional
	@Modifying
//	@Query("delete from Book b where id = ?1")
	@Query(value = "delete from Book b where id = ?1" , nativeQuery = true)
	int deleteByJPQL(long id);

}
