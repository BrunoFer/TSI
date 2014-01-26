package com.example.previsaotempo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ActivityPrevisao extends AsyncTask<Void, Void, Boolean> {

	private DefaultHttpClient httpClient = new DefaultHttpClient();
	private TextView temperatura;
	private TextView cidade;
	private ProgressBar termometro;
	private String tempCelsius;
	private String textCity;

	public ActivityPrevisao(TextView texto, ProgressBar termometro,
			TextView cidade) {
		this.temperatura = texto;
		this.termometro = termometro;
		this.cidade = cidade;
	}

	public String converteFahrenheitCelsius(String fahrenheit) {
		double tempFahrenheit = Double.parseDouble(fahrenheit);
		double tempCelsius = (tempFahrenheit - 32) / 1.8;
		return String.valueOf(tempCelsius);
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		// TODO Auto-generated method stub
		HttpGet request = new HttpGet(
				"http://www.previsaodotempo.org/api.php?city=Barbacena");
		try {
			HttpResponse response = httpClient.execute(request);
			HttpEntity httpEntity = response.getEntity();
			String json = EntityUtils.toString(httpEntity);

			Log.d("HTTP", json);
			JSONObject objetoJson = new JSONObject(json);
			JSONObject objetoData = objetoJson.getJSONObject("data");
			String textTemperature = objetoData.getString("temperature");
			textCity = objetoData.getString("location");
			tempCelsius = converteFahrenheitCelsius(textTemperature);
			Log.d("TEMP", textTemperature);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	protected void onPostExecute(Boolean retorno) {
		// TODO Auto-generated method stub
		int temp = (int)Double.parseDouble(tempCelsius);
		temperatura.setText(temp + " º ");
		termometro.setProgress(temp);
		cidade.setText(textCity);
		Log.d("retorno", retorno ? "OK" : "Erro");
	}

}
