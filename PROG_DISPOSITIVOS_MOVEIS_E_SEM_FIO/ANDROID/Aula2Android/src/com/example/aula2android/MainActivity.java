package com.example.aula2android;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int REQCODE = 1;
	private static final int REQCODEDOIS = 2;
	TextView textoRetorno;
	
	public void chamarActivity(View view){
		Intent intent = new Intent(this, StringActivity.class);
		startActivityForResult(intent, REQCODEDOIS);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textoRetorno = (TextView) findViewById(R.id.textView1);
		Intent intent = new Intent(this, VersionActivity.class);
		startActivityForResult(intent, REQCODE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (requestCode == REQCODE){
			if (resultCode == RESULT_OK){
				Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
			}
		} else {
			if (requestCode == REQCODEDOIS){
				if (resultCode == RESULT_OK){
					textoRetorno.setText(String.valueOf(data.getStringExtra("result")));
				}
			}
		}
	}
}
