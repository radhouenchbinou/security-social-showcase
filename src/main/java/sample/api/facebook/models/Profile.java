package sample.api.facebook.models;

import lombok.Data;

import java.io.Serializable;


public class Profile implements Serializable {

	private String id;
	private String name;
	private Picture picture;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getPicUrl(){
		return picture.getPicUrl();
	}
}
