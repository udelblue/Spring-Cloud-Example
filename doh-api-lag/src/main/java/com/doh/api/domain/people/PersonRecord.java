package com.doh.api.domain.people;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.doh.api.domain.base.AuditedEntity;

/**
 *
 */

@Entity
@Table(name = "PersonRecord")
public class PersonRecord extends AuditedEntity {

    public PersonRecord() {
		super();
	}
	public PersonRecord(String first_name, String last_name, String comments) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;

		this.comments = comments;
	}
	@Override
	public String toString() {
		return "PersonRecord [first_name=" + first_name + ", last_name=" + last_name + ", dob=" + dob + ", comments="
				+ comments + "]";
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	private String first_name;
    private String last_name;
    private Date dob;
    private String comments;
 
}
