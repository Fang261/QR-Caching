package pt.iade.joaotomas.qrcaching.models;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "events_id")
    private int id;

    @Column(name = "events_name")
    private String name;

    @Column(name = "events_latitude")
    private float latitude;

    @Column(name = "events_longitude")
    private float longitude;

    @Column(name = "events_idate")
    private LocalDate inicial_date;

    @Column(name = "events_fdate")
    private LocalDate final_date;

    @Column(name = "events_localphoto")
    private String localPhoto;

    @OneToMany(mappedBy = "eventItem", cascade = CascadeType.ALL)
    private List<Lqrcode> qrcodes;

    public Event() {
    }

    public Event(int id, String name, float latitude, float longitude, LocalDate inicial_date, LocalDate final_date,
            String localPhoto, List<Lqrcode> qrcodes) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.inicial_date = inicial_date;
        this.final_date = final_date;
        this.localPhoto = localPhoto;
        this.qrcodes = qrcodes;
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

    public List<Lqrcode> getQrcodes() {
        return qrcodes;
    }

    public void setQrcodes(List<Lqrcode> qrcodes) {
        this.qrcodes = qrcodes;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", latitude='" + getLatitude() + "'" +
                ", longitude='" + getLongitude() + "'" +
                ", inicial_date='" + getInicial_date() + "'" +
                ", final_date='" + getFinal_date() + "'" +
                ", localPhoto='" + getLocalPhoto() + "'" +
                ", qrcodes='" + getQrcodes() + "'" +
                "}";
    }
}