package br.com.fiap.exemplodenotificacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_PROMOCOES_ID = "promocoes";
    NotificationManager notificationManager;
    NotificationChannel notificationChannel;
    EditText edtMensagem;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationChannel =  new NotificationChannel
                (CHANNEL_PROMOCOES_ID , "Promoções", NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.setDescription("Notificações com descontos exclusivos");
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
        notificationChannel.enableVibration(true);

        notificationManager.createNotificationChannel(notificationChannel);

        edtMensagem = findViewById(R.id.edtMensagem);
    }

    public void notificacaoPersonalizada(View view) {
        String msg = edtMensagem.getText().toString();
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_PROMOCOES_ID);
        notification.setContentTitle("Compre agora");
        notification.setChannelId(CHANNEL_PROMOCOES_ID);
        notification.setContentText(msg);
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setAutoCancel(true);
        notification.setContentIntent(PendingIntent.getActivity
                (this,0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));
        notificationManager.notify(++contador, notification.build());
    }

    public void notificacaoFixa(View view) {
        String msg = String.format("O numero de notificações emitidas é: %d", ++contador);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_PROMOCOES_ID);
        notification.setContentTitle("Compre agora");
        notification.setChannelId(CHANNEL_PROMOCOES_ID);
        notification.setContentText(msg);
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notificationManager.notify(0, notification.build());
    }
}
