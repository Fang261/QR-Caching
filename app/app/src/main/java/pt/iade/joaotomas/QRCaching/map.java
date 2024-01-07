package pt.iade.joaotomas.QRCaching;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.SupportMapFragment;


import pt.iade.joaotomas.QRCaching.R;
import pt.iade.joaotomas.QRCaching.models.QrcodeItem;

public class map extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button gobackbutton;
    private ImageButton profilepic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(map.this, R.style.AlertDialogCustom);
            builder.setTitle("Failed to load map");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }

        Button gobackbutton = findViewById(R.id.goback_buttonmap);
        ImageButton profilepic = findViewById(R.id.profilepic_imageButton);
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(map.this, profilepage.class);
                startActivity(intent);
            }
        });

        gobackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        QrcodeItem Item = new QrcodeItem();
        LatLng lisbon = new LatLng(38.44, 9.8);
        LatLng currentQRCode = new LatLng(Item.getLatitude(), Item.getLongitude());
        mMap.addMarker(new MarkerOptions()
                .position(currentQRCode)
                .title(Item.getStreetName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lisbon));
    }
}
