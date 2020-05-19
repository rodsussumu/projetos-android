package br.com.fiap.exemploderecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvContatos;
    List<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contatos = GeradorContato.getContatos();

        rvContatos = findViewById(R.id.rvContatos);
        rvContatos.setHasFixedSize(true);

        ContatosAdapter adapter = new ContatosAdapter(this, contatos);
        rvContatos.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvContatos.setLayoutManager(layoutManager);
    }
}
