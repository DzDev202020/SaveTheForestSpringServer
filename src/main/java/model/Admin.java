package model;

import java.sql.Date;



public class Admin {

	
	int id;

	String firstName;

	String lastName;

	String email;

	String password;

	long phoneNumber;

	Date birthDate;
	String ipAddress;

	public Admin() {

	}

	public Admin(int ida, String firstName, String lastName, String email, String password, long phoneNumber,
			 Date birthDate, String ipAddress) {
		super();
		this.id = ida;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.ipAddress = ipAddress;
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
		return phoneNumber;
	}

	public void setPhonenumber(short phonenumber) {
		this.phoneNumber = phonenumber;
	}

	public Date getDate() {
		return birthDate;
	}

	public void setDate(Date date) {
		this.birthDate = date;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	
	public boolean equals(Admin obj) {
		// TODO Auto-generated method stub
		return this.id==obj.id;
	}
	
}
