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

import com.example.demo.dto.ProjectRequest;
import com.example.demo.entity.Project;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LevelsRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;

@RestController
@RequestMapping("api/v1/")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private LevelsRepository levelsRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	
	public List<Project> getAllSection() {
		return projectRepository.findAll();
	}
	
	@PostMapping("/project")
	public Project createproject(@RequestBody ProjectRequest project) {
		return projectRepository.save(project.getProject());
	}
	@GetMapping("/project/{id}")
	public ResponseEntity<Project> getprojectById(@PathVariable Long id) {
		Project project= projectRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("project not found"));
		return ResponseEntity.ok(project);
	}
	
	@PutMapping("/project/{id}")
	public ResponseEntity<Project> updateproject(@PathVariable Long id, @RequestBody ProjectRequest project) {
		Project proj= projectRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("project not found"));
		proj.setId(project.getProject().getId());
		proj.setName(project.getProject().getName());
		proj.setLevels(project.getProject().getLevels());
		Project updatedProject=projectRepository.save(proj);
		return ResponseEntity.ok(updatedProject);
		
	}
}
