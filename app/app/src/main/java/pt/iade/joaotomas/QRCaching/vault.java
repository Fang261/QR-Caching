package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.eventlist_adapter;
import pt.iade.joaotomas.QRCaching.adapters.photolist_adapter;
import pt.iade.joaotomas.QRCaching.models.EventItem;
import pt.iade.joaotomas.QRCaching.models.PhotoItem;
import pt.iade.joaotomas.QRCaching.models.QrcodeItem;

public class vault extends AppCompatActivity {
    private RecyclerView photosListView;
    protected photolist_adapter photolistAdapter;
    private static final int EDITOR_ACTIVITY_RETURN_ID = 1;
    private ImageButton gobackbutton;
    protected ArrayList<QrcodeItem> itemList;
    protected ArrayList<PhotoItem> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);
        String QRCodeValue = getIntent().getStringExtra("QRCodeValue");

        Intent intent = getIntent();
        if (intent != null) {
            itemList = (ArrayList<QrcodeItem>) intent.getSerializableExtra("itemList");
            if (itemList == null) {
                itemList = new ArrayList<>();
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(vault.this, R.style.AlertDialogCustom);
            builder.setTitle("Failed to load Lists");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
        gobackbutton = findViewById(R.id.profilepic_imageButton);

        for (QrcodeItem qrcode : itemList){
            if(qrcode.getQrcode().equals(QRCodeValue)) {
                photoList = qrcode.getPhotos();
            }
        }
        gobackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setupComponents();
    }

    private void setupComponents() {
        PhotoItem.List(new PhotoItem.ListResponse() {
            @Override
            public void response(ArrayList<PhotoItem> items) {
                photoList = items;

                photolistAdapter = new photolist_adapter(vault.this, photoList);
                photolistAdapter.setOnClickListener(new photolist_adapter.ItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(vault.this, photo.class);
                        intent.putExtra("position", position);
                        intent.putExtra("item", photoList.get(position));

                        startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
                    }
                });


            }
        });

        photosListView = findViewById(R.id.photo_list);
        photosListView.setLayoutManager(new LinearLayoutManager(this));
        photolistAdapter = new photolist_adapter(vault.this, photoList);
        photosListView.setAdapter(photolistAdapter);

    }

}