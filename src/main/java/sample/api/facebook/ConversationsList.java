package sample.api.facebook;

import sample.api.facebook.models.Conversation;
import sample.api.facebook.models.Paging;

import java.util.List;

public class ConversationsList {
    private List<Conversation> data;
    private Paging paging;

    /**
     *
     * @return
     */
    public String getPagingAfter(){
        return paging.getCursors().get("after");
    }

    /**
     *
     * @return
     */
    public String  getPagingBefore(){
        return paging.getCursors().get("before");
    }

    /**
     *
     * @return
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     *
     * @param paging
     */
    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    /**
     *
     * @return
     */
    public List<Conversation> getData() {
        return data;
    }

    /**
     *
     * @param conversations
     */
    public void setData(List<Conversation> conversations) {
        this.data = conversations;
    }
}

