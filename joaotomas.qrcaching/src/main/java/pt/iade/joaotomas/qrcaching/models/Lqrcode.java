package pt.iade.joaotomas.qrcaching.models;

import jakarta.persistence.*;


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



    public Lqrcode() {
        this.id = 0;
        this.qrcode = "";
        this.localPhoto = "";
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;

    }

    public Lqrcode(int id, String qrcode, String localPhoto, float latitude, float longitude, float altitude) {
        this.id = id;
        this.qrcode = qrcode;
        this.localPhoto = localPhoto;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    
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
            "}";
    }
}
