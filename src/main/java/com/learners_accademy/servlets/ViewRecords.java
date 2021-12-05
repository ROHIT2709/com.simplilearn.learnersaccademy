package com.learners_accademy.servlets;
import com.learners_accademy.hibernateconnection.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learners_accademy.entities.Students;


/**
 * Servlet implementation class ViewRecords
 */
@WebServlet("/View-Records")
public class ViewRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		
		List<Students> students = session.createQuery(" from Students").list();
	
		if(students!=null) {
			out.print("<head><link rel=\"stylesheet\" href=\"style.css\"></head>");
			out.print("<h1> DETAILS AND SECTIONS :- </h1>");

			out.print("<style> table,td,th { border:2px solid black; padding:10px;}</style>");
			out.print("<div style=\"height: 750px; overflow: auto\">");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Student Id </th>");
			out.print("<th> Student First Name </th>");
			out.print("<th> Student Last Name</th>");
			out.print("<th> Class assigned </th>");
			out.print("<th> Teacher assigned </th>");
			out.print("<th> Subjects Enrolled </th>");
			out.print("</tr>");
			for(Students student : students) {
				Subject subject = new Subject();
				out.print("<tr>");
				out.print("<td>"+student.getRollNo()+"</td>");
				out.print("<td>"+student.getF_Name()+"</td>");
				out.print("<td>"+student.getL_Name()+"</td>");
				out.print("<td>"+student.getClasses()+"</td>");
				out.print("<td>"+student.getTeach1()+"</td>");
				out.print("<td>"+student.getSubjectStudent()+"</td>");
				
				out.print("</tr>");
			}
			out.print("</div>");
			out.print("</table>");
		}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
