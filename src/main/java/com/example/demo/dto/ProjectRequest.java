package com.example.demo.dto;

import com.example.demo.entity.Project;



import lombok.ToString;



@ToString
public class ProjectRequest {

	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProjectRequest(Project project) {
		super();
		this.project = project;
	}

	public ProjectRequest() {
		
	}

	@Override
	public String toString() {
		return "ProjectRequest {project=" + project + "}";
	}
	
	
}
