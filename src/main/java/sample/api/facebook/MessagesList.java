package sample.api.facebook;

import java.io.Serializable;
import java.util.List;

public class MessagesList implements Serializable {
    private List<Message> messageList;

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
