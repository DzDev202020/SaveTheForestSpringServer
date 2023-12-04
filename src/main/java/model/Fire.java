package model;



import java.sql.Date;
import java.util.Set;


public class Fire {

	

	int id;
	
	Date createdDate;

	Date controledAt;
	
	Double latitude;

	Double longitude;

	String street;

	String city;

	String zipcode;

	String country;
	

	int id_c;

	Client rClient;

	Set<Post> rPosts;

	Set<Scale> rScales;
	
	
	

	public Fire() {

	}

	public Fire(int id, int clinetId, Date createdDate, Date controledAt) {
		super();
		this.id = id;
//		this.id_c = clinetId;
		this.createdDate = createdDate;
		this.controledAt = controledAt;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getControledAt() {
		return controledAt;
	}

//	public int getId_c() {
//		return id_c;
//	}
//
//	public void setId_c(int id_c) {
//		this.id_c = id_c;
//	}

	public void setControledAt(Date controledAt) {
		this.controledAt = controledAt;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public int getId_c() {
		return id_c;
	}

	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



//	public int getId_c() {
//		return id_c;
//	}
//
//	public void setId_c(int id_c) {
//		this.id_c = id_c;
//	}

	public Client getrClient() {
		return rClient;
	}

	public void setrClient(Client rClient) {
		this.rClient = rClient;
	}

	public Set<Post> getrPosts() {
		return rPosts;
	}

	public void setrPosts(Set<Post> rPosts) {
		this.rPosts = rPosts;
	}

	public Set<Scale> getrScales() {
		return rScales;
	}

	public void setrScales(Set<Scale> rScales) {
		this.rScales = rScales;
	}

	public boolean equals(Fire obj) {
		// TODO Auto-generated method stub
		return this.id==obj.id;
	}
	
	public String toString() {
		return "ID" + id +
				" / latitude : " + latitude +
				" / longitude : " + longitude + 
				" / street : " + street + 
				" / city : " + city +
				" / createdDate : " + createdDate.toString() ; 
//				" / id_c : " + id_c ;
	}

}
