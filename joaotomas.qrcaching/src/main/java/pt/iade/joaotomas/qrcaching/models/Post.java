package pt.iade.joaotomas.qrcaching.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;

    @Column(name = "post_foto", length = 300)
    private String photoPath;

    @Column(name = "post_text", length = 200)
    private String text;

    public Post() {
        this.id = 0;
        this.photoPath = "";
        this.text = "";
    }

    public Post(int id, String photoPath, String text) {
        this.id = id;
        this.photoPath = photoPath;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getPhoto() {
        return photoPath;
    }

    public String getText() {
        return text;
    }

    public void setPhoto(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return photoPath + " " + text;
    }
}
