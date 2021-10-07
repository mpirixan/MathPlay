package com.example.app_mathplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void bemvindx (View view){
        EditText DigiteNome = findViewById(R.id.getNome);

        TextView bemvindo = findViewById(R.id.bemVindo);
        String nome = DigiteNome.getText().toString();
        bemvindo.setText("E ai "+nome+"!\nVamos descobrir se você é um gênio da matemática?");

    }

    public void ProxTela2(View view){
        Intent tela2 = new Intent(getApplicationContext(), tela2.class);

        Bundle dados = new Bundle();

        EditText DigiteNome = findViewById(R.id.getNome);
        String nome = DigiteNome.getText().toString();

        dados.putString("nome", nome);
        tela2.putExtras(dados);

        startActivity(tela2);
    }
}