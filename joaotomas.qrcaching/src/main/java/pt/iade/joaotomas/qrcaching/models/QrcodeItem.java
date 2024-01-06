package pt.iade.joaotomas.qrcaching.models;

public class QrcodeItem {

    //lqrcode_id int not null auto_increment,
	//lqrcode_qrcode VARCHAR(200),
	//lqrcode_localphoto VARCHAR(300),
    //lqrcode_latitude float(53) default 0,    
    //lqrcode_longitude float(53) default 0,   
    //lqrcode_altitude float(53) default 0,    
	//primary key (lqrcode_id)

    private int id;
    private String qrcode;
    private String localPhoto;
    private float latitude;
    private float longitude;
    private float altitude;

    public QrcodeItem() {
        this.id = 0;
        this.qrcode = "";
        this.localPhoto = "";
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;
    }

    public QrcodeItem(int id, String qrcode, String localPhoto, float latitude, float longitude, float altitude) {
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
}
