package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.qrcodelist_adapter;
import pt.iade.joaotomas.QRCaching.models.QrcodeItem;


public class profilepage extends AppCompatActivity {
    private Button gobackbutton;
    private RecyclerView itemsListView;
    protected qrcodelist_adapter qrcodelistAdapter;
    private ArrayList<QrcodeItem> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        gobackbutton = findViewById(R.id.goback_buttonprofile);

<<<<<<< HEAD
        Intent intent = getIntent();
        if (intent != null) {
            itemList = (ArrayList<QrcodeItem>) intent.getSerializableExtra("itemList");
            if (itemList == null) {
                itemList = new ArrayList<>();
            }
=======
        // Retrieve itemList from intent
        Intent intent = getIntent();
        if (intent != null) {
            itemList = (ArrayList<QrcodeItem>) intent.getSerializableExtra("itemList");
>>>>>>> c93dc1b5fb674f3c482a28e4604e8988bd45d399
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(profilepage.this, R.style.AlertDialogCustom);
            builder.setTitle("Failed to load Lists");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
        setupComponents();
    }

    private void setupComponents() {
        qrcodelistAdapter = new qrcodelist_adapter(this, itemList);

        // set up the qrcode list recycler view
        itemsListView = (RecyclerView) findViewById(R.id.qrcode_list);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));
        itemsListView.setAdapter(qrcodelistAdapter);

    }

}