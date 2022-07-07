package com.atcs.SpringJobPortal.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {

	public User(int user_id, String name, String email, int contactno, Date dob, String gender, String skillSet,
			String address, int exp, String qualifications, List<Job> appliedJobs) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.dob = dob;
		this.gender = gender;
		SkillSet = skillSet;
		Address = address;
		this.exp = exp;
		this.qualifications = qualifications;
		AppliedJobs = appliedJobs;
	}

	User() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int user_id;
	@Column
	String name;
	@Column
	String email;
	@Column
	int contactno;
	@Column
	Date dob;
	@Column
	String gender;
	@Column
	String SkillSet;
	@Column
	String Address;
	@Column
	int exp;
	@Column
	String qualifications;
	
	@ManyToMany
	List<Job> AppliedJobs;
	
	
	
	public List<Job> getAppliedJobs() {
		return AppliedJobs;
	}

	public void setAppliedJobs(List<Job> appliedJobs) {
		AppliedJobs = appliedJobs;
	}
	
	
	
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactno() {
		return contactno;
	}

	public void setContactno(int contactno) {
		this.contactno = contactno;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSkillSet() {
		return SkillSet;
	}

	public void setSkillSet(String skillSet) {
		SkillSet = skillSet;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	
	

}