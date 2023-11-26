package pt.iade.joaotomas.QRCaching.models;

public class eventrow {
    private String eventname;
    private float latitude;
    private float longitude;
    private String idate;
    private String fdate;

    //Constructor
    public eventrow(String eventname, float latitude, float longitude, String idate, String fdate) {
        this.eventname = eventname;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idate = idate;
        this.fdate = fdate;
    }
    //Getters
    public String getEventname() {
        return eventname;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getIdate() {
        return idate;
    }

    public String getFdate() {
        return fdate;
    }
}
