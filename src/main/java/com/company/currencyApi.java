package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class currencyApi {
static double result;
    public static Double currentsApi(String currency, String base){
        JSONParser parser = new JSONParser();
        try{
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + base);

            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            if(httpsURLConnection.getResponseCode() ==200){
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line=br.readLine();
                JSONObject jsonObject = (JSONObject) parser.parse(line);
                String rates = jsonObject.get("rates").toString();
                JSONObject jsonObject1 = (JSONObject) parser.parse(rates);
                result = (Double) jsonObject1.get(currency);
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
