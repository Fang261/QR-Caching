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
@Table(name = "post")
public class PostI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;

    @Column(name = "post_foto", length = 300)
    private String photo;

    @Column(name = "post_text", length = 200)
    private String text;

    @ManyToOne
    @JoinColumn(name = "qrcode_id")
    private Lqrcode qrcodeItem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userItem;

    public PostI() {
        this.id = 0;
        this.photo = "";
        this.text = "";
    }

    public PostI(int id, String photo, String text) {
        this.id = id;
        this.photo = photo;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public String getText() {
        return text;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return photo + " " + text;
    }
}
