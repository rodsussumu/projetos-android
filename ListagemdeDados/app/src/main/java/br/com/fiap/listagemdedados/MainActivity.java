package br.com.fiap.listagemdedados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstContatos;
    List<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contatos = GeradorContatos.getContatos();

        lstContatos = findViewById(R.id.lstContatos);

        ContatoAdapter adapter = new ContatoAdapter(this, contatos);
        lstContatos.setAdapter(adapter);


    }
}
