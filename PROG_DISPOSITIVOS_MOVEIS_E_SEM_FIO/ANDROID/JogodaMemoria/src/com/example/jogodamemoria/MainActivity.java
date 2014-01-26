package com.example.jogodamemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	List<Integer> valoresAleatorios = new ArrayList<Integer>();
	int posicaoAtual=0;
	int progresso = 17;
	int progressoTotal = 0;
	ProgressBar progressBar;
	TextView textoParabens;
	TextView textoMsgem;
	TextView textoProgress;
	
	public void gerarNumeros(){
		for (int i=1;i<=6;i++){
			valoresAleatorios.add(i);
		}
		Collections.shuffle(valoresAleatorios);
	}
	
	public void reiniciarJogo(View view){
		Collections.shuffle(valoresAleatorios);
		textoParabens.setVisibility(View.INVISIBLE);
		textoMsgem.setVisibility(View.INVISIBLE);
		progressBar.setVisibility(View.VISIBLE);
		textoProgress.setVisibility(View.VISIBLE);
		reiniciar();
	}
	
	public void reiniciar(){
		Button btn1 = (Button) findViewById(R.id.button2);
		Button btn2 = (Button) findViewById(R.id.button3);
		Button btn3 = (Button) findViewById(R.id.button4);
		Button btn4 = (Button) findViewById(R.id.button5);
		Button btn5 = (Button) findViewById(R.id.button6);
		Button btn6 = (Button) findViewById(R.id.button7);
		btn1.setVisibility(View.VISIBLE);
		btn2.setVisibility(View.VISIBLE);
		btn3.setVisibility(View.VISIBLE);
		btn4.setVisibility(View.VISIBLE);
		btn5.setVisibility(View.VISIBLE);
		btn6.setVisibility(View.VISIBLE);
		this.getWindow().getDecorView().setBackgroundColor(getResources().getColor(android.R.color.white));
		progressBar.setProgress(0);
		progressoTotal = 0;
		posicaoAtual=0;
	}
	
	public void verificar(View view){
		Button b = (Button) view;
		String botaoSelecionado = (String)b.getText();
		System.out.println(botaoSelecionado);
		int botao = Integer.parseInt(botaoSelecionado);
		if (valoresAleatorios.get(posicaoAtual)==botao){
			view.setVisibility(View.INVISIBLE);
			posicaoAtual++;
			progressoTotal += progresso;
			progressBar.setProgress(progressoTotal);
			ColorDrawable corBotao = (ColorDrawable) b.getBackground();
			this.getWindow().getDecorView().setBackgroundColor(corBotao.getColor());
			if (posicaoAtual>5){
				textoParabens.setVisibility(View.VISIBLE);
				textoMsgem.setVisibility(View.VISIBLE);
				progressBar.setVisibility(View.INVISIBLE);
				textoProgress.setVisibility(View.INVISIBLE);
			}
		} else {
			reiniciar();
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoParabens = (TextView) findViewById(R.id.textView2);
        textoParabens.setVisibility(View.INVISIBLE);
        textoMsgem = (TextView) findViewById(R.id.textView3);
        textoMsgem.setVisibility(View.INVISIBLE);
        textoProgress = (TextView) findViewById(R.id.textView1);
        this.getWindow().getDecorView().setBackgroundColor(getResources().getColor(android.R.color.white));
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        gerarNumeros();
        return true;
    }
    
}
