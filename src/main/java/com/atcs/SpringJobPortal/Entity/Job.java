package com.atcs.SpringJobPortal.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "job")
public class Job {
	

	public Job(int job_id, String role, String location, int exp, String skills, int ctc, String deadline, String type,
			String postdate, int companyid, String degreeReq, List<User> appliedUsers) {
		super();
		this.job_id = job_id;
		this.role = role;
		this.location = location;
		this.exp = exp;
		this.skills = skills;
		this.ctc = ctc;
		this.deadline = deadline;
		this.type = type;
		this.postdate = postdate;
		this.companyid = companyid;
		this.degreeReq = degreeReq;
		AppliedUsers = appliedUsers;
	}

	Job() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int job_id;
	@Column
	String role;
	@Column
	String location;
	@Column
	int exp;
	@Column
	String skills;
	@Column
	int ctc;
	@Column
	String deadline;
	@Column
	String type;
	@Column
	String postdate;
	@Column
	int companyid;
	@Column
	String degreeReq;
	
	
	@ManyToMany(mappedBy = "AppliedJobs")
	List<User> AppliedUsers;
	
	@JsonIgnore
	public List<User> getAppliedUsers() {
		return AppliedUsers;
	}

	public void setAppliedUsers(List<User> appliedUsers) {
		AppliedUsers = appliedUsers;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getCtc() {
		return ctc;
	}

	public void setCtc(int ctc) {
		this.ctc = ctc;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public String getDegreeReq() {
		return degreeReq;
	}

	public void setDegreeReq(String degreeReq) {
		this.degreeReq = degreeReq;
	}

	
	
	
}
