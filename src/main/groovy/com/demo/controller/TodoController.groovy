package com.demo.controller;

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import com.demo.dao.TodoDao
import com.demo.entities.Todo
import com.demo.services.APIResponse
import com.demo.services.DBQueries
import com.demo.services.TodoService

@RestController
@RequestMapping("/tasks")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private DBQueries dbQueries
	
	@Autowired
	private TodoDao todoDao

	@GetMapping("/todos")
	public List<Todo> getAllTodo(){
	
		return this.todoService.getAllTodos();
	}
	
	@GetMapping("/todos/{todoId}")
	@ResponseBody
	public Todo getTodo(@PathVariable String todoId){
	
		println "Todo With id " + todoId
		Todo todo = this.todoService.getTodo(Integer.parseInt(todoId));
		
		if(todo) {
			return todo
		}else {
			return null
		}
	}
	
	@PostMapping("/todos/{folderId}")
	public Todo addTodo(@RequestBody Todo todo, @PathVariable int folderId){
	
		if(todo == null) {
			println "Todo is not provided"
			return null
		}
		
		println "Folder ID : " + folderId 
		
		return this.todoService.addTodo(todo,folderId);
	}
	
	@PutMapping("/todos")
	public Todo updateTodo(@RequestBody Todo todo){
	
		return this.todoService.updateTodo(todo);
	}
	
	@DeleteMapping("/todos/{todoId}")
	public String deleteTodo(@PathVariable String todoId){
	
		return this.todoService.deleteTodo(todoId);
	}
	
	
	// Assignment 2
	@GetMapping("")
	public List<Todo> FilterMethod(@RequestParam List<String> values) {
				
		println "Values : " + values
		return dbQueries.queryFilter(values)
	}
	
	// Assignment 3
	@GetMapping("/search")
	public String search(HttpServletRequest req) {
		
		HttpSession session = req.getSession()
		String query = req.getParameter("q")
		println query
		return dbQueries.queryInUrl(query)
	}
	
	
	// Assignment 4
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public APIResponse<List<Todo>> getTodos(@PathVariable int offset, @PathVariable int pageSize){
		
		println "offset : " + offset + "\n" + "pagesize : " + pageSize
		 
		List<Todo> allTodo = this.todoService.findTodoWithPagination(offset, pageSize)
		println allTodo
		
		return new APIResponse<>(allTodo.size(), allTodo)
	}

}

