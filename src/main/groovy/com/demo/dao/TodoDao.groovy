package com.demo.dao

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import com.demo.entities.Todo;

@Repository
public interface TodoDao extends JpaRepository<Todo, Integer>  {
	
	public Todo findById(int todoId)

	@Query(value = "SELECT t.taskTitle, t.taskId FROM todo t", nativeQuery = true)
	public List<Integer> findByParam()
	
	// s = "task_title, task_id"
	
	
//	@Query(value="SELECT t.taskTitle,t.taskDescription from Todo t where t.filterCol = :n")
//	public List<Todo> findByParam(@Param("n") String q)

//	@Query("select new com.demo.entities.Todo(d.taskId, d.taskTitle) from Todo d where d.filterCol = ?1"
//	public List<Todo> findByParam(String q)
		
//	@Query("select new com.demo.entities.Todo(d.taskId, d.taskTitle) from Todo d where d.filterCol = ?q")
//	public List<Todo> findByParam(@Param("q") String q)

//	@Query("select d.taskId, d.taskTitle from Todo d where d.filterCol = :q")
//	public List<Todo> findByParam(@Param("q") String q)
				
//	@Query(value = "SELECT u FROM Todo u WHERE u.name IN :names")
//	public List<Todo> findByParam(@Param("names") Collection<String> names);
	
}