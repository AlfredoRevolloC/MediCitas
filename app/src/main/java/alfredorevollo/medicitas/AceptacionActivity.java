package alfredorevollo.medicitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AceptacionActivity extends AppCompatActivity {

    private TextView tvResumen;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptacion);

        tvResumen = findViewById(R.id.tvResumenCita);
        btnSalir = findViewById(R.id.btnSalir);

        // 1. Recibir el Intent y abrir el paquete de datos
        Intent intencionRecibida = getIntent();
        String nombrePaciente = intencionRecibida.getStringExtra("CLAVE_NOMBRE");
        String especialidadSeleccionada = intencionRecibida.getStringExtra("CLAVE_ESPECIALIDAD");

        // 2. Construir el mensaje final y mostrarlo en pantalla
        String mensajeFinal = "Hola " + nombrePaciente + ".\n\n" +
                "Tu solicitud para la especialidad de " + especialidadSeleccionada +
                " ha sido registrada correctamente en nuestro sistema.";
        tvResumen.setText(mensajeFinal);

        // 3. Evento para el botón de Salir (Requisito de la guía)
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finishAffinity() cierra la actividad actual y todas las actividades padre
                // Es la mejor práctica para "Detener y salir" en Android moderno.
                finishAffinity();
            }
        });
    }
}