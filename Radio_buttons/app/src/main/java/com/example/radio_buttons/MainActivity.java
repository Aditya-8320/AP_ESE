package com.example.radio_buttons;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupGender;
    private ImageView imageViewGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        imageViewGender = findViewById(R.id.imageViewGender);

        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                if (radioButton.getId() == R.id.radioButtonMale) {
                    // Set male image
                    imageViewGender.setImageResource(R.drawable.img_2);
                } else if (radioButton.getId() == R.id.radioButtonFemale) {
                    // Set female image
                    imageViewGender.setImageResource(R.drawable.img_1);
                }
            }
        });
    }
}
