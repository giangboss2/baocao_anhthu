package project.anhthu.travelinvietnam_app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import project.anhthu.travelinvietnam_app.R;

public class ActivityGoogleMap extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap; // Gán giá trị cho myMap

        LatLng location = new LatLng( 12.2308 ,109.1969);
        myMap.addMarker(new MarkerOptions().position(location).title("Vinpearl Nha Trang"));
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,12));
    }
}