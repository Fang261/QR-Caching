package pt.iade.joaotomas.qrcaching.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "events_id")
    private int id;

    @Column(name = "events_name")
    private String eventname;

    @Column(name = "events_latitude")
    private Double latitude;

    @Column(name = "events_longitude")
    private Double longitude;

    @Column(name = "events_idate")
    private LocalDate inicial_date;

    @Column(name = "events_fdate")
    private LocalDate final_date;

    @Column(name = "events_localphoto")
    private String localPhoto;


    public Event() {
    }

    public Event(int id, String eventname, Double latitude, Double longitude, LocalDate inicial_date, LocalDate final_date,
            String localPhoto) {
        this.id = id;
        this.eventname = eventname;
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
        return eventname;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
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

    public void setName(String eventname) {
        this.eventname = eventname;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", eventname='" + getName() + "'" +
                ", latitude='" + getLatitude() + "'" +
                ", longitude='" + getLongitude() + "'" +
                ", inicial_date='" + getInicial_date() + "'" +
                ", final_date='" + getFinal_date() + "'" +
                ", localPhoto='" + getLocalPhoto() + "'" +
                "}";
    }
}