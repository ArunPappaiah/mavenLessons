package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//import com.chainsys.mavenlessons.entity.Passport;
import com.chainsys.mavenlessons.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(int id);
//	Passport findByPassportId(int id);
	List<User> findAll();
	User save(User user);
	void deleteById(int id);
	//@Query(value="select a from User a where a.id=?1")
	// User getUser(int uid); // This is example of JPQL
	// @Query(value="select * from User a where a.USER_ID=?1")
	//User getUserNativeSQL(int uid); // Example of native query
	// By default @Query will execute only select statements
	// To execute insert,update,delete statements @Query should be marked as @Modifying
	// @Modifying
	// @Query("update User a set a.USER_NAME?2, a.CITY=?3 where a.USER_ID=?1") // ?1 -->Position parameter
//	void modifyUser(int id, String name, String city);
	// @Param
//	@Query("select a from User a where a.CITY = :ucity") // :ucity --> Based on name parameter
//	List<User> getUsersFromCity(@Param("ucity")String city);
	
}
/* 	@Query--Two types of queries
 * 		1. JPQL (Java Persistence Query Language) Query on POJO Entity classes
 * 		2. Native SQL Queries
 */