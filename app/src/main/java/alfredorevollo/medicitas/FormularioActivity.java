package alfredorevollo.medicitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNombre;
    private RadioGroup rgEspecialidad;
    private Button btnAgendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // 1. Conectamos variables con los IDs del XML
        etNombre = findViewById(R.id.etNombrePaciente);
        rgEspecialidad = findViewById(R.id.rgEspecialidad);
        btnAgendar = findViewById(R.id.btnAgendar);

        // 2. Escuchamos el clic del botón
        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos();
            }
        });
    }

    private void enviarDatos() {
        String nombre = etNombre.getText().toString().trim();
        int idSeleccionado = rgEspecialidad.getCheckedRadioButtonId();

        // Validación como buen ingeniero: ¿Llenó los datos?
        if(nombre.isEmpty() || idSeleccionado == -1) {
            Toast.makeText(this, "Por favor, ingresa tu nombre y selecciona una especialidad", Toast.LENGTH_SHORT).show();
            return; // Detiene la ejecución para no avanzar con datos vacíos
        }

        // Extraemos el texto del RadioButton que el usuario seleccionó
        RadioButton rbSeleccionado = findViewById(idSeleccionado);
        String especialidad = rbSeleccionado.getText().toString();

        // 3. Preparamos el viaje a la Pantalla 3 (Aceptación)
        Intent intencion = new Intent(FormularioActivity.this, AceptacionActivity.class);

        // 4. ¡Aquí empacamos los datos en el Intent! (Sin base de datos)
        intencion.putExtra("CLAVE_NOMBRE", nombre);
        intencion.putExtra("CLAVE_ESPECIALIDAD", especialidad);

        // 5. Iniciamos el viaje
        startActivity(intencion);
    }
}