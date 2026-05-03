package com.example.parcial_1_am_acn4a_dotsenko;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rachaContainer;
    private ArrayList<Racha> rachas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtToday = findViewById(R.id.txtToday);

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("d 'de' MMMM", java.util.Locale.getDefault());

        String fecha = sdf.format(new java.util.Date());

        txtToday.setText(getString(R.string.today_format, fecha));

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
        rachas.add(new Racha(icono, nombre, dias));

        Collections.sort(rachas, new Comparator<Racha>() {
            @Override
            public int compare(Racha racha1, Racha racha2) {
                return racha2.dias - racha1.dias;
            }
        });

        mostrarRachas();
    }

    private void mostrarRachas() {
        rachaContainer.removeAllViews();

        for (Racha racha : rachas) {
            View card = getLayoutInflater().inflate(R.layout.item_racha, rachaContainer, false);

            TextView txtIcon = card.findViewById(R.id.txtRachaIcon);
            TextView txtName = card.findViewById(R.id.txtRachaName);
            TextView txtSubtitle = card.findViewById(R.id.txtRachaSubtitle);
            TextView txtDays = card.findViewById(R.id.txtRachaDays);

            txtIcon.setText(racha.icono);
            txtName.setText(racha.nombre);
            txtSubtitle.setText("Racha activa");
            txtDays.setText(racha.dias + " días 🔥");

            rachaContainer.addView(card);
        }
    }

    private static class Racha {
        String icono;
        String nombre;
        int dias;

        Racha(String icono, String nombre, int dias) {
            this.icono = icono;
            this.nombre = nombre;
            this.dias = dias;
        }
    }
}