package com.example.app_mathplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class tela2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

    }

    public boolean correcao(int num1, int num2, int op) {

        boolean aux = false;
        String erros = "";

        if (op == 0) {
            EditText resultado = findViewById(R.id.reposta);
            String frase = resultado.getText().toString();
            if(frase != erros) {
                int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

                int correcaoResult = num1 + num2;

                if (transdResultado == correcaoResult) {
                    aux = true;
                }
            }else{
                correcao(num1,num2,op);
            }

        }

        if (op == 1) {
            EditText resultado = findViewById(R.id.reposta);
            String frase = resultado.getText().toString();
            if(frase != erros) {
                int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

                int correcaoResult = num1 - num2;

                if (transdResultado == correcaoResult) {
                    aux = true;
                }
            }else{
                correcao(num1,num2,op);
            }
        }

        if (op == 2) {
            EditText resultado = findViewById(R.id.reposta);
            String frase = resultado.getText().toString();
            if(frase != erros) {
                int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

                int correcaoResult = num1 * num2;

                if (transdResultado == correcaoResult) {
                    aux = true;
                }
            }else {
                correcao(num1, num2, op);
            }
        }

        if (op == 3) {
            EditText resultado = findViewById(R.id.reposta);
            String frase = resultado.getText().toString();
            if(frase != erros) {
                int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

                int correcaoResult = num1 / num2;

                if (transdResultado == correcaoResult) {
                    aux = true;
                }
            }else {
                correcao(num1, num2, op);
            }
        }

        return aux;
    }

    public void GerarRodada(int num1, int num2, int op){
        if (op == 0) {
            TextView textoresultado = findViewById(R.id.setQuestao);
            textoresultado.setText(num1 + "+" + num2 + "= ?");
        }

        if (op == 1) {
            TextView textoresultado = findViewById(R.id.setQuestao);
            textoresultado.setText(num1 + "-" + num2 + "= ?");
        }

        if (op == 2) {
            TextView textoresultado = findViewById(R.id.setQuestao);
            textoresultado.setText(num1 + "*" + num2 + "= ?");
        }

        if (op == 3) {
            TextView textoresultado = findViewById(R.id.setQuestao);
            textoresultado.setText(num1 + "/" + num2 + "= ?");
        }
    }


    int num1 = 0;
    int num2 = 0;
    int op = 0;

    int pontos = 0;

    int rodadas = 1;
    public void setRodadaNum1 (View view) {
        if (rodadas <= 6){
                TextView numRodada = findViewById(R.id.numRodada);
                numRodada.setText("Rodada " + rodadas);
                rodadas = rodadas + 1;

                num1 = new Random().nextInt(10);
                num2 = new Random().nextInt(10);
                op = new Random().nextInt(3);

                GerarRodada(num1, num2, op);
            }
    };

    public void enviar (View view) {
            if(rodadas<6) {
                boolean contPontos = false;
                contPontos = correcao(num1, num2, op);

                if (contPontos == true) {
                    pontos++;
                    contPontos = false;
                }
                int auxRodada = rodadas - 1;
                TextView correcao = findViewById(R.id.correcao);
                correcao.setText("Pontos = " + pontos);
                setRodadaNum1(view);

            }else{
                boolean contPontos = false;
                contPontos = correcao(num1, num2, op);

                if (contPontos == true) {
                    pontos++;
                    contPontos = false;
                }
                int auxRodada = rodadas - 1;
                TextView correcao = findViewById(R.id.correcao);
                correcao.setText("Pontos = " + pontos);
                ProxTela(view);
            }


    }

    public String dadosN(){
        Intent dadosMain = getIntent();
        Bundle dados = dadosMain.getExtras();

        String aux = dados.getString("nome");

        return aux;
    }

    public void ProxTela(View view){
        String nome = dadosN();
        Intent tela3 = new Intent(getApplicationContext(), tela3.class);

        Bundle dados = new Bundle();

        dados.putInt("PontosN1", pontos);
        dados.putString("nome", nome);
        tela3.putExtras(dados);

        startActivity(tela3);
    }
}