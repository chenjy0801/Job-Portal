package com.eduonix.JobPortal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduonix.JobPortal.dao.JobPostingDAO;
import com.eduonix.JobPortal.entity.JobPosting;


@WebServlet("/ViewJobs")
public class ViewJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobPostingDAO dao=new JobPostingDAO();
		
		List<JobPosting> jobs=dao.getAllPostings();
		request.setAttribute("jobs", jobs);
		RequestDispatcher rd = request.getRequestDispatcher("/viewJobs.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
