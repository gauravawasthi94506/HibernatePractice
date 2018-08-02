package com.gaurav.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeDetails1")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column
	private String userName;
	@Embedded
	
	@AttributeOverrides({
		@AttributeOverride(name = "street",column = @Column(name="Streat_Name_HOME")),
		@AttributeOverride(name = "city",column = @Column(name="City_Name_HOME")),
		@AttributeOverride(name = "state",column = @Column(name="State_Name_HOME")),
		@AttributeOverride(name = "pincode",column = @Column(name="Pincode_Name_HOME")),
		@AttributeOverride(name = "date",column = @Column(name="Date_Name_HOME"))
		})
	private Address adr_home;
	
	/*@AttributeOverrides({
		@AttributeOverride(name = "street",column = @Column(name="Office_Name_HOME")),
		@AttributeOverride(name = "city",column = @Column(name="Office_Name_HOME")),
		@AttributeOverride(name = "state",column = @Column(name="office_Name_HOME")),
		@AttributeOverride(name = "pincode",column = @Column(name="Office_Name_HOME")),
		@AttributeOverride(name = "date",column = @Column(name="office_Name_HOME"))
		})*/
	private Address adr_office;
	
	
	
	public Address getAdr_office() {
		return adr_office;
	}
	public void setAdr_office(Address adr_office) {
		this.adr_office = adr_office;
	}
	public Address getAdr_home() {
		return adr_home;
	}
	public void setAdr_home(Address adr_home) {
		this.adr_home = adr_home;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
