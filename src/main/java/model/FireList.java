package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class FireList {

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private List<Fire> fireList;

	public List<Fire> getFireList() {
		return fireList;
	}

	public void setFireList(List<Fire> fireList) {
		this.fireList = fireList;
	}

	public FireList() {
	}
}
