package br.com.fiap.exemplodefile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText edtTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = findViewById(R.id.edtTexto);
    }

    public void salvar(View view) {
        try {
            FileOutputStream fos = openFileOutput("banco.txt", MODE_PRIVATE);
            String texto = edtTexto.getText().toString();
            fos.write(texto.getBytes());
            fos.close();
            edtTexto.setText("");
        }catch (FileNotFoundException fnfe) {
            Toast.makeText(this, "Arquivo não encontrado", Toast.LENGTH_SHORT).show();
            fnfe.printStackTrace();
        }catch (IOException ioe) {
            Toast.makeText(this, "Não foi possivel escrever no arquivo", Toast.LENGTH_SHORT).show();
            ioe.printStackTrace();
        }
    }

    public void recuperar(View view) {
        try {
            FileInputStream fis = openFileInput("banco.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String texto = br.readLine();
            edtTexto.setText(texto);
            br.close();
            fis.close();
        }catch (FileNotFoundException fnfe) {
            Toast.makeText(this, "Arquivo não encontrado", Toast.LENGTH_SHORT).show();
            fnfe.printStackTrace();
        }catch (IOException e) {
            Toast.makeText(this, "Não foi possivel escrever no arquivo", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}