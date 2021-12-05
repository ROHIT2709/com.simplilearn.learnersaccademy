package com.learners_accademy.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="STUDENTS_TABLE")
public class Students {
	@Id
	@GeneratedValue
	@Column(name="ROLL_NO")
	private int rollNo;
	@Column(name="FIRST_NAME")
	private String f_Name;
	@Column(name="LAST_NAME")
	private String l_Name;
	
	
	@OneToOne(cascade = CascadeType.ALL,  mappedBy = "student")
	private Classes classes;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Teacher_Student_table", joinColumns= {@JoinColumn(name="ROLL_NO")},inverseJoinColumns = {@JoinColumn(name="FACULTY_EMPLOYEE_ID")} )
	private List<Teachers> teach;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="SubStud")
	private List<Subjects> subjectStudent;
	
	


	public void setSubjectStudent(List<Subjects> subjectStudent) {
		this.subjectStudent = subjectStudent;
	}
	
	public String getSubjectStudent() {
		StringBuilder sb = new StringBuilder();
		
		System.out.println("COURSE OBJECTS: " +subjectStudent.toString());
		if(subjectStudent!=null)
		{
			for(Subjects subs: subjectStudent) {
				sb.append(subs.getSubjectName()+",");
				System.out.println("SUBJECT NAME: " +subs.toString());
			}
			
		}
		return sb.toString();
	}


	public String getTeach1() {
StringBuilder sb = new StringBuilder();
		List<Teachers> te = new ArrayList();
		te.addAll(teach);
		System.out.println("teacher objects :"  +teach);
		
		if(te!=null)
		{
			
			
			for(Teachers teac : te) {
				sb.append(teac.gettFname()+" ");
				
			}
		}
		return sb.toString();
	
	
	
	}

	public void setTeach(List<Teachers> teach) {
		this.teach = teach;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getF_Name() {
		return f_Name;
	}

	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}

	public String getL_Name() {
		return l_Name;
	}

	public void setL_Name(String l_Name) {
		this.l_Name = l_Name;
	}
	
	public String getClasses() {
		StringBuilder sb = new StringBuilder();
		List<Classes> cl = new ArrayList();
		cl.add(classes);
		if(cl!=null)
		{
			
			for(Classes cls : cl) {
				sb.append(cls.getClass_Name()+" ");
				
			}
		}
		return sb.toString();
	}
	
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	
}
