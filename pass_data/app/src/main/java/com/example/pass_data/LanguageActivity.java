package com.example.pass_data;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        TextView textViewLanguage = findViewById(R.id.textViewLanguage);
        ImageView imageViewLanguage = findViewById(R.id.imageViewLanguage);

        String language = getIntent().getStringExtra("language");
        int imageResource = getIntent().getIntExtra("image", 0);

        textViewLanguage.setText("Language: " + language);
        imageViewLanguage.setImageResource(imageResource);
    }
}
