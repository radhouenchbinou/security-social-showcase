package sample.api.facebook;

import java.io.Serializable;
import java.util.List;

public class Conversation implements Serializable {
    private String id;
    private String Snippet;
    private List<Profile> senders;
    private int unreadCount;

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSnippet() {
        return Snippet;
    }

    public void setSnippet(String snippet) {
        Snippet = snippet;
    }

    public List<Profile> getSenders() {
        return senders;
    }

    public void setSenders(List<Profile> senders) {
        this.senders = senders;
    }
}
