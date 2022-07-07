package com.atcs.SpringJobPortal.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "selectedCandidates")
public class SelectedCandidates {

	@Id
	int selected_user_id;
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

	
	
	public SelectedCandidates(int selected_user_id, String name, String email, int contactno, Date dob, String gender,
			String skillSet, String address, int exp, String qualifications) {
		super();
		this.selected_user_id = selected_user_id;
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.dob = dob;
		this.gender = gender;
		SkillSet = skillSet;
		Address = address;
		this.exp = exp;
		this.qualifications = qualifications;
	}



	public SelectedCandidates() {
	
	}



	public int getSelected_user_id() {
		return selected_user_id;
	}



	public void setSelected_user_id(int selected_user_id) {
		this.selected_user_id = selected_user_id;
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
