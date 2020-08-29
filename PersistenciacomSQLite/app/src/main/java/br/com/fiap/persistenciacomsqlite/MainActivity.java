package br.com.fiap.persistenciacomsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MeuDB meuDB;

    ListView lstContatos;

    List<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuDB = new MeuDB(this);
        lstContatos = findViewById(R.id.lstContatos);
        lstContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Contato contato = MainActivity.this.contatos.get(position);
                Intent it = new Intent(MainActivity.this, FormActivity.class);
                it.putExtra("contato", contato);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.contatos = meuDB.todos();
        ArrayAdapter<Contato> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lstContatos.setAdapter(adapter);
    }

    public void novoContato(View view) {
        Intent it = new Intent(this, FormActivity.class);
        startActivity(it);
    }
}