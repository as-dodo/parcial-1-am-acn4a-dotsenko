package com.example.parcial_1_am_acn4a_dotsenko;

import android.os.Bundle;
import android.view.View;
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

        agregarRacha("🧘", "Yoga", 15);
        agregarRacha("🇬🇧", "Inglés", 42);
        agregarRacha("🇪🇸", "Español", 28);
        agregarRacha("🏃", "Correr", 10);
        agregarRacha("🚭", "No fumar", 60);

        btnNuevaRacha.setOnClickListener(v -> {
            agregarRacha("⭐", "Nueva racha", 0);
        });
    }

    private void agregarRacha(String icono, String nombre, int dias) {
        View card = getLayoutInflater().inflate(R.layout.item_racha, rachaContainer, false);

        TextView txtIcon = card.findViewById(R.id.txtRachaIcon);
        TextView txtName = card.findViewById(R.id.txtRachaName);
        TextView txtSubtitle = card.findViewById(R.id.txtRachaSubtitle);
        TextView txtDays = card.findViewById(R.id.txtRachaDays);

        txtIcon.setText(icono);
        txtName.setText(nombre);
        txtSubtitle.setText("Racha activa");
        txtDays.setText(dias + " días 🔥");

        rachaContainer.addView(card);
    }
}