package com.bruno.primeiraaula;

import com.bruno.primeira.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("teste", "Oncreate");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("teste", "OnStart");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("teste", "OnDestroy");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "Bem vindo de volta!", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void esconder(View view){
		//view.setVisibility(View.INVISIBLE);
		TextView texto = (TextView) findViewById(R.id.textView1);
		if (texto.getVisibility()==View.VISIBLE){
			texto.setVisibility(View.INVISIBLE);
		} else {
			texto.setVisibility(View.VISIBLE);
		}
	}
	
	public void mudarTela(View view){
		//Toast.makeText(this, "Método mudartela()!", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(this, SegundaActivity.class);
		startActivity(intent);
	}
}
