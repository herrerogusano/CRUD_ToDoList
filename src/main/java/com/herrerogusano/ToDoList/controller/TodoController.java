package com.herrerogusano.ToDoList.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import com.herrerogusano.ToDoList.model.TodoItem;
import com.herrerogusano.ToDoList.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/todo")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping
	public List<TodoItem> findAll(){
		return todoRepository.findAll();
	}
	
	@PostMapping(consumes = {"application/json"})
	public TodoItem save(@RequestBody TodoItem todoItem) {
		return todoRepository.save(todoItem);
	}
	
	@PutMapping//(consumes = {"application/json"})
	public TodoItem update(@RequestBody TodoItem updatedItem) {
		TodoItem existingItem = todoRepository.findById(updatedItem.getId()).orElse(null);
		if(existingItem!=null) {
			updatedItem.setTitle(existingItem.getTitle());
			return todoRepository.save(updatedItem);
		}
		else {
			throw new NoSuchElementException("El elemento con ID " + updatedItem.getId() + " no existe en la base de datos.");
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
	    // Verificar si el elemento existe en la base de datos
	    boolean itemExists = todoRepository.existsById(id);

	    if (itemExists) {
	        todoRepository.deleteById(id);
	        return ResponseEntity.ok("Item deleted successfully");
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	/*@DeleteMapping("/{itemId}")
	public void delete(@PathVariable Long itemId) {
	    // Verificar si el elemento existe en la base de datos
	    boolean itemExists = todoRepository.existsById(itemId);

	    if (itemExists) {
	        todoRepository.deleteById(itemId);
	    }
	}*/


	
}
