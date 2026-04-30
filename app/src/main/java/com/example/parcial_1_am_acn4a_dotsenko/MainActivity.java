package com.example.parcial_1_am_acn4a_dotsenko;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rachaContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rachaContainer = findViewById(R.id.rachaContainer);
        Button btnNuevaRacha = findViewById(R.id.btnNuevaRacha);

        agregarRacha("Yoga", 15);
        agregarRacha("Inglés", 42);
        agregarRacha("Español", 28);

        btnNuevaRacha.setOnClickListener(v -> {
            agregarRacha("Nueva racha", 1);
        });
    }

    private void agregarRacha(String nombre, int dias) {
        TextView textView = new TextView(this);
        textView.setText(nombre + " - " + dias + " días 🔥");
        textView.setTextSize(18);
        textView.setPadding(0, 16, 0, 16);

        rachaContainer.addView(textView);
    }
}