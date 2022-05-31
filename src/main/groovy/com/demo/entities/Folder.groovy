package com.demo.entities

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
public class Folder implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id

	@Column(name = "Title", columnDefinition = "varchar(255) default 'default'")
	String title
	
	@ManyToOne()
	@JsonIgnore
	private Users users
		
	@OneToMany(mappedBy="folder",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Todo> todos
	
	public Folder() {
		
	}

	public Folder(String folderTitle) {
		this.title = folderTitle
	}
	
	public Folder( String folderTitle,Users u) {
		super()
		this.user=u
		this.title = folderTitle
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Todo> getTodos() {
		return todos;
	}
	
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	
	/////
	public Users getUser() {
		return users;
	}
	public void setUser(Users user) {
		this.users = user;
	}

	@Override
	public String toString() {
		return "Folder [id=" + id + ", title=" + title + ", todos=" + todos + "]";
	}
		
}
