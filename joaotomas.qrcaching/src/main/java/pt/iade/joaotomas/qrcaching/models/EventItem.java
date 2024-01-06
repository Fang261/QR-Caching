package pt.iade.joaotomas.qrcaching.models;

import java.time.LocalDate;

public class EventItem {
    private int id; //events_id int not null auto_increment,
	private String name; //events_name VARCHAR(40) not null,
	private float latitude; //events_latitude float(53) default 0,    
	private float longitude; //events_longitude float(53) default 0,   
	private LocalDate inicial_date; //events_idate date not null,
	private LocalDate final_date; //events_fdate date,  
    private String localPhoto; //events_localphoto VARCHAR(300);  

    public EventItem() {
        this.id = 0;
        this.name = "";
        this.latitude = 0;
        this.longitude = 0;
        this.inicial_date = LocalDate.now();
        this.final_date = LocalDate.now();
        this.localPhoto = "";
        
    }

    public EventItem(int id, String name, float latitude, float longitude, LocalDate inicial_date, LocalDate final_date, String localPhoto) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.inicial_date = inicial_date;
        this.final_date = final_date;
        this.localPhoto = localPhoto;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public LocalDate getInicial_date() {
        return inicial_date;
    }

    public LocalDate getFinal_date() {
        return final_date;
    }

    public String getLocalPhoto() {
        return localPhoto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInicial_date(LocalDate inicial_date) {
        this.inicial_date = inicial_date;
    }

    public void setFinal_date(LocalDate final_date) {
        this.final_date = final_date;
    }

    public void setLocalPhoto(String localPhoto) {
        this.localPhoto = localPhoto;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
}
