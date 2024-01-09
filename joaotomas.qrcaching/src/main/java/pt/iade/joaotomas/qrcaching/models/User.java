package pt.iade.joaotomas.qrcaching.models;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name", length = 60, nullable = false)
    private String username;

    @Column(name = "user_password", length = 15, nullable = false)
    private String password;

    @Column(name = "user_phone")
    private int phone;

    @Column(name = "user_email", length = 30, nullable = false)
    private String email;

    @OneToMany(mappedBy = "userItem", cascade = CascadeType.ALL)
    private List<PostI> completedQrcodes;

    @OneToMany(mappedBy = "userItem", cascade = CascadeType.ALL)
    private List<AchivementI> achivements;

    public User() {
        this.id = 0;
        this.username = "";
        this.password = "";
        this.phone = 0;
        this.email = "";
        this.achivements = new ArrayList<>();
        this.completedQrcodes = new ArrayList<>();
    }

    public User(int id, String username, String password, int phone, String email,
                    List<PostI> completedQrcodes, List<AchivementI> achivements) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.completedQrcodes = new ArrayList<>(completedQrcodes);
        this.achivements = new ArrayList<>(achivements);
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PostI> getCompletedQrcodes() {
        return completedQrcodes;
    }

    public void setCompletedQrcodes(List<PostI> completedQrcodes) {
        this.completedQrcodes = completedQrcodes;
    }

    public List<AchivementI> getAchivements() {
        return achivements;
    }

    public void setAchivements(List<AchivementI> achivements) {
        this.achivements = achivements;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", phone='" + getPhone() + "'" +
                ", email='" + getEmail() + "'" +
                ", completedQrcodes='" + getCompletedQrcodes() + "'" +
                ", achivements='" + getAchivements() + "'" +
                "}";
    }
}
