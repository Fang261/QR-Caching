package pt.iade.joaotomas.QRCaching.models;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class QrcodeItem {
    private int id;
    private String streetName;
    private float latitude;
    private float longitude;
    private float altitude;
    private ArrayList<PhotoItem> photos;

    public QrcodeItem() {this(0, "Name", "streetName", 0,0 , 0, null);}

    public QrcodeItem(int id, String name, String streetName, float latitude, float longitude, float altitude, ArrayList<PhotoItem> photos) {
        this.id = id;
        this.streetName = streetName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.photos = photos;
    }

    public int getId() { return id; }

    public String getStreetName() { return streetName; }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public float getLatitude() { return latitude; }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() { return longitude; }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() { return altitude; }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public ArrayList<PhotoItem> getPhotos() { return photos; }

    public void setPhotos(ArrayList<PhotoItem> photos) {
        this.photos = photos;
    }

}