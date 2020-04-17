package br.com.fiap.actionbar_menu_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mniSobre:
                 Toast.makeText(this, "Desenvolvido por Rodrigo", Toast.LENGTH_SHORT).show();
                 break;

            case R.id.mniSair:
                 finish();
                 break;

            case R.id.mniExemploSemToolbar:
                Intent it = new Intent(this, SemToolbarActivity.class);
                startActivity(it);
                break;
            case R.id.mniToolbarPersonalizada:
                Intent it2 = new Intent(this, ToolbarActivity.class);
                startActivity(it2);
                break;
            default:
                 Toast.makeText(this, "Opçao Invalida", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
