package com.demo.services

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.demo.dao.TodoDao
import com.demo.entities.Todo

import groovy.sql.Sql

@Service
public class DBQueries {
	
	@Autowired
	private TodoDao todoDao
	@Autowired
	private TodoService todoService;
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public List<Todo> queryFilter(List<String> query){
		
		String q 		
		if(query.size() == 0) {
			return null
		} else if(query[0].equalsIgnoreCase("all")) {
			q = 'SELECT * FROM todo;'
			
		}else {
			
			String filter = String.join(", ", query);
			q = 'SELECT '+ filter +' FROM todo;'
		}
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query1 = entityManager.createNativeQuery(q)
		println query1.getResultList()
		return query1.getResultList()
	}
	

	public String queryInUrl(String query){

		EntityManager entityManager = entityManagerFactory.createEntityManager()
		Query query1 = entityManager.createNativeQuery(query)
		println query1.getResultList()
		return "Query In URL Executed !! "
		
		
		
//		def DB_URL = "jdbc:mysql://localhost/TodoDB"
//		def USER = "root"
//		def PASS = "mysql"
//		def DRIVER = "com.mysql.cj.jdbc.Driver"
//			
//		def sql = Sql.newInstance(DB_URL, USER, PASS, DRIVER)
//		sql.connection.autoCommit = false
//		
//		sql.execute(query);
//		sql.eachRow(query) {row ->
//			println row
//		}
//		sql.commit()
		
		
	}
	
}
