package br.com.fiap.activities_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ExibirDadosActivity extends AppCompatActivity {

    TextView txtSaudacao

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_dados);

        txtSaudacao = findViewById(R.id.txtSaudacao);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String nickname = extras.getString("nickname");
            String idade = extras.getString("idade");

            String msg = String.format("Olá %s (%s anos)", nickname, idade);
            txtSaudacao.setText(msg);
        }
    }
}
