package br.com.fiap.componentes02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdgSabores;
    CheckBox chkBordaRecheada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgSabores = findViewById(R.id.rdgSabores);
        chkBordaRecheada = findViewById(R.id.chkBordaRecheada);
    }

    public void realizarPedido(View view) {
        int selecionado = rdgSabores.getCheckedRadioButtonId();
        RadioButton rdbSelecionado = findViewById(selecionado);
        String bordaRecheada = chkBordaRecheada.isChecked() ? "Sim" : "Não";
        String msg = String.format("O sabor selecionado foi %s e borda: %s", rdbSelecionado.getText(), bordaRecheada);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
