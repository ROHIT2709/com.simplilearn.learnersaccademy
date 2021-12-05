package com.learners_accademy.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TEACHERS_TABLE")
public class Teachers {
	@Id
	@GeneratedValue
	@Column(name= "FACULTY_EMPLOYEE_ID")
	private int empID;
	
	@Column(name= "TEACHER_NAME")
	private String tFname;
	/*
	 * @Column(name= "LAST_NAME") private String tLname;
	 */
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "teachers")
	private List<Classes> classes;
	
	@ManyToMany(cascade= CascadeType.ALL, mappedBy="teach")
	private List<Students> stud;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "teachsub")
	private List<Subjects> subjects;
	
	
	public List<Subjects> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String gettFname() {
		return tFname;
	}
	public void settFname(String tFname) {
		this.tFname = tFname;
	}

	/*
	 * public String gettLname() { return tLname; } public void settLname(String
	 * tLname) { this.tLname = tLname; }
	 */
	public List<Classes> getClasses() {
		return classes;
	}
	public void setClasses(List<Classes> classes) {
		this.classes = classes;
		
		
	}
	
	
	
	public List<Students> getStud() {
		return stud;
	}
	public void setStud(List<Students> stud) {
		this.stud = stud;
	}

}
