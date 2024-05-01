package com.example.table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Define the data
        String[][] data = {
                {"Language", "Creator", "Reference"},
                {"Java", "James Gosling", "http://www.java.com"},
                {"Python", "Guido van Rossum", "http://www.python.org"},
                {"C++", "Bjarne Stroustrup", "http://www.cplusplus.com"}
        };

        // Populate the TableLayout with data
        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setPadding(16, 16, 16, 16);
                tableRow.addView(textView);
                textView.setGravity(Gravity.CENTER);
                textView.setBackgroundResource(R.drawable.cell_border);
            }
            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = row[2];
                    openUrlInBrowser(url);
                }
            });
            tableLayout.addView(tableRow);
        }
    }
    private void openUrlInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}