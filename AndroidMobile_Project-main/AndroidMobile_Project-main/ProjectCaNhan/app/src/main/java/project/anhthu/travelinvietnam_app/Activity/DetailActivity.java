package project.anhthu.travelinvietnam_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import project.anhthu.travelinvietnam_app.Domain.PopularDomain;
import project.anhthu.travelinvietnam_app.R;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTxt, locationTxt, sunTxt, temperatureTxt, wifiTxt, descriptionTxt, scoreTxt;
    private PopularDomain items;
    private ImageView picImg, back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();
    }

    private void setVariable(){
        items = (PopularDomain) getIntent().getSerializableExtra("object");
        titleTxt.setText(items.getTitle());
        locationTxt.setText(items.getLocation());
        sunTxt.setText(items.getSun());
        temperatureTxt.setText(items.getTemperature() + "C");
        descriptionTxt.setText(items.getDescription());
        scoreTxt.setText("" + (int)items.getScore());

        if(items.isWifi()){
            wifiTxt.setText("Wifi");
        } else {
            wifiTxt.setText("No-Wifi");
        }



        int drawableResId = getResources().getIdentifier(items.getPic(), "drawable", getPackageName());
        Glide.with(this).load(drawableResId).into(picImg);
        back_arrow.setOnClickListener(v -> finish());

    }

    private void initView(){
        titleTxt = findViewById(R.id.titleTxt);
        locationTxt = findViewById(R.id.locationTxt);
        sunTxt = findViewById(R.id.sunTxt);
        temperatureTxt = findViewById(R.id.temperatureTxt);
        wifiTxt = findViewById(R.id.wifiTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        back_arrow = findViewById(R.id.back_arrow);
        picImg = findViewById(R.id.picImg);
        Button btnPlayVideo=findViewById(R.id.button);


        btnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, VideoPlayerActivity.class);
                intent.putExtra("VIDEO_URL", "https://firebasestorage.googleapis.com/v0/b/webphim-8a470.appspot.com/o/CH%C3%9AA%20T%E1%BB%82%20C%E1%BB%A6A%20NH%E1%BB%AENG%20CHI%E1%BA%BEC%20NH%E1%BA%AAN_%20S%E1%BB%B0%20TR%E1%BB%9E%20V%E1%BB%80%20C%E1%BB%A6A%20NH%C3%80%20VUA%20-%20Trailer%20ch%C3%ADnh%20th%E1%BB%A9c.mp4?alt=media&token=e78aaa65-5727-4cd3-b991-409f04b00673"); // Đường link của video
                startActivity(intent);
            }
        });


        locationTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ActivityGoogleMap.class);

                startActivity(intent);
            }
        });

    }
}