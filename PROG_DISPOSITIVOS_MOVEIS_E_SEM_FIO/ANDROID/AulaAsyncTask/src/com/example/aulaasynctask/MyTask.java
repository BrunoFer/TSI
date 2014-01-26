package com.example.aulaasynctask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class MyTask extends AsyncTask<Void, Void, Boolean>{
	
	DefaultHttpClient httpClient = new DefaultHttpClient();
	
	@Override
	protected Boolean doInBackground(Void... params) {
		// TODO Auto-generated method stub
		HttpGet request = new HttpGet("http://www.previsaodotempo.org/api.php?city=Barbacena");
		try {
			HttpResponse response = httpClient.execute(request);
			HttpEntity httpEntity = response.getEntity();
			String json = EntityUtils.toString(httpEntity);
			
			Log.d("HTTP",json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	protected void onPostExecute(Boolean retorno) {
		// TODO Auto-generated method stub
		Log.d("retorno",retorno ? "OK": "Erro");
	}
}
