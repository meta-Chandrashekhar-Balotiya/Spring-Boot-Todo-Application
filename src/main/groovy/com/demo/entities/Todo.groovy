package com.demo.entities;

import javax.persistence.*;

import com.demo.validation.TodoAnnotation
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore

//@Entity(name  = "tododetails")
@Entity
@TodoAnnotation
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int taskId;
	
	String taskTitle
	
	String taskDescription
	
	@Column(columnDefinition = "varchar(255) default 'process'")
	String status
	
	
	
//	@Temporal(javax.persistence.TemporalType.DATE)
//	@JsonFormat(pattern="dd-MM-yyyy")
//	@Column(columnDefinition = "date default GETDATE()")
//	private Date startDate;
	
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	Date endDate
	
	@ManyToOne()
	@JsonIgnore
	Folder folder
	
	@Column(columnDefinition = "BOOLEAN default false")
	boolean archive
	
	Todo(){
		
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	
	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	@Override
	public String toString() {
		return "Todo [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskDescription=" + taskDescription
				+ ", status=" + status + ", endDate=" + endDate + ", folder=" + folder + ", archive=" + archive + "]";
	}

	public Todo(int taskId, String taskTitle, String taskDescription, String status, Date endDate,
			boolean archive) {
		super();
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.status = status;
		this.endDate = endDate;
		this.archive = archive;
	}
	
	
		
	
}