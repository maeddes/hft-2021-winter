package de.maeddes.TodoListSpringBootRestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todos")
public class TodoRestController {

	@Autowired
	TodoRestRepository todoRepository;

    @GetMapping(produces = "application/json")
	List<Todo> all(){

		List<Todo> todos = new ArrayList<Todo>();
		todoRepository.findAll().forEach(todos::add);
		return todos;
	}

	@GetMapping(path = "/{name}", produces = "application/json")
	Todo getTodo(@PathVariable String name){

		Optional<Todo> optional = todoRepository.findById(name);
		Todo todo = optional.get();
		return todo;

	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	Todo addTodo(@RequestBody Todo todo){

		todoRepository.save(todo);
		return todo;

	}

	@PostMapping(path = "/{name}", produces = "application/json")
	Todo addTodo(@PathVariable String name){

		Todo todo = new Todo(name);
		todoRepository.save(todo);
		return todo;

	}
	
	@PostMapping(path = "/{name}/{priority}", produces = "application/json")
	Todo addTodo(@PathVariable String name, @PathVariable int priority){

		Todo todo = new Todo(name,priority);
		todoRepository.save(todo);
		return todo;

	}

	@DeleteMapping(path = "/{name}", produces = "application/json")
	Todo deleteTodo(@PathVariable String name){

		todoRepository.deleteById(name);
		return null;

	}
    
}
