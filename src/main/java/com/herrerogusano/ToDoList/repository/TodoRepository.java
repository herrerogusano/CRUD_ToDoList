package com.herrerogusano.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herrerogusano.ToDoList.model.TodoItem;

public interface TodoRepository extends JpaRepository<TodoItem, Long>{

}

