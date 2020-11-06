package pt.ipg.olamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostraTemperatura(View view) {
        EditText editTextTemperatura = findViewById(R.id.editTextTemperatura);
        String s = editTextTemperatura.getText().toString();

        RadioButton radioButtonCelcius = findViewById(R.id.radioButtonCelsius);
        RadioButton radioButtonFahrnhiet = findViewById(R.id.radioButtonFahrenheit);



        double temperatura; // declarar variavel
        try {
            temperatura = Double.parseDouble(s); // assign valor
        } catch (NumberFormatException e) {
            e.printStackTrace();
            editTextTemperatura.setError("Introduza uma temperatura válida!");
            editTextTemperatura.requestFocus();
            return;
        }

        if (radioButtonCelcius.isChecked()) {
            DadosApp.temperatura = new TemperaturaCelsius(temperatura);
        }else if (radioButtonFahrnhiet.isChecked()){
            DadosApp.temperatura = new TemperaturaFarenheit(temperatura);
        }else {
            radioButtonCelcius.setError("Indique as unidades da temperatura");
            radioButtonFahrnhiet.setError("Indique as unidades da temperatura");
            Toast.makeText(this, "Indique as unidades da temperatura", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(this, ConsultarTemperaturaActivity.class);//permite mudar de atividade(ecra)
        startActivity(intent);
    }
}