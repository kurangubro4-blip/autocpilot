package com.example.hello;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView counter = findViewById(R.id.counter);
        Button tap = findViewById(R.id.tap);
        tap.setOnClickListener(v -> {
            count++;
            counter.setText(getString(R.string.count_zero).replace("0", String.valueOf(count)));
        });
    }
}
