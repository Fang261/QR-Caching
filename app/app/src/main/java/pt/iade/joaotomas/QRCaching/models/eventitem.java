package pt.iade.joaotomas.QRCaching.models;

public class eventitem {
    private int id;
    private String eventname;
    private float latitude;
    private float longitude;
    private String idate;
    private String fdate;


    public eventitem() {
        this(0, "", 0, 0, "", "");
    }


    //Constructor
    public eventitem(int id, String eventname, float latitude, float longitude, String idate, String fdate) {
        this.id = id;
        this.eventname = eventname;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idate = idate;
        this.fdate = fdate;
    }

    //Getters

    public int getId() {
        return id;
    }

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
