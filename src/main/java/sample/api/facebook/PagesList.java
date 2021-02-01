package sample.api.facebook;

import sample.api.facebook.models.Page;
import sample.api.facebook.models.Paging;

import java.io.Serializable;
import java.util.List;

public class PagesList implements Serializable {
    private List<Page> data;
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

    public List<Page> getData() {
        return data;
    }

    public void setData(List<Page> pages) {
        this.data = pages;
    }
}
