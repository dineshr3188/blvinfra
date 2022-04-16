package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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


public class Levels {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@OneToMany(targetEntity=Task.class, cascade = CascadeType.ALL)
	@JoinColumn(name="lt_fk" ,referencedColumnName="id")
	private List<Task> tasks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Levels(long id, List<Task> tasks) {
		super();
		this.id = id;
		this.tasks = tasks;
	}
	public Levels() {
	
	}

	@Override
	public String toString() {
		return "Levels {id=" + id + ", tasks=" + tasks + "}";
	}
	
	
	
}
