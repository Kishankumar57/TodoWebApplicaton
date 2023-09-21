package com.project.springboot.todoWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;
	
	
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAlltodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoService.findByUsername(username);
		model.put("todo", todos);
		return "listTodos";
	}

	private String getLoggedInUsername(ModelMap model) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showTodo(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "Todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "Todo";
		}
		String attr = getLoggedInUsername(model);
		todoService.addTodo(attr, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	@RequestMapping(value="dlt-todo",method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteByid(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo")
	public String showupdateTodo(@RequestParam int id,ModelMap model) {
		Todo todo = (Todo) todoService.findById(id);
		model.addAttribute("todo",todo);
		return "Todo";
	}
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "Todo";
		}
		String attr = getLoggedInUsername(model);
		todo.setUsername(attr);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
