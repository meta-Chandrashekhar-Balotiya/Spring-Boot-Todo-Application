package com.demo.services

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service;

import com.demo.dao.FolderDao
import com.demo.dao.TodoDao;
import com.demo.entities.Folder
import com.demo.entities.Todo;
import com.demo.validation.TodoValidation

@Service
public class TodoService { 

	public static final List<Todo> archiveList = new ArrayList<>()
	
	@Autowired
	private TodoDao todoDao;
	
	@Autowired
	private FolderDao folderDao;

	@Autowired
	private TodoValidation todoValidation;
	

	public List<Todo> getAllTodos() {
		
		return todoDao.findAll();
	}

	public Todo getTodo(int todoId) {

		try {
			Todo result = todoDao.getById(todoId);
			
			// Copy Constructor
			//Todo temp = new Todo(result)
			
			Todo temp =  new Todo(result.getTaskId(), result.getTaskTitle(), result.getTaskDescription(),
											result.getStatus(), result.endDate, result.isArchive());
										
			//print result + "\n" + temp
			return temp;
			
		}catch(Exception exp) {
			System.out.println("Exception Occure !!! " + exp)
		}
		return null;
	}


	public Todo addTodo(Todo todo, int folderId) {
		
		try {
			if(todoValidation.todoIsValid(todo) == false || todo == null) {
				println "This todo is not Valid"
				return null
			}
		
			Folder f = folderDao.findById(folderId)
			
			todo.setFolder(f)

			println todo
						
			if(todo.isArchive() == true) {
				archiveList.add(todo)
			} else {
				todoDao.save(todo);
				print "Sucessfully Added"
			}
			return todo;
			
		} catch (Exception e) {
				println "EXP--- " + e
		}
		return null;
	}

	
	public Todo updateTodo(Todo todo) {

		if(todoValidation.todoIsValid(todo) == false) {
			println "This todo is not Valid"
			return null
		}
		
		
		// If archive is true, Add in archive list and remove from database
		if(todo.isArchive() == true) {
			archiveList.add(todo)
			deleteTodo(todo.getTaskId().toString())
		}else {
		
			todoDao.save(todo);
		}
		println "debug"
		return todo;
	}

	public String deleteTodo(String todoId) {

		try {
			Todo entity1 = todoDao.getOne(Integer.parseInt(todoId))
			todoDao.delete(entity1)
			return "Todo with ID : " + todoId + " Sucessfully Deleted "
		} catch(Exception exp) {
			return "Course not Found to be deleted "
		}
	}


	// Part of Assignment 4

	public List<Todo> findTodoWithPagination(int offset, int pageSize){

		Pageable firstPageWithElements = PageRequest.of(offset, pageSize)

		Page<Todo> paginationList = todoDao.findAll(firstPageWithElements)

		return paginationList.toList()
	}

}
