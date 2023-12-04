package model;

import java.sql.Date;



public class Fireman {

	

	int id;

	String firstName;

	String lastName;

	String email;

	String password;

	long phonenumber;

	
	Date birthDate;

	String department;

	public Fireman() {

	}

	public Fireman(int id, String firstName, String lastName, String email, String password, long phonenumber,
			 Date date, String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.birthDate = date;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(short phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getDate() {
		return birthDate;
	}

	public void setDate(Date date) {
		this.birthDate = date;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	public boolean equals(Fireman obj) {
		// TODO Auto-generated method stub
		return this.id==obj.id;
	}
	
	
	public String toString() {
		return "ID" + id
				+ " FIRSTNAME" + firstName
				+ " LASTNAME" + lastName
				+ " EMAIL" + email
				+ " PASSWORD" + password
				+ " BIRTHDATE" + birthDate.toString()
				+ " PHONENUMBER" + phonenumber
				+ " DEPARTMENT" + department; 
	}
	

}
