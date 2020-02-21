package br.com.fiap.trocadeimagens;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Integer[] imagens = new Integer[] {
            R.drawable.dado1,
            R.drawable.dado2,
            R.drawable.dado3,
            R.drawable.dado4,
            R.drawable.dado5,
            R.drawable.dado6
    };

    ImageView jogador1;
    ImageView jogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jogador1 = findViewById(R.id.jogador1);
        jogador2 = findViewById(R.id.jogador2);

    }


    public void jogarDados(View view) {
        Random r = new Random();
        Random r2 = new Random();
        int sorteado = r.nextInt( imagens.length );
        int sorteado2 = r.nextInt( imagens.length );
        jogador1.setImageResource(imagens[sorteado]);
        jogador2.setImageResource(imagens[sorteado2]);
        if(sorteado > sorteado2) {
            Toast.makeText(this, "Jogador 1 ganhou", Toast.LENGTH_SHORT).show();
        } else if (sorteado2 > sorteado) {
            Toast.makeText(this, "Jogador 2 ganhou", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
        }
    }
}
