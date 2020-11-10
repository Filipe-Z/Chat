package com.example.chataula2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {



    public final static String KEY_INTENT_MAIN2 = "MENSAGEM_MAIN2";
    public static final String KEY_RESPOSTA = "RESPOSTA"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText editText = findViewById(R.id.ed_mensagem2);
        TextView tvMessage = findViewById(R.id.tv_recebida2);
        Button button = findViewById(R.id.bt_enviar2);

        String mensagemRecebida = getIntent().getStringExtra(MainActivity.TAG_KEY_MESSAGE);
        tvMessage.setText(mensagem);

        button.setOnClickListener((View) ->  {
            Intent intent = new Intent();
            String value = editText.getText().ToString();
            intent.putExtra(KEY_RESPOSTA, value);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

//        TextView tvMessage = findViewById(R.id.tv_recebida2);
//        tvMessage.setText(mensagemRecebida);


    }
}