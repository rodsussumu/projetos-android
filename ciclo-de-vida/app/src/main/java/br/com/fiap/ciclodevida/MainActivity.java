package br.com.fiap.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MeuLog", "Passou pelo onCreate:");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MeuLog", "Passou pelo onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MeuLog", "Passou pelo onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MeuLog", "Passou pelo onPause: ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MeuLog", "Passou pelo onStop: ");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MeuLog", "Passou pelo onRestart: ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MeuLog", "Passou pelo onDestroy: ");

    }
}
