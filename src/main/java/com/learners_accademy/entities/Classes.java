package com.learners_accademy.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CLASSES_TABLE")
public class Classes {
	@Id
	@GeneratedValue
	@Column(name="CLASS_NO")
	private int class_no;
	@Column(name="CLASS_NAME")
	private String class_Name;
	
	@Column(name="Batch_Month")
	private String Batch_Month;
	public String getBatch_Month() {
		return Batch_Month;
	}
	public void setBatch_Month(String batch_Month) {
		Batch_Month = batch_Month;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sStudent_FK")
	
	private Students student;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="tTeacher_FK")
	
	private Teachers teachers;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "classsub")
	private List<Subjects> subs;
	
	public List<Subjects> getSubs() {
		return subs;
	}
	public void setSubs(List<Subjects> subs) {
		this.subs = subs;
	}
	public Teachers getTeachers() {
		return teachers;
	}
	
	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	
	public int getClass_no() {
		return class_no;
	}
	
	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}
	
	public String getClass_Name() {
		return class_Name;
	}
	
	public void setClass_Name(String class_Name) {
		this.class_Name = class_Name;
	}
	
	public Students getStudent() {
		return student;
	}
	
	
	public void setStudent(Students student) {
		this.student = student;
	}
	


}
