package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findAllById(int bookId);
	
//    @Query("SELECT t.title FROM Todo t where t.id = :id") 
//    String findTitleById(@Param("id") Long id);
//     
//    @Query("SELECT t.title FROM Todo t where t.id = :id") 
//    Optional<String> findTitleById(@Param("id") Long id);
// 
//    Todo findById(Long id);
//     
//    Optional<Todo> findById(Long id);
//=================================================================	
//    public Optional<Todo> findByTitleAndDescription(String title, String description);
//    
//    @Query("SELECT t FROM Todo t where t.title = ?1 AND t.description = ?2")
//    public Optional<Todo> findByTitleAndDescription(String title, String description);
//     
//    @Query(value = "SELECT * FROM todos t where t.title = ?0 AND t.description = ?1", 
//        nativeQuery=true
//    )
//    public Optional<Todo> findByTitleAndDescription(String title, String description);

	//=============================================================
	//QUERIWS THAT RUN ASYNCHRONOUSLY
//    @Async
//    @Query("SELECT t.title FROM Todo t where t.id = :id") 
//    Future<String> findTitleById(@Param("id") Long id);
//     
//    @Async
//    @Query("SELECT t.title FROM Todo t where t.id = :id") 
//    Future<Optional<String>> findTitleById(@Param("id") Long id);
// 
//    @Async
//    Future<Todo> findById(Long id);
//     
//    @Async
//    Future<Optional<Todo>> findById(Long id);
// 
//    @Async
//    Future<List<Todo>> findByTitle(String title);
//     
//    @Async
//    Future<Stream<Todo>> findByTitle(String title);
}
