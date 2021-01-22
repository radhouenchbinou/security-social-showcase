package sample.api.facebook.models;

import java.io.Serializable;

public class Message implements Serializable {
    private String id;
    private Profile from;
    private String message;
    private String created_time;


    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
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
