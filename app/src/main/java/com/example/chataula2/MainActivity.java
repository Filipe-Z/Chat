package com.example.chataula2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.LoggingMXBean;

public class MainActivity extends AppCompatActivity {

    public final static String KEY_INTENT = "CHAVE MENSAGEM";
    public static final String TAG_KEY_MESSAGE = "MESSAGE_KEY";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String KEY_MAINACTIVITY = "KEY_MAINACTIVITY";

    private SharedPreferences sharedPreferences;
    private String valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("TAG_PREFERENCES", Context.MODE_PRIVATE);

        final EditText ed_mensagem = findViewById(R.id.ed_mensagem);
        TextView textView = findViewById(R.id.tv_recebida);
        TextView textView2 = findViewById(R.id.tv_recebida2);
        Button button = findViewById(R.id.bt_enviar);

        button.setOnClickListener((View) -> {
            String texto = ed_mensagem.getText().toString();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra(TAG_KEY_MESSAGE, texto);
            if (!ed_mensagem.isEmpty()) {
                ed_mensagem.setText(ed_mensagem);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_MAINACTIVITY, ed_mensagem);
                editor.apply();
            }



//                startActivity(intent);
 //               int requestCode; --> não precisa digitar, é só colocar o valor
//                startActivityForResult(intent, 1);
            startActivity(Intent);

            }
        });
// não precisa digitar msg, é só digitar o texto entre aspas.
        Log.i(LOG_TAG,"onCreate");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String resposta = data.getStringExtra(MainActivity2.KEY_RESPOSTA);
                tv_resposta.setText(resposta);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG,"onStart");
        valor = sharedPreferences.getString(MainActivity.KEY_MAINACTIVITY,"Não tem nada no banco");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG,"onResume");
        tvResposta.setText(valor);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG,"onDestroy");
    }
}

