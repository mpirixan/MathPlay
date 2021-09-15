package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botaoTL2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            botaoTL2 = findViewById(R.id.tela2);

            botaoTL2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent tela2 = new Intent(MainActivity.this, tela2.class);
                    startActivity(tela2);
                }
            });

    }

    public void Continuar (View view){

        EditText textoNome = findViewById(R.id.user);

        TextView textoresultado = findViewById(R.id.resultado);

        String nome = textoNome.getText().toString();
        textoresultado.setText("Bem Vindx "+ nome);

    }
}