package com.demo.controller

import java.security.Principal

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.demo.dao.FolderDao
import com.demo.entities.Folder
import com.demo.entities.Todo
import com.demo.services.FolderService

@RestController
@RequestMapping("/folder")
public class FolderController {

	@Autowired
	private FolderService folderService
	
	@Autowired
	private FolderDao folderDao
	
	@GetMapping("")
	public List<Folder> FolderList(Principal principal) {
		
		println "debug1"
		List<Folder> folderList = this.folderService.getAllFolder(principal.getName())
		println "debug4"
		return folderList
	}
	
	@GetMapping("/{folderId}")
	public List<Todo> getTodosByFolderId(@PathVariable int folderId, Principal principal) {
		
		List<Todo> outputList = this.folderService.getTodosByFolderId(folderId, principal.getName())
		
		return outputList
	}
	
	@PostMapping("")
	public String addFolder(@RequestBody Folder folder, Principal principal) {
		
		if(folder == null) {
			return "Folder is NULL"
		}
		println "Adding"
		return this.folderService.addFolder(folder, principal.getName())	
	}
	
	
	@PutMapping("")
	public Folder updateFolder(@RequestBody Folder folder, Principal principal){
	
		return this.folderService.updateFolder(folder,principal.getName());
	}
	
	@DeleteMapping ("/{id}")
	public String deleteFolderById(@PathVariable int id, Principal principal) {
		
		return this.folderService.deleteFolderById(id, ,principal.getName())
	}
	
//	@GetMapping
//	public List<Folder> getFoldersByUserName(Principal principal) {
//		return this.folderService.getFoldersByUserName(principal.getName())
//	}
//		
}
