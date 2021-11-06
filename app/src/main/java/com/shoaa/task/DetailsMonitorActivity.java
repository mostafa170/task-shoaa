package com.shoaa.task;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;

import com.bumptech.glide.Glide;
import com.shoaa.task.databinding.ActivityDetailsMonitorBinding;

public class DetailsMonitorActivity extends AppCompatActivity {
    ActivityDetailsMonitorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(DetailsMonitorActivity.this,
                R.layout.activity_details_monitor);

        binding.tvNameShipmentTxt.setText(getIntent().getStringExtra("name_ower"));
        binding.tvDateShipmentTxt.setText(getIntent().getStringExtra("monitoring_date"));
        binding.idAddress.setText(getIntent().getStringExtra("address"));
        binding.tvNotesShipmentTxt.setText(getIntent().getStringExtra("notese"));
        binding.tvMonitorNameTxt.setText(getIntent().getStringExtra("monitor_name"));
        binding.tvMonitorPositionTxt.setText(getIntent().getStringExtra("monitor_position"));

        byte[] decodedString = Base64.decode(getIntent().getStringExtra("img1"), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        binding.image1.setImageBitmap(decodedByte);

        byte[] decodedString2 = Base64.decode(getIntent().getStringExtra("img2"), Base64.DEFAULT);
        Bitmap decodedByte2 = BitmapFactory.decodeByteArray(decodedString2, 0, decodedString2.length);
        binding.image2.setImageBitmap(decodedByte2);

        byte[] decodedString3 = Base64.decode(getIntent().getStringExtra("img3"), Base64.DEFAULT);
        Bitmap decodedByte3 = BitmapFactory.decodeByteArray(decodedString3, 0, decodedString3.length);
        binding.image3.setImageBitmap(decodedByte3);
    }
}