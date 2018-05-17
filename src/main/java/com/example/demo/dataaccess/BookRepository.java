package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findAllById(int bookId);
	
	@Query("SELECT b FROM Book b order by b.title asc")
	public List<Book> sortAllByTitle();
	
	List<Book> findAllByOrderByTitleAsc();
	
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
	
//stored procedures and how to use them: FROM SPRING DATA JPA
//	CREATE OR REPLACE PACKAGE test_pkg AS
//	   PROCEDURE in_only_test (inParam1 IN VARCHAR2);
//	   PROCEDURE in_and_out_test (inParam1 IN VARCHAR2, outParam1 OUT VARCHAR2);
//	END test_pkg;
//	/
//	CREATE OR REPLACE PACKAGE BODY test_pkg AS
//	   PROCEDURE in_only_test(inParam1 IN VARCHAR2) AS
//	   BEGIN
//	      DBMS_OUTPUT.PUT_LINE('in_only_test');
//	   END in_only_test;
//	   PROCEDURE in_and_out_test(inParam1 IN VARCHAR2, outParam1 OUT VARCHAR2) AS
//	   BEGIN
//	      outParam1 := 'Woohoo Im an outparam, and this is my inparam ' || inParam1;
//	   END in_and_out_test;
//	END test_pkg;
	
//THIS IS HOW CLASS IS ANNOTATED
//
//@Entity
//@Table(name = "MYTABLE")
//@NamedStoredProcedureQueries({
//   @NamedStoredProcedureQuery(name = "in_only_test", 
//                              procedureName = "test_pkg.in_only_test",
//                              parameters = {
//                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class)
//                              }),
//   @NamedStoredProcedureQuery(name = "in_and_out_test", 
//                              procedureName = "test_pkg.in_and_out_test",
//                              parameters = {
//                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
//                                 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type = String.class)
//                              })
//})
//public class MyTable implements Serializable {
//}
}
