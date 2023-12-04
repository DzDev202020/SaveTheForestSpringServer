package model;

import java.sql.Date;
import java.util.Set;




public class Client {

	int id;
	String firstName;
	String lastName;

	String email;

	String password;

	String phonenumber;

	Date birthDate;

	int reputation;

	Set<Post> posts;

	Set<Fire> rFires;

	Set<Scale> rScales;

	public Client() {

	}

	public Client(int id, String firstName, String lastName, String email, String password, String phonenumber,
			 Date date, int reputation) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.birthDate = date;
		this.reputation = reputation;
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getDate() {
		return birthDate;
	}

	public void setDate(Date date) {
		this.birthDate = date;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public boolean equals(Client obj) {
		// TODO Auto-generated method stub
		return this.id == obj.id;
	}

	public String toString() {
		return "ID" + id + " / FIRSTNAME : " + firstName + " / LASTNAME : " + lastName + " / EMAIL : " + email
				+ " / PASSWORD : " + password +
//				" / BIRTHDATE : " + birthDate.toString() + 
				" / PHONENUMBER : " + phonenumber + " / reputation : " + reputation;
	}

}
