package com.example.chataula2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.LoggingMXBean;

public class MainActivity extends AppCompatActivity {

    public final static String KEY_INTENT = "CHAVE MENSAGEM";
    public static final String TAG_KEY_MESSAGE = "MESSAGE_KEY";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ed_mensagem = findViewById(R.id.ed_mensagem);
        Button button = findViewById(R.id.bt_enviar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                String texto = ed_mensagem.getText().toString();

                intent.putExtra(KEY_INTENT, texto);

//                startActivity(intent);
                int requestCode;
                startActivityForResult(intent, requestCode: 1);

            }
        });


        Log.i(LOG_TAG, msg:"onCreate");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String resposta = data.getStringExtra(MainActivity2.KEY_RESPOSTA);
                tvResposta.setText(resposta);
            }
        }
    }
}