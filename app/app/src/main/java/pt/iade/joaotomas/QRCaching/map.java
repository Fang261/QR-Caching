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
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.models.QrcodeItem;

public class map extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;
    private Button gobackbutton;
    private ImageButton profilepic;
    private ArrayList<QrcodeItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapView = findViewById(R.id.mapView);

        gobackbutton = findViewById(R.id.goback_buttonmap);
        profilepic = findViewById(R.id.profilepic_imageButton);
        if (itemList == null) {
            itemList = new ArrayList<>();
        }

        gobackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(map.this, profilepage.class);
                intent.putExtra("itemList", itemList);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            itemList = (ArrayList<QrcodeItem>) intent.getSerializableExtra("itemList");
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(map.this, R.style.AlertDialogCustom);
            builder.setTitle("Failed to load Lists");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(map.this, R.style.AlertDialogCustom);
            builder.setTitle("Failed to load map");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (itemList != null && itemList.size() > 0) {
            LatLng lisbon = new LatLng(38.44, 9.8);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(lisbon));

            LatLng currentQRCode;
            for (QrcodeItem Item : itemList) {
                currentQRCode = new LatLng(Item.getLatitude(), Item.getLongitude());
                mMap.addMarker(new MarkerOptions()
                        .position(currentQRCode)
                        .title(Item.getStreetName()));
            }
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
