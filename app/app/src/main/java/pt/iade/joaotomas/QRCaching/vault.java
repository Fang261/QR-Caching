package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.photolist_adapter;
import pt.iade.joaotomas.QRCaching.models.PhotoItem;

public class vault extends AppCompatActivity {
    private RecyclerView photosListView;
    protected photolist_adapter photolistAdapter;

    protected ArrayList<PhotoItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);
    }

    private void setupComponents() {
        photolistAdapter = new photolist_adapter(this, itemList);

        // set up the vault list recycler view
        photosListView = (RecyclerView) findViewById(R.id.photo_list);
        photosListView.setLayoutManager(new LinearLayoutManager(this));
        photosListView.setAdapter(photolistAdapter);

    }

}