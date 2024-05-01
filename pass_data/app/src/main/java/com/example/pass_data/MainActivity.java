package com.example.pass_data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLanguageActivity(View view) {
        Intent intent = new Intent(this, LanguageActivity.class);
        String language = view.getTag().toString();

        // Get the resource ID of the image associated with the language
        int imageResource = getResources().getIdentifier("img_" + language.toLowerCase(), "drawable", getPackageName());

        // Pass the language and image resource ID to the LanguageActivity
        intent.putExtra("language", language);
        intent.putExtra("image", imageResource);
        startActivity(intent);
    }


}
