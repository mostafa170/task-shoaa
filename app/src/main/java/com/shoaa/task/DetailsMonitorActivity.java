package com.shoaa.task;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shoaa.task.databinding.ActivityDetailsMonitorBinding;

import java.io.File;
import java.io.FileOutputStream;

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

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image1 = getIntent().getStringExtra("img1");
                imageEl3adadDialog(image1);
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image2 = getIntent().getStringExtra("img2");
                imageEl3adadDialog(image2);
            }
        });

        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image3 = getIntent().getStringExtra("img3");
                imageEl3adadDialog(image3);
            }
        });
    }

    public void imageEl3adadDialog(String images) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_images);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        final Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        Button shareBtn = dialog.findViewById(R.id.shareBtn);
        Button savaBtn = dialog.findViewById(R.id.saveBtn);
        ImageView imageEl3adad = dialog.findViewById(R.id.image_el3dad);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = imageEl3adad.getDrawable();
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                try {
                    File file = new File(getApplicationContext().getExternalCacheDir(), File.separator + "image that you wants to share");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID + ".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/jpg");

                    startActivity(Intent.createChooser(intent, "Share image via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        ActivityCompat.requestPermissions(DetailsMonitorActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        ActivityCompat.requestPermissions(DetailsMonitorActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        savaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToGallery(imageEl3adad);
            }
        });
        byte[] decodedString = Base64.decode(images, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        imageEl3adad.setImageBitmap(decodedByte);
        dialog.show();
    }

    private void saveToGallery(ImageView imageEl3adad){
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageEl3adad.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        FileOutputStream outputStream = null;
        File file = Environment.getExternalStorageDirectory();
        File dir = new File(file.getAbsolutePath() + "/MyPics");
        dir.mkdirs();

        String filename = String.format("%d.png",System.currentTimeMillis());
        File outFile = new File(dir,filename);
        try{
            outputStream = new FileOutputStream(outFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        try{
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}