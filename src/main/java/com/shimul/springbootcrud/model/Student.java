package com.shimul.springbootcrud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	@Email @NotEmpty
	private String email;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	@Past @NotNull
	private Date dob;
	
	@NotEmpty
	private String country;
	
	@NotEmpty
	private String section;
	
	@NotEmpty
	private String sex;
	
	@Size(min=3,max=30)
	private String firstName;
	
	@Size(min=3,max=30)
	private String lastName;
	
	private boolean firstAttempt;
	
	@NotEmpty
	private List<String> subjects=new ArrayList<String>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isFirstAttempt() {
		return firstAttempt;
	}

	public void setFirstAttempt(boolean firstAttempt) {
		this.firstAttempt = firstAttempt;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	
	

}
