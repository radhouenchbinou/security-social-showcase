package sample.api.facebook;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Message implements Serializable {
    private String id;
    private Profile from;
    private String message;
    private String createdTIme;

    public String getCreatedTIme() {
        return createdTIme;
    }

    public void setCreatedTIme(String createdTIme) {
        this.createdTIme = createdTIme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profile getFrom() {
        return from;
    }

    public void setFrom(Profile from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
