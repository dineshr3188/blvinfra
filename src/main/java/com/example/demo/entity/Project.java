package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Entity


public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="name")
	private String name;
	
	
	
	
	@OneToMany(targetEntity=Levels.class, cascade = CascadeType.ALL)
	@JoinColumn(name="pl_fk" ,referencedColumnName="id")
	private List<Levels> levels ;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Levels> getLevels() {
		return levels;
	}


	public void setLevels(List<Levels> levels) {
		this.levels = levels;
	}


	public Project(long id, String name, List<Levels> levels) {
		super();
		this.id = id;
		this.name = name;
		this.levels = levels;
	}
	public Project() {
		
	}


	@Override
	public String toString() {
		return "Project {id=" + id + ", name=" + name + ", levels=" + levels + "}";
	}
	
	
	
}
