package br.com.fiap.exemplodesp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtTexto;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getPreferences(MODE_PRIVATE);

        edtTexto = findViewById(R.id.edtTexto);
    }

    public void salvar(View view) {
        String txt = edtTexto.getText().toString();
        SharedPreferences.Editor e = sp.edit();
        e.putString("txt", txt);
        e.commit();
    }

    public void recuperar(View view) {
        String txt = sp.getString("txt", "");
        edtTexto.setText(txt);
    }
}