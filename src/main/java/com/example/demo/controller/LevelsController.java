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

import com.example.demo.entity.Levels;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LevelsRepository;

@RestController
@RequestMapping("api/v1/")
public class LevelsController {
	
	@Autowired
	private LevelsRepository levelsRepository;

	@GetMapping("/levels")
	public List<Levels> getAllSection() {
		return levelsRepository.findAll();
	}
	
	@PostMapping("/levels")
	public Levels createLevels(@RequestBody Levels levels) {
		return levelsRepository.save(levels);
	}
	@GetMapping("/levels/{id}")
	public ResponseEntity<Levels> getLevelsById(@PathVariable Long id) {
		Levels levels= levelsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Levels not found"));
		return ResponseEntity.ok(levels);
	}
	
	@PutMapping("/levels/{id}")
	public ResponseEntity<Levels> updateLevels(@PathVariable Long id, @RequestBody Levels levels) {
		Levels level= levelsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Levels not found"));
		Levels updatedLevel=levelsRepository.save(level);
		return ResponseEntity.ok(updatedLevel);
		
	}
	

}
