package pt.iade.joaotomas.QRCaching;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import pt.iade.joaotomas.QRCaching.R;
import pt.iade.joaotomas.QRCaching.models.QrcodeItem;

public class map extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        QrcodeItem Item = new QrcodeItem();
        LatLng lisbon = new LatLng(38.44, 9.8);
        LatLng currentQRCode = new LatLng(Item.getLatitude(),Item.getLongitude());
        mMap.addMarker(new MarkerOptions()
                .position(currentQRCode)
                .title(Item.getStreetName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lisbon));
    }
}
