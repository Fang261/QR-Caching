package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

<<<<<<< HEAD
import pt.iade.joaotomas.QRCaching.models.eventitem;

public class event_page extends AppCompatActivity {
    //protected EditText street;
    protected eventitem item;
=======
import pt.iade.joaotomas.QRCaching.models.Eventrow;

public class event_page extends AppCompatActivity {
    //protected EditText street;
    protected Eventrow item;
>>>>>>> tomas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);

<<<<<<< HEAD
        item = new eventitem();
=======
        item = new Eventrow();
>>>>>>> tomas

        setupComponents();
    }

    private void setupComponents() {
        //street = (EditText);
    }
}