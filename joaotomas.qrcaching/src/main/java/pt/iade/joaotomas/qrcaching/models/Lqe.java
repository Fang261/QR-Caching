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
@Table(name = "lqe")
public class Lqe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lqe_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "lqe_lqrcode_id")
    private Lqrcode lqrcodeItem;

    @ManyToOne
    @JoinColumn(name = "lqe_events_id")
    private EventI eventItem;

    public Lqe() {
    }

    public Lqe(Lqrcode lqrcodeItem, EventI eventItem) {
        this.lqrcodeItem = lqrcodeItem;
        this.eventItem = eventItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lqrcode getLqrcodeItem() {
        return lqrcodeItem;
    }

    public void setLqrcodeItem(Lqrcode lqrcodeItem) {
        this.lqrcodeItem = lqrcodeItem;
    }

    public EventI getEventItem() {
        return eventItem;
    }

    public void setEventItem(EventI eventItem) {
        this.eventItem = eventItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lqe lqeItem = (Lqe) o;

        return id == lqeItem.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
