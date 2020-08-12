package br.com.fiap.exemplodelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class AreaRestritaActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_restrita);

        sp = getSharedPreferences("login", MODE_PRIVATE);
    }

    public void sair(View view) {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        finish();
    }
}