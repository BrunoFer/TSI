package com.example.aula20012013;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView listView;
	
	public void criaListView(){
		listView = (ListView) findViewById(R.id.lista);
		String[] itens = new String[] { "Barbacena", "Reitoria",
				"Juiz de Fora", "São João" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, itens);
		listView.setAdapter(adapter);
		listView.setClickable(true);
		OnItemClickListener listener = new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(getApplicationContext(), "Item: "+parent.getAdapter().getItem(position), Toast.LENGTH_LONG).show();
			}
		};
		listView.setOnItemClickListener(listener);
	}
	
	public void adicionaUsuarios(){
		Database bd = new Database(this);
		Usuario usuario = new Usuario("Maria", "maria@gmail.com");
		bd.insert(usuario);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		criaListView();
		adicionaUsuarios();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

}
