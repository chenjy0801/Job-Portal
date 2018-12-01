package com.eduonix.JobPortal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.eduonix.JobPortal.entity.JobPosting;

public class JobPostingDAO {

	private Connection conn;

	public JobPostingDAO() {
		final String JDBC_DRIVER = new String("com.mysql.cj.jdbc.Driver");
		final String Database_URL = new String("jdbc:mysql://localhost/jobPortal");

		final String Database_USER = new String("root");
		final String Database_PASS = new String("czdaeq31");

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.conn = DriverManager.getConnection(Database_URL, Database_USER, Database_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JobPosting getJobPostingById(int id) {
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from jobPostings where id=" + id);

			if (rs.next()) {
				JobPosting jobPostToReturn = new JobPosting();
				jobPostToReturn.setContactPhone(rs.getString("contactPhone"));
				jobPostToReturn.setJobName(rs.getString("jobName"));
				jobPostToReturn.setPosterName(rs.getString("posterName"));
				jobPostToReturn.setMessageBody(rs.getString("messageBody"));
				jobPostToReturn.setId(rs.getInt("id"));
				jobPostToReturn.setJobPostingPassword(rs.getString("jobPostingPassword"));

				return jobPostToReturn;

			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return null;

	}

	public void insertJobPosting(JobPosting posting) {
		String sep = "','";
		try {
			Statement st = conn.createStatement();
			String sqlQuery = "insert into jobPostings(messageBody, jobName, posterName, contactPhone, jobPostingPassword values "
								+ posting.getMessageBody()+sep 
								+ posting.getJobName()+ sep 
								+ posting.getPosterName()+sep
								+ posting.getContactPhone()+sep 
								+ posting.getJobPostingPassword()+")";
			System.out.println(sqlQuery);
			st.executeUpdate(sqlQuery);
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeJobPosting(int jobPostId) {
		try {
			Statement st = conn.createStatement();
			String sqlQuery = "delete from jobPostings where id = "+jobPostId;
			System.out.println(sqlQuery);
			st.executeUpdate(sqlQuery);
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<JobPosting> getAllPostings() {
		return null;
	}
}
