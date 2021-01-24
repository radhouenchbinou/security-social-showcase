package sample.api.facebook;

import sample.api.facebook.models.Message;
import sample.api.facebook.models.Paging;

import java.io.Serializable;
import java.util.List;

public class MessagesList implements Serializable {
    private List<Message> data;
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

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<Message> getData() {
        return data;
    }

    public void setData(List<Message> messageList) {
        this.data = messageList;
    }
}

