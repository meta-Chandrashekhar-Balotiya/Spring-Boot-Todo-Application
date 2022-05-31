package com.demo.entities

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany
import javax.persistence.CascadeType
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
public class Users implements Serializable {

	@Id
	private String username
	
	private String password
	
	@OneToMany(mappedBy="users",cascade = CascadeType.ALL)
	private List<Folder> folder

	public Users() {
	}

	public Users(String username, String password) {
		super()
		this.username = username
		this.password = password
	}

	public Users(String username, String password, List<Folder> folder) {
		super();
		this.username = username;
		this.password = password;
		this.folder = folder;
	}

	public String getUsername() {
		return username
	}

	public void setUsername(String username) {
		this.username = username
	}

	public String getPassword() {
		return password
	}

	public void setPassword(String password) {
		this.password = password
	}

	public List<Folder> getFolders() {
		return folder;
	}

	public void setFolders(List<Folder> folder) {
		this.folder = folder;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", folder=" + folder + "]";
	}
	
	
	
}
