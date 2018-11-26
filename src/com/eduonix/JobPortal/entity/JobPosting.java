package com.eduonix.JobPortal.entity;

public class JobPosting {
	private int id;
	private String messageBody;
	private String jobName;
	private String posterName;
	private String contactPhone;
	private String jobPostingPassword;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getPosterName() {
		return posterName;
	}
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getJobPostingPassword() {
		return jobPostingPassword;
	}
	public void setJobPostingPassword(String jobPostingPassword) {
		this.jobPostingPassword = jobPostingPassword;
	}
	

}
