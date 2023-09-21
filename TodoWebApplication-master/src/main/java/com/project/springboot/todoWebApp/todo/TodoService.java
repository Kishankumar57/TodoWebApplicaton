package com.project.springboot.todoWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList();
	private static int todoCount = 0;
	static {
		todos.add(new Todo(++todoCount,"siddClases","Learn Aws",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"siddClases","Learn Java",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"siddClases","Learn Python",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"siddClases","Learn Docker",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"siddClases","Learn Kuernates",LocalDate.now().plusYears(1),false));
	}
	public List<Todo> findByUsername(String Username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(Username);
		return todos.stream().filter(predicate).toList(); 
	}
	public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
		Todo todo = new Todo(++todoCount,username,description,targetDate,done);
		todos.add(todo);
	}
	public void deleteByid(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	public Object findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
	  deleteByid(todo.getId());
		todos.add(todo);
	}
}
