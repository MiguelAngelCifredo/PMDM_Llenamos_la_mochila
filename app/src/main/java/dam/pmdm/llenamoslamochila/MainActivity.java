package dam.pmdm.llenamoslamochila;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chkContenido1, chkContenido2, chkContenido3, chkContenido4, chkContenido5, chkContenido6;
    TextView txtPeso;

    //Peso de los objetos
    Integer[] peso = {1, 5, 7, 10, 15, 17};

    final int MAX_PESO = 35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chkContenido1 = findViewById(R.id.chkContenido1);
        chkContenido2 = findViewById(R.id.chkContenido2);
        chkContenido3 = findViewById(R.id.chkContenido3);
        chkContenido4 = findViewById(R.id.chkContenido4);
        chkContenido5 = findViewById(R.id.chkContenido5);
        chkContenido6 = findViewById(R.id.chkContenido6);

        txtPeso = findViewById(R.id.txtPeso);

        chkContenido1.setOnClickListener(v -> calcularPeso());
        chkContenido2.setOnClickListener(v -> calcularPeso());
        chkContenido3.setOnClickListener(v -> calcularPeso());
        chkContenido4.setOnClickListener(v -> calcularPeso());
        chkContenido5.setOnClickListener(v -> calcularPeso());
        chkContenido6.setOnClickListener(v -> calcularPeso());

        findViewById(R.id.btnVaciar).setOnClickListener(v -> vaciarMochila());

    }

    @Override
    protected void onStart() {
        super.onStart();
        calcularPeso();
    }

    // Calcula el peso total de la mochila según los objetos seleccionados
    private void calcularPeso() {
        // Calcula el peso total
        int pesoTotal = 0;
        if (chkContenido1.isChecked()) pesoTotal += peso[0];
        if (chkContenido2.isChecked()) pesoTotal += peso[1];
        if (chkContenido3.isChecked()) pesoTotal += peso[2];
        if (chkContenido4.isChecked()) pesoTotal += peso[3];
        if (chkContenido5.isChecked()) pesoTotal += peso[4];
        if (chkContenido6.isChecked()) pesoTotal += peso[5];

        // Muestra el peso total
        txtPeso.setText("Peso " + String.valueOf(pesoTotal) + " Kg");

        // Cambia el color del texto según el peso total
        int color = 0;
        if (pesoTotal == 0)                        color = Color.GRAY;
        if (pesoTotal > 0 && pesoTotal < MAX_PESO) color = Color.GREEN;
        if (pesoTotal >= MAX_PESO)                 color = Color.RED;
        txtPeso.setTextColor(color);
    }

    // Vacia la mochila deseleccionando todos los objetos
    private void vaciarMochila() {
        chkContenido1.setChecked(false);
        chkContenido2.setChecked(false);
        chkContenido3.setChecked(false);
        chkContenido4.setChecked(false);
        chkContenido5.setChecked(false);
        chkContenido6.setChecked(false);

        calcularPeso();
    }
}