package sample.api.facebook.models;

import sample.api.facebook.ProfilesList;
import sample.api.facebook.models.Profile;

import java.io.Serializable;
import java.util.List;

public class Conversation implements Serializable {
    private String id;
    private String snippet;
    private ProfilesList senders;
    private int unread_count;
    private Paging paging;


    public int getUnreadCount() {
        return unread_count;
    }

    public ProfilesList getSenders() {
        return senders;
    }

    public void setSenders(ProfilesList senders) {
        this.senders = senders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public int getUnread_count() {
        return unread_count;
    }

    public void setUnread_count(int unread_count) {
        this.unread_count = unread_count;
    }
}
