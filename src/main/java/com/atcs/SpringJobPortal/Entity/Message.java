package com.atcs.SpringJobPortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "messages")
public class Message {

		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	String msg;
	
	@Column
	int From_userid;
	
	@Column
	int To_companyid;

	public Message(int id, String msg, int from_userid, int to_companyid) {
		super();
		this.id = id;
		this.msg = msg;
		From_userid = from_userid;
		To_companyid = to_companyid;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getFrom_userid() {
		return From_userid;
	}

	public void setFrom_userid(int from_userid) {
		From_userid = from_userid;
	}

	public int getTo_companyid() {
		return To_companyid;
	}

	public void setTo_companyid(int to_companyid) {
		To_companyid = to_companyid;
	}
	
	
	
}
