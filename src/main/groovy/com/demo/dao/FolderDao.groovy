package com.demo.dao

import com.demo.entities.Folder
import org.springframework.data.repository.CrudRepository

interface FolderDao extends CrudRepository<Folder,String> {
	
	 Folder findById(int folderId)
	 
	 List<Folder> findByTitle(String folderTitle)
	 
}