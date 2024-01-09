package pt.iade.joaotomas.qrcaching.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "achivement")
public class AchivementI {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achivement_id")
    private int id;

    @Column(name = "achivement_name", length = 100, nullable = false)
    private String name;

    @Column(name = "achivement_description", length = 255, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userItem;

    public AchivementI() {
        this.id = 0;
        this.name = "";
        this.description = "";
    }

    public AchivementI(int id, String name, String description, List<EventI> events) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                "}";
    }
}
