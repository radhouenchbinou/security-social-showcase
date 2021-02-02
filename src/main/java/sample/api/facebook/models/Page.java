package sample.api.facebook.models;

import lombok.Data;

import java.io.Serializable;


public class Page implements Serializable {
    private String id;
    private String name;
    private String access_token;
    private Picture picture;


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

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

    public Picture getPicture() { return picture; }

    public void setPicture(Picture picture) {this.picture = picture;}

    public String getPicUrl(){return picture.getPicUrl();}
}
