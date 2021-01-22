package sample.api.facebook;

import sample.api.facebook.models.Page;

import java.io.Serializable;
import java.util.List;

public class PagesList implements Serializable {
    private List<Page> data;

    public List<Page> getData() {
        return data;
    }

    public void setData(List<Page> pages) {
        this.data = pages;
    }
}
