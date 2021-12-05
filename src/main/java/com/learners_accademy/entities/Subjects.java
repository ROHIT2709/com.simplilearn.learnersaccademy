package com.learners_accademy.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="Subjects_Table")
public class Subjects {
	@Id
	@GeneratedValue
	@Column(name="SUBJECT_ID")
   private int SubjectID;
	@Column(name="SUBJECT_NAME")
   private String SubjectName;
	@Column(name="SUBJECT_TYPE")
	   private String Subject_TYPE;
	public String getSubject_TYPE() {
		return Subject_TYPE;
	}

	public void setSubject_TYPE(String subject_TYPE) {
		Subject_TYPE = subject_TYPE;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="TEACHER_SUBJECT_FK")
	private Teachers teachsub;
   
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CLASS_SUBJECT_FK")
	private Classes classsub;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="STUDENT_SUBJECT_FK")
	private Students SubStud;
	
	
	
	public Students getSubStud() {
		return SubStud;
	}

	public void setSubStud(Students subStud) {
		SubStud = subStud;
	}

	public void setSubjectID(int subjectID) {
		SubjectID = subjectID;
	}

	public Classes getClasssub() {
		return classsub;
	}

	public void setClasssub(Classes classsub) {
		this.classsub = classsub;
	}

	@Override
	public String toString() {
		return "Subjects [SubjectID=" + SubjectID + ", SubjectName=" + SubjectName + ", teachsub=" + teachsub
				+ ", classsub=" + classsub + ", SubStud=" + SubStud + "]";
	}

	public int getSubjectID() {
		return SubjectID;
	}

	

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		System.out.println("SUBJECT NAME: "  +subjectName);
		SubjectName = subjectName;
	}

	public Teachers getTeachsub() {
		return teachsub;
	}

	public void setTeachsub(Teachers teachsub) {
		this.teachsub = teachsub;
	}

	
	
	

}
