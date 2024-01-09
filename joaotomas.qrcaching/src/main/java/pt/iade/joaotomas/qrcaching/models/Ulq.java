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
@Table(name = "ulq")
public class Ulq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ulq_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ulq_user_id")
    private User userItem;

    @ManyToOne
    @JoinColumn(name = "ulq_post_id")
    private PostI postItem;

    @ManyToOne
    @JoinColumn(name = "ulq_lqrcode_id")
    private Lqrcode lqrcodeItem;

    public Ulq() {
    }

    public Ulq(User userItem, PostI postItem, Lqrcode lqrcodeItem) {
        this.userItem = userItem;
        this.postItem = postItem;
        this.lqrcodeItem = lqrcodeItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserItem() {
        return userItem;
    }

    public void setUserItem(User userItem) {
        this.userItem = userItem;
    }

    public PostI getPostItem() {
        return postItem;
    }

    public void setPostItem(PostI postItem) {
        this.postItem = postItem;
    }

    public Lqrcode getLqrcodeItem() {
        return lqrcodeItem;
    }

    public void setLqrcodeItem(Lqrcode lqrcodeItem) {
        this.lqrcodeItem = lqrcodeItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ulq ulqItem = (Ulq) o;

        return id == ulqItem.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
