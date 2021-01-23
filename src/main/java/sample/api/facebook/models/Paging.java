package sample.api.facebook.models;

import java.io.Serializable;
import java.util.HashMap;

public class Paging implements Serializable {
    HashMap<String, String> cursors;

    public HashMap<String, String> getCursors() {
        return cursors;
    }

    public void setCursors(HashMap<String, String> cursors) {
        this.cursors = cursors;
    }
}
