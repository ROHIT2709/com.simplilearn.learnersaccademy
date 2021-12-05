package com.learners_accademy.servlets;
import com.learners_accademy.entities.Classes; 
import com.learners_accademy.entities.Students;
import com.learners_accademy.entities.Subjects;
import com.learners_accademy.entities.Teachers;
import com.learners_accademy.hibernateconnection.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class AddRecords
 */
@WebServlet("/Add-Records")
public class AddRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Get-records.html").include(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String Cname = request.getParameter("Cname");
		String tfname = request.getParameter("tfname");
		/* String tlname = request.getParameter("tlname"); */
		String sub1= request.getParameter("sub_1");
		String sub2= request.getParameter("sub_2");
		String sub3= request.getParameter("sub_3");
		String type1= request.getParameter("types1");
		String type2= request.getParameter("types1");
		String type3= request.getParameter("types1");
		
		
		
		
		
		System.out.println("Class NAME:   " +Cname);
		String Bname = request.getParameter("Bname");
		Students students = new Students();
		students.setF_Name(fname);
		students.setL_Name(lname);
		List<Students> Stu = new ArrayList();
		Stu.add(students);
		Classes classes = new Classes();
		classes.setClass_Name(Cname);
		classes.setBatch_Month(Bname);
		List<Classes> clas = new ArrayList();
		clas.add(classes);
		Teachers teachers = new Teachers();
		teachers.settFname(tfname);
		//teachers.settLname(tlname);
		List<Teachers> teache = new ArrayList();
		teache.add(teachers);
		teachers.setClasses(clas);
		
		System.out.println("SUBJECT 1" +sub1);
		//Subjects subject = new Subjects();
		Subjects subjects1 = new Subjects();
	
		subjects1.setSubjectName(sub1);
		subjects1.setSubject_TYPE(type1);
		
		Subjects subjects2 = new Subjects();
		subjects2.setSubjectName(sub2);
		subjects1.setSubject_TYPE(type2);
		Subjects subjects3 = new Subjects();
		subjects3.setSubjectName(sub3);
		subjects1.setSubject_TYPE(type3);
		
		
		
		List<Subjects> subjects = new ArrayList();
		subjects.add(subjects1);
		subjects.add(subjects2);
		subjects.add(subjects3);
		/* subjects.add(subject); */
		
		students.setSubjectStudent(subjects);
		//subject.setSubStud(students);
		
		
		
		
		teachers.setStud(Stu);
		students.setTeach(teache);
		classes.setTeachers(teachers);
		students.setClasses(classes);
		classes.setStudent(students);
		
		Session session=sf.openSession();
		Transaction tx = session.beginTransaction();
        session.save(students);
		
		tx.commit();
		session.close();
		PrintWriter out = response.getWriter();
		out.append("<head><link rel=\"stylesheet\" href=\"style.css\"></head>");
		out.append("<form action =\"index.html\">");
		out.append("<h1>Details saved successfully</h1>");
		out.append("<input type=\"Submit\" value=\"GO BACK TO HOME\">");
		out.append("</form>");
		
		
		

	}

}
