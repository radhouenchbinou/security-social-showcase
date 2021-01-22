package sample.api.facebook;

import sample.api.facebook.models.Profile;

import java.io.Serializable;
import java.util.List;

public class ProfilesList implements Serializable {
    private List<Profile> data;

    public List<Profile> getData() {
        return data;
    }

    public void setData(List<Profile> data) {
        this.data = data;
    }
}
