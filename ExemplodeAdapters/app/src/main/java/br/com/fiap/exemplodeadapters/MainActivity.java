package br.com.fiap.exemplodeadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spnPaises;

    List<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnPaises = findViewById(R.id.spnPaises);

        paises = DB.getPaises();

        PaisAdapter adapter = new PaisAdapter(this, paises);

        spnPaises.setAdapter(adapter);
    }

    public void salvar(View view) {
        // int posicao = spnPaises.getSelectedItemPosition();
        //Pais pais = paises.get(posicao)
        Pais pais = (Pais) spnPaises.getSelectedItem();
        Toast.makeText(this, pais.getNome(), Toast.LENGTH_SHORT).show();
    }
}
