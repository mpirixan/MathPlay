package com.example.app_mathplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class  tela3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

    }

    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    int num4 = 0;
    int num5 = 0;

    int org = 0; /* aqui vai ser sorteado o modo como a construção vai ser construida*/
    int pontosnv2 = 0;

    int rodadas = 1;
    public void setRodadaNum2 (View view) {

        if (rodadas <= 6){

            TextView numRodada = findViewById(R.id.numRodada2);
            numRodada.setText("Rodada "+ rodadas);
            rodadas = rodadas + 1;

            num1 = new Random().nextInt(10);
            num2 = new Random().nextInt(10);
            num3 = new Random().nextInt(10);
            num4 = new Random().nextInt(10);
            num5 = new Random().nextInt(10);
            org = new Random().nextInt(6);

            GerarRodada(num1, num2, num3, num4, num5, org);

        }
    };

    public void GerarRodada(int num1, int num2, int num3, int num4, int num5, int org){
        if (org == 0) {
            TextView textoresultado = findViewById(R.id.setQuestao3);
            textoresultado.setText("(("+num1+"+"+num2+")"+"x"+num5+")");
        }

        if (org == 1) {
            TextView textoresultado = findViewById(R.id.setQuestao3);
            textoresultado.setText("("+num1+"x"+num2+")"+"-"+"("+num3+"+"+num4+")");
        }

        if (org == 2) {
            TextView textoresultado = findViewById(R.id.setQuestao3);
            textoresultado.setText("((("+num1+"+"+num2+")"+"*"+"("+num3+"+"+num4+"))");
        }

        if (org == 3) {
            TextView textoresultado = findViewById(R.id.setQuestao3);
            textoresultado.setText("(("+num1+"-"+num2+")"+"*"+num3+")");
        }

        if (org == 4) {
            TextView textoresultado = findViewById(R.id.setQuestao3);
            textoresultado.setText("((("+num1+"*"+num2+")"+"-"+num3+")"+"+"+"("+num4+"*"+num5+"))");
        }

        if (org == 5) {
            TextView textoresultado = findViewById(R.id.setQuestao3);
            textoresultado.setText("("+num1+"("+num3+"*"+num4+"))");
        }


        if (org == 6) {
            TextView textoresultado = findViewById(R.id.setQuestao3);
            textoresultado.setText("(("+num1+"+"+num2+"+(("+num3+"x"+num4+")x"+num5+")");
        }

    }

    public boolean correcao2 (int num1, int num2, int num3, int num4, int num5, int org) {

        boolean aux = false;

        if (org == 0) {
            EditText resultado = findViewById(R.id.reposta2);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = ((num1+num2)*num5);

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (org == 1) {
            EditText resultado = findViewById(R.id.reposta2);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = (num1*num2)-(num3+num4);

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (org == 2) {
            EditText resultado = findViewById(R.id.reposta2);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = (((num1+num2)*(num3+num4)));

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (org == 3) {
            EditText resultado = findViewById(R.id.reposta2);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = ((num1-num2)*num3);

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (org == 4) {
            EditText resultado = findViewById(R.id.reposta2);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = (((num1*num2)-num3)+(num4*num5));

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (org == 5) {
            EditText resultado = findViewById(R.id.reposta2);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = (num1+(num4*num5));

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        if (org == 6) {
            EditText resultado = findViewById(R.id.reposta2);
            int transdResultado = Integer.parseInt(String.valueOf(resultado.getText()));

            int correcaoResult = ((num1+num2+(num3+num4))*num5);

            if (transdResultado == correcaoResult) {
                aux = true;
            }
        }

        return aux;
    }

    public void enviar2 (View view) {
        if(rodadas < 6){
            boolean contPontos2 = false;
            contPontos2 = correcao2 (num1, num2, num3, num4, num5, org);

            if (contPontos2 == true) {
                pontosnv2++;
                contPontos2 = false;
            }
            int auxRodada = rodadas - 1;
            TextView correcao2 = findViewById(R.id.correcao2);
            correcao2.setText("Pontos = "+pontosnv2);
            setRodadaNum2(view);
        }else{
            boolean contPontos2 = false;
            contPontos2 = correcao2 (num1, num2, num3, num4, num5, org);

            if (contPontos2 == true) {
                pontosnv2++;
                contPontos2 = false;
            }
            int auxRodada = rodadas - 1;
            TextView correcao2 = findViewById(R.id.correcao2);
            correcao2.setText("Pontos = "+pontosnv2);
            ProxTela4(view);
        }
    }


    public int dados (){
        Intent dadosTela2 = getIntent();
        Bundle dados = dadosTela2.getExtras();

        int aux = dados.getInt("PontosN1");

        return aux;
    }

    public String dadosNo(){
        Intent dadosMain = getIntent();
        Bundle dados = dadosMain.getExtras();

        String aux = dados.getString("nome");

        return aux;
    }

    public void ProxTela4(View view){
        int PontosNivel1 = dados();
        String nome = dadosNo();

        Intent tela4 = new Intent(getApplicationContext(), tela4.class);

        Bundle dados = new Bundle();

        dados.putString("nome", nome);
        dados.putInt("PontosN1", PontosNivel1);
        dados.putInt("PontosN2", pontosnv2);
        tela4.putExtras(dados);

        startActivity(tela4);
    }
}