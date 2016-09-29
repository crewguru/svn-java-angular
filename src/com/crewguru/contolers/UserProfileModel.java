package com.crewguru.contolers;

import java.sql.Date;

public class UserProfileModel {
	
	private String userName;
	private String profession;
	private String profileName;
	private String profileDescription;
	private String profilePicLoc;
	private Date createdDate;
	private Date updatedDate;
	
	
	
	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getProfession() {
		return profession;
	}
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getProfileDescription() {
		return profileDescription;
	}
	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}
	public String getProfilePicLoc() {
		return profilePicLoc;
	}
	public void setProfilePicLoc(String profilePicLoc) {
		this.profilePicLoc = profilePicLoc;
	}
	
	
	

}
