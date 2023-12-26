package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.eventlist_adapter;

public class vault extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);
    }

    private RecyclerView photosListView;
    protected photolist_adapter photolistAdapter;

    protected ArrayList<photorow> itemList;


    private void setupComponents() {
        photolistAdapter = new eventlist_adapter(this, itemList);

        // set up the event list recycler view
        photosListView = (RecyclerView) findViewById(R.id.event_list);
        photosListView.setLayoutManager(new LinearLayoutManager(this));
        photosListView.setAdapter(photolistAdapter);

    }

}