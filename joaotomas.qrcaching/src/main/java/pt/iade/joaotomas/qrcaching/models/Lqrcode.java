package pt.iade.joaotomas.qrcaching.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "lqrcode")
public class Lqrcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lqrcode_id")
    private int id;

    @Column(name = "lqrcode_qrcode", length = 200)
    private String qrcode;

    @Column(name = "lqrcode_localphoto", length = 300)
    private String localPhoto;

    @Column(name = "lqrcode_latitude")
    private float latitude;

    @Column(name = "lqrcode_longitude")
    private float longitude;

    @Column(name = "lqrcode_altitude")
    private float altitude;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventI eventItem;


    @OneToMany(mappedBy = "qrcodeItem", cascade = CascadeType.ALL)
    private ArrayList<PostI> photos;

    public Lqrcode() {
        this.id = 0;
        this.qrcode = "";
        this.localPhoto = "";
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;
        this.photos = new ArrayList<>();
    }

    public Lqrcode(int id, String qrcode, String localPhoto, float latitude, float longitude, float altitude, ArrayList<PostI> photos) {
        this.id = id;
        this.qrcode = qrcode;
        this.localPhoto = localPhoto;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.photos = photos;
    }

    public ArrayList<PostI> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<PostI> photos) {
        this.photos = photos;
    }

    public int getId() {
        return id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public String getLocalPhoto() {
        return localPhoto;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public void setLocalPhoto(String localPhoto) {
        this.localPhoto = localPhoto;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", qrcode='" + getQrcode() + "'" +
            ", localPhoto='" + getLocalPhoto() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", altitude='" + getAltitude() + "'" +
            ", photos='" + getPhotos() + "'" +
            "}";
    }
}
