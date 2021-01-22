package sample.api.facebook;

import sample.api.facebook.models.Message;

import java.io.Serializable;
import java.util.List;

public class MessagesList implements Serializable {
    private List<Message> data;
    private String next;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Message> getData() {
        return data;
    }

    public void setData(List<Message> messageList) {
        this.data = messageList;
    }
}

