package com.demo.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.demo.dao.FolderDao
import com.demo.dao.UserDao
import com.demo.entities.Folder
import com.demo.entities.Todo
import com.demo.entities.Users

@Service
class FolderService {
	
	@Autowired
	private FolderDao folderRepository
	
	@Autowired
	private UserDao userRepository
	
	public List<Folder> getAllFolder(String uname){
		
		println "debug2"
		Users u=this.userRepository.findByUsername(uname)
		if(u==null) {
			return "user cannot exists "
		}
		println "debug3"
		List<Folder> folderList = u.getFolders()
		
		println "List of user : ${uname} - " + folderList
		return folderList;
	}
		
	
	public String addFolder(Folder folder, String uname) {

		Users u = this.userRepository.findByUsername(uname)
		if(u == null) {
			return "user cannot exists "
		}
		
		println "Uname: " + uname
		List<Folder> folders = u.getFolders()
		for(Folder f: folders) {
			if( f.getTitle().equalsIgnoreCase(folder.getTitle()) )
				return "folder already exists"
		}

		println "User :  " + u
		folder.setUser(u)
		
		this.folderRepository.save(folder)
		return "folder successfully added "
	}
	
	public List<Todo> getTodosByFolderId(int folderId, String uname){
	   
		Users u=this.userRepository.findByUsername(uname)
		if(u==null)
			return null
			
	   Folder folder = this.folderRepository.findById(folderId)
	   println folder
	   
	   if(folder==null || !folder.getUser().getUsername().equals(u.getUsername())) {
			return null
	   }
	   
	   List<Todo> nonarchived=new ArrayList<>();
	   for(Todo todo:folder.getTodos()) {
			if(!todo.isArchive())
				nonarchived.add(todo)
	   }
	   return nonarchived
	}
	
	
	public Folder updateFolder(Folder folder, String uname) {
	
		if(folder.getUser().getUsername() != uname) {
			println "user mismatch "
			return null
		}
		folderRepository.save(folder)
		return folder
	}
	
	public String deleteFolderById(int id, String uname) {
		
		Folder folder = this.folderRepository.findById(id)
		if(folder==null )
			return "folder not found"
	
//		if(folder.getTitle()=="default")
//			return "default folder cannot be deleted"
		
		this.folderRepository.deleteById(id)
		return "folder deleted successfully"
			
	}
	
//	public List<Folder> getFoldersByUserName(String uname){
//		
//		Users u=this.userRepository.findByUsername(uname)
//		if(u==null)
//			return null
//		 List<Folder> folders=u.getFolders()	
//		 return folders
//	}
}
