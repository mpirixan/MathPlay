package com.example.app_mathplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final);
    }

    public void dados (View view){
        Intent dadosNiveis = getIntent();
        Bundle dados = dadosNiveis.getExtras();

        int pontos2 = dados.getInt("PontosN2");
        int pontos1 = dados.getInt("PontosN1");
        int pontos3 = dados.getInt("PontosN3");
        String nome = dados.getString("nome");

        int total = pontos1+pontos2+pontos3;

        if (total<11){
            TextView ponto = findViewById(R.id.teste);
            ponto.setText("iiiiih, " + nome + " você precisa parar de faltar as aulas de matemática hein! \n\nTalvez algumas horas de aulas de matemática no youtube te ajude hehe\n\n Sua pontuação total foi de " + total+ " pontos");
        }
        if(total>11 && total<22){
            TextView ponto = findViewById(R.id.teste);
            ponto.setText(nome + ", você definitivamente leva jeito para matemática! Leonhard Euler que se cuide!\n\n Sua pontuação Total foi de "+total);
        }
        if (total>21){
            TextView ponto = findViewById(R.id.teste);
            ponto.setText("Parabéns, "+nome+"você é um gênio do século XXI (desde que você não tenha usado a calculadora hein)!\n\n Sua pontuação total foi de "+total);
        }

    }

}