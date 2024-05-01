package com.example.batterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView batteryPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        batteryPercentage = findViewById(R.id.batteryPercentage);
        // Register BroadcastReceiver to track battery state
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, filter);
    }
    private BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
            int batteryLevel = (level * 100) / scale;

            // Update progress bar
            progressBar.setProgress(batteryLevel);
            batteryPercentage.setText(getString(R.string.battery_percentage, batteryLevel));
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister receiver when activity is destroyed to prevent memory leaks
        unregisterReceiver(batteryReceiver);
    }
}