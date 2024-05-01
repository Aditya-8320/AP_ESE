package com.example.imagerotation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private Bitmap originalBitmap;
    private float currentRotationAngle = 0; // Variable to track the current rotation angle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        imageButton = findViewById(R.id.imageButton);
        originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img); // Replace "your_image" with your image resource

        // Set initial image
        imageButton.setImageBitmap(originalBitmap);

        // Set click listener on rotate button
        findViewById(R.id.rotateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateImage();
            }
        });
    }

    private void rotateImage() {
        // Increment the current rotation angle by 15 degrees (or any other desired angle)
        currentRotationAngle += 15; // Adjust the rotation angle as needed

        // Set rotation angle directly on the ImageButton
        imageButton.setRotation(currentRotationAngle);
    }


}
