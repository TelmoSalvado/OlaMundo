package pt.ipg.olamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void mostraTemepratura(View view) {
        EditText editTextTemperatura = findViewById(R.id.editTextTemperatura);
        String s = editTextTemperatura.getText().toString();

        double temperatura; // declarar variavel
        try {
            temperatura = Double.parseDouble(s); // assign valor
        } catch (NumberFormatException e) {

            e.printStackTrace();
            return;
        }

        Intent intent = new Intent(this, ConsultarTemperaturaActivity.class);
        intent.putExtra("Temperatura", temperatura);
        startActivity(intent);
    }

    public void mostraTemperatura(View view) {
        Intent intent = new Intent(this, ConsultarTemperaturaActivity.class);//permite mudar de atividade(ecra)
        startActivity(intent);
    }
}