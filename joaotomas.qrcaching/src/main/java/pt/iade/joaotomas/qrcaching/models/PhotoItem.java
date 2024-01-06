package pt.iade.joaotomas.qrcaching.models;

public class PhotoItem {
    //post_id int not null auto_increment,
	//post_foto VARCHAR(300),		                
	//post_text VARCHAR(200), 			
	//primary key (post_id)

    private int id;
    private String photo;
    private String text;

    public PhotoItem() {
        this.id = 0;
        this.photo = "";
        this.text = "";
    }

    public PhotoItem(int id, String photo, String text) {
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


}
