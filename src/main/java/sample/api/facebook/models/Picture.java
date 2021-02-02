package sample.api.facebook.models;

import java.util.HashMap;

public class Picture {
    HashMap<String,String> data = new HashMap<>();

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public String getPicUrl(){
        return this.data.get("url");
    }
}
