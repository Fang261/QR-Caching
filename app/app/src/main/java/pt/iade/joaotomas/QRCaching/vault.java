package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.eventlist_adapter;
import pt.iade.joaotomas.QRCaching.adapters.photolist_adapter;
import pt.iade.joaotomas.QRCaching.models.EventItem;
import pt.iade.joaotomas.QRCaching.models.PhotoItem;

public class vault extends AppCompatActivity {
    private RecyclerView photosListView;
    protected photolist_adapter photolistAdapter;
    private static final int EDITOR_ACTIVITY_RETURN_ID = 1;

    protected ArrayList<PhotoItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);
    }

    private void setupComponents() {
        PhotoItem.List(new PhotoItem.ListResponse() {
            @Override
            public void response(ArrayList<PhotoItem> items) {
                itemList = items;

                photolistAdapter = new photolist_adapter(vault.this, itemList);
                photolistAdapter.setOnClickListener(new photolist_adapter.ItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(vault.this, photo.class);
                        intent.putExtra("position", position);
                        intent.putExtra("item", itemList.get(position));

                        startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
                    }
                });

            }
        });

        // set up the vault list recycler view
        photosListView = (RecyclerView) findViewById(R.id.photo_list);
        photosListView.setLayoutManager(new LinearLayoutManager(this));
        photosListView.setAdapter(photolistAdapter);

    }

}