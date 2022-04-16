package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TaskRepository;

@RestController
@RequestMapping("api/v1/")
public class TaskController {

	@Autowired
	private TaskRepository subTaskRepository;

	@GetMapping("/task")
	public List<Task> getAllCsutomer() {
		return subTaskRepository.findAll();
	}
	
	@PostMapping("/task")
	public Task createsubTask(@RequestBody Task subTask) {
		return subTaskRepository.save(subTask);
	}
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getsubTaskById(@PathVariable Long id) {
		Task subTask= subTaskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("subTask not found"));
		return ResponseEntity.ok(subTask);
	}
	
	@PutMapping("/task/{id}")
	public ResponseEntity<Task> updatesubTask(@PathVariable Long id, @RequestBody Task subTask) {
		Task subTasks= subTaskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("subTask not found"));
		
//		subTasks.setNotes(subTask.getNotes());
//		subTasks.setPercentage(subTask.getPercentage());
//		subTasks.setTaskName(subTask.getTaskName());
		
		Task updatedsubTask=subTaskRepository.save(subTasks);
		return ResponseEntity.ok(updatedsubTask);
		
	}
}
