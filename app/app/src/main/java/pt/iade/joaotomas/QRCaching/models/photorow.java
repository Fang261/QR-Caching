package pt.iade.joaotomas.QRCaching.models;

public class photorow {
    private int id;
    private int idindb;

    public photorow() {
        this(0,0);
    }


    //Constructor
    public photorow(int id, int idindb) {
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
