package com.example.previsaotempo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView temperatura = (TextView)findViewById(R.id.textView1);
		TextView cidade = (TextView)findViewById(R.id.textView3);
		ProgressBar termometro = (ProgressBar)findViewById(R.id.progressBar1);
		ActivityPrevisao task = new ActivityPrevisao(temperatura,termometro,cidade);
		task.execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
