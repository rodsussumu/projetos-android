package br.com.fiap.downloadimagem_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imgDownload;
    EditText edtUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDownload = findViewById(R.id.imgDownload);
        edtUrl = findViewById(R.id.edtUrl);
    }

    public void download(View view) {
        String url = edtUrl.getText().toString();
        if(url.trim().length() > 0) {
            Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
            Picasso.get().load(url).into(imgDownload);
            return;
        }

        Toast.makeText(this, "URL inválida", Toast.LENGTH_SHORT).show();
    }
}
