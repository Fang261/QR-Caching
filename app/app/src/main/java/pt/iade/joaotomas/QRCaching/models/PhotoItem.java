package pt.iade.joaotomas.QRCaching.models;

public class PhotoItem {
    private int id;
    private int idindb;

    public PhotoItem() {
        this(0,0);
    }


    //Constructor
    public PhotoItem(int id, int idindb) {
        this.id = id;
        this.idindb = idindb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdindb() {
        return idindb;
    }

    public void setIdindb(int idindb) {
        this.idindb = idindb;
    }
}
