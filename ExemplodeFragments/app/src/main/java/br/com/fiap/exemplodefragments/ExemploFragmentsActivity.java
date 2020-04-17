package br.com.fiap.exemplodefragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class ExemploFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_fragments);

        getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, new AmareloFragment()).addToBackStack(null).commit();
    }

    public void trocaFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, fragment).addToBackStack(null).commit();
    }

    public void trocarParaFragment01(View view) {
        trocaFragment(new VermelhoFragment());
    }

    public void trocarParaFragment02(View view) {
        trocaFragment(new VerdeFragment());
    }

    public void trocarParaFragment03(View view) {
        trocaFragment(new AmareloFragment());
    }
}
