package alfredorevollo.medicitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComenzar = findViewById(R.id.btnComenzar);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí usamos el Intent para viajar a la Actividad 2 (que crearemos en el próximo paso)
                Intent intencion = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intencion);
            }
        });
    }
}