package br.com.fiap.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNumero1;
    EditText edtNumero2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumero1 = findViewById(R.id.edtNumero1);
        edtNumero2 = findViewById(R.id.edtNumero2);
    }

    public void somar(View view) {
        try {
            String strNum1 = edtNumero1.getText().toString();
            String strNum2 = edtNumero2.getText().toString();

            Double num1 = Double.parseDouble(strNum1);
            Double num2 = Double.parseDouble(strNum2);

            Double soma = num1 + num2;

            Toast.makeText(this, "A soma é: " + soma, Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Toast.makeText(this, "Verifique os dados informados", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void subtrair(View view) {
        try {
            String strNum1 = edtNumero1.getText().toString();
            String strNum2 = edtNumero2.getText().toString();

            Double num1 = Double.parseDouble(strNum1);
            Double num2 = Double.parseDouble(strNum2);

            Double subtrair = num1 - num2;

            Toast.makeText(this, "A subtração é: " + subtrair, Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Toast.makeText(this, "Verifique os dados informados", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void multiplicar(View view) {
        try {
            String strNum1 = edtNumero1.getText().toString();
            String strNum2 = edtNumero2.getText().toString();

            Double num1 = Double.parseDouble(strNum1);
            Double num2 = Double.parseDouble(strNum2);

            Double multiplicar = num1 * num2;

            Toast.makeText(this, "A multiplicação é: " + multiplicar, Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Toast.makeText(this, "Verifique os dados informados", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void dividir(View view) {
        try {
            String strNum1 = edtNumero1.getText().toString();
            String strNum2 = edtNumero2.getText().toString();

            Double num1 = Double.parseDouble(strNum1);
            Double num2 = Double.parseDouble(strNum2);

            Double dividir = num1 / num2;

            Toast.makeText(this, "A divisão é: " + dividir, Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Toast.makeText(this, "Verifique os dados informados", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
