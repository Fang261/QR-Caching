package pt.iade.joaotomas.QRCaching.models;

import android.media.Image;

public class PhotoItem {
    private int id;
    private String photoUrl;

    public PhotoItem() {
        this(0,"");
    }

    //Constructor
    public PhotoItem(int id, String photoUrl) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoUrl() { return photoUrl; }

    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

}
