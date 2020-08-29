package br.com.fiap.persistenciacomsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class FormActivity extends AppCompatActivity {

    MeuDB meuDB;

    EditText edtNome;
    EditText edtEmail;
    EditText edtTelefone;

    Button btnExcluir;

    Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        meuDB = new MeuDB(this);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);

        btnExcluir = findViewById(R.id.btnExcluir);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            this.contato = (Contato) extras.get("contato");

            edtNome.setText(contato.getNome());
            edtEmail.setText(contato.getEmail());
            edtTelefone.setText(contato.getTelefone());

            btnExcluir.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Contato> contatos = meuDB.todos();
        for(Contato contato : contatos) {
            Log.d("Contato", contato.getNome());
        }
    }

    public void salvar(View view) {
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String telefone = edtTelefone.getText().toString();
        if(nome.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
            return;
        }

        if( this.contato == null) {
            Contato contato = new Contato(nome, email, telefone);
            meuDB.inserir(contato);
        } else {
            this.contato.setNome(nome);
            this.contato.setEmail(email);
            this.contato.setTelefone(telefone);
            meuDB.atualizar(this.contato);
        }
        finish();

    }

    public void excluir(View view) {
        if(this.contato !== null) {
            int id = this.contato.getId();
            meuDB.excluir(id);
        }
    }
}