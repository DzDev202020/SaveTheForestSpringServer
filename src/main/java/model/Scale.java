package model;



import java.sql.Date;

public class Scale {

	public enum FireScale {
		LOW, MEDIUM, HIGH
	}

	int id;

	String fireScale;
Date confirmedAt;

		int id_c;

	int id_f;

	Client rClient;

	Fire rFire;

	public Scale() {

	}

	public Scale(int id, int clientId, int fireId, FireScale firescale, Date confirmedtAt) {
		this.id = id;
		this.id_c = clientId;
		this.id_f = fireId;
		switch (firescale) {
		case LOW:
			this.fireScale = "LOW";
			break;
		case MEDIUM:
			this.fireScale = "MEDIUM";
			break;
		case HIGH:
			this.fireScale = "HIGH";
			break;
		}
		this.confirmedAt = confirmedtAt;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFireScale() {
		return fireScale;
	}

	public void setFireScale(String fireScale) {
		this.fireScale = fireScale;
	}


	public Date getConfirmedAt() {
		return confirmedAt;
	}

	public void setConfirmedAt(Date confirmedAt) {
		this.confirmedAt = confirmedAt;
	}


	public int getId_c() {
		return id_c;
	}

	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public int getId_f() {
		return id_f;
	}

	public void setId_f(int id_f) {
		this.id_f = id_f;
	}

	public Client getrClient() {
		return rClient;
	}

	public void setrClient(Client rClient) {
		this.rClient = rClient;
	}

	public Fire getrFire() {
		return rFire;
	}

	public void setrFire(Fire rFire) {
		this.rFire = rFire;
	}

	public boolean equals(Scale obj) {
		return this.id == obj.id;
	}

	public String toString() {
		if (confirmedAt != null)
			return "ID" + id + " / id_c : " + id_c + " / id_f : " + id_f + " / fireScale : " + fireScale
					+ " / confirmedtAt : " + confirmedAt.toString();
		else
			return "ID" + id + " / id_c : " + id_c + " / id_f : " + id_f + " / fireScale : " + fireScale;
	}
}
