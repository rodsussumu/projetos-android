package br.com.fiap.exemplodelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    CheckBox chkManterConectado;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        boolean conectado = sp.getBoolean("manter conectado", false);

        if(conectado) {
            abrirAreaRestrita();
            return;
        }

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkManterConectado = findViewById(R.id.chkManterConectado);
    }

    public void login(View view) {
        Intent it = new Intent(this, AreaRestritaActivity.class);
        startActivity(it);
        finish();

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString()
        if(username.equals("fiap") && password.equals("123456")) {
            if(chkManterConectado.isChecked()) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.putBoolean("chkManterConectado", true);
                editor.commit();

            }
            abrirAreaRestrita();
            return;
        }
    }
}