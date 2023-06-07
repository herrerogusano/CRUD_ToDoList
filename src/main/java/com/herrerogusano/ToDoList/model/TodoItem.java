package com.herrerogusano.ToDoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TodoItem {
	
	private Long id;
	private String title;
	private boolean done;
	
	public TodoItem(Long id, String title, Boolean done) {
		super();
		this.id = id;
		this.title = title;
		this.done = done;
	}
	
	public TodoItem() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
	
	
	
	
	
}
