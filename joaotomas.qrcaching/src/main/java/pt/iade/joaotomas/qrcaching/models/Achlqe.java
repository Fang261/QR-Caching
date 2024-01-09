package pt.iade.joaotomas.qrcaching.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "achlqe")
public class Achlqe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achlqe_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "achlqe_lqe_id")
    private Lqe lqeItem;

    @ManyToOne
    @JoinColumn(name = "achlqe_achivements_id")
    private Achivement achivementItem;

    public Achlqe() {
    }

    public Achlqe(Lqe lqeItem, Achivement achivementItem) {
        this.lqeItem = lqeItem;
        this.achivementItem = achivementItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lqe getLqeItem() {
        return lqeItem;
    }

    public void setLqeItem(Lqe lqeItem) {
        this.lqeItem = lqeItem;
    }

    public Achivement getAchivementItem() {
        return achivementItem;
    }

    public void setAchivementItem(Achivement achivementItem) {
        this.achivementItem = achivementItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Achlqe achlqeItem = (Achlqe) o;

        return id == achlqeItem.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
