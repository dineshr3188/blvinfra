package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "task_name")
	private String taskName;
	@Column(name = "percentage")
	private long percentage;
	@Column(name = "notes")
	private String notes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public long getPercentage() {
		return percentage;
	}
	public void setPercentage(long percentage) {
		this.percentage = percentage;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Task(long id, String taskName, long percentage, String notes) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.percentage = percentage;
		this.notes = notes;
	}
	public Task() {
		
	}
	@Override
	public String toString() {
		return "Task {id=" + id + ", taskName=" + taskName + ", percentage=" + percentage + ", notes=" + notes + "}";
	}
	
	
}
