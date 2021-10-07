package com.example.app_mathplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class tela4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4);
    }

    int pontosnv3 = 0;

    int rodadas = 1;
    int cont = 1;
    public void setRodadaNum3 (View view) {

        if (rodadas <= 6){
            TextView numRodada = findViewById(R.id.numRodada5);
            numRodada.setText("Rodada "+ rodadas);
            rodadas = rodadas + 1;

            GerarRodada(cont);
            cont = cont + 1;
        }
    }

    public void GerarRodada(int cont){
        if (cont == 0){
            TextView textoresultado = findViewById(R.id.setQuestao5);
            textoresultado.setText("18x - 43 = 65");
            /* resposta x = 6 */
        }

        if (cont == 1){
            TextView textoresultado = findViewById(R.id.setQuestao5);
            textoresultado.setText("7x+11 = 15+5x");
            /* resposta x = 2 */
        }

        if (cont == 2){
            TextView textoresultado = findViewById(R.id.setQuestao5);
            textoresultado.setText("60+13x = 3x");
            /* resposta x = – 6 */
        }
        if (cont == 3){
            TextView textoresultado = findViewById(R.id.setQuestao5);
            textoresultado.setText("3x+1 = x-3");
            /* resposta x = – 2 */
        }
        if (cont == 4){
            TextView textoresultado = findViewById(R.id.setQuestao5);
            textoresultado.setText("4*(x + 3)–x = 24+x");
            /* resposta x = 6 */
        }
        if (cont == 5){
            TextView textoresultado = findViewById(R.id.setQuestao5);
            textoresultado.setText("5*(9+x) = 20-3+6y");
            /* resposta x = 28 */
        }

        if (cont == 6){
            TextView textoresultado = findViewById(R.id.setQuestao5);
            textoresultado.setText("3x+4(1+x)+2 = 5x–x–6");
            /* resposta x = -4 */
        }
    }

    public boolean correcao4 (int cont) {

        boolean aux = false;

        if (cont == 0) {
            EditText resultado = findViewById(R.id.reposta5);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = 6;

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }
        if (cont == 1) {
            EditText resultado = findViewById(R.id.reposta5);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = 2;

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (cont == 2) {
            EditText resultado = findViewById(R.id.reposta5);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = -6;

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (cont == 3) {
            EditText resultado = findViewById(R.id.reposta5);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = -2;

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (cont == 4) {
            EditText resultado = findViewById(R.id.reposta5);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = 6;

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (cont == 5) {
            EditText resultado = findViewById(R.id.reposta5);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = 28;

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (cont == 6) {
            EditText resultado = findViewById(R.id.reposta5);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = -4;

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        return aux;
    }

    public void enviar4 (View view) {
        if (rodadas < 6) {
            boolean contPontos3 = false;
            contPontos3 = correcao4(1);

            if (contPontos3 == true) {
                pontosnv3 = pontosnv3 + 1;
                contPontos3 = false;

            }
            TextView correcao2 = findViewById(R.id.correcao5);
            correcao2.setText("Pontos = " + pontosnv3);
            int auxRodada = rodadas - 1;
            cont = cont + 1;
            setRodadaNum3(view);

        } else {
            if (rodadas == 6) {
                boolean contPontos3 = false;
                contPontos3 = correcao4(1);

                if (contPontos3 == true) {
                    pontosnv3 = pontosnv3 + 1;
                    contPontos3 = false;

                }
                TextView correcao2 = findViewById(R.id.correcao5);
                correcao2.setText("Pontos = " + pontosnv3);
                int auxRodada = rodadas - 1;
                cont = cont + 1;
                ProxTelaFinal(view);
            }
        }
    }

    public int dados1 (){
        Intent dadosTela2 = getIntent();
        Bundle dados = dadosTela2.getExtras();

        int aux = dados.getInt("PontosN1");

        return aux;
    }

    public int dados2(){
        Intent dadosTela2 = getIntent();
        Bundle dados = dadosTela2.getExtras();

        int aux = dados.getInt("PontosN1");

        return aux;
    }

    public String dadosNome(){
        Intent dadosMain = getIntent();
        Bundle dados = dadosMain.getExtras();

        String aux = dados.getString("nome");

        return aux;
    }

    public void ProxTelaFinal(View view){
        int PontosNivel1 = dados1();
        int PontosNivel2 = dados2();
        String nome = dadosNome();

        Intent telaFinal = new Intent(getApplicationContext(), ResultadoFinal.class);

        Bundle dados = new Bundle();

        dados.putString("nome", nome);
        dados.putInt("PontosN1", PontosNivel1);
        dados.putInt("PontosN2", PontosNivel1);
        dados.putInt("PontosN3", pontosnv3);
        telaFinal.putExtras(dados);

        startActivity(telaFinal);
    }
}