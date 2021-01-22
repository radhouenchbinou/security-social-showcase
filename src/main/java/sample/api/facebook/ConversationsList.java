package sample.api.facebook;

import sample.api.facebook.models.Conversation;

import java.util.List;

public class ConversationsList {
    private List<Conversation> data;
    private String next;
    public List<Conversation> getData() {
        return data;
    }

    public void setData(List<Conversation> conversations) {
        this.data = conversations;
    }
}

