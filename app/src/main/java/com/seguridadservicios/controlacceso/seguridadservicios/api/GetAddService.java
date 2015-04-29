package com.seguridadservicios.controlacceso.seguridadservicios.api;

import android.os.AsyncTask;


import com.seguridadservicios.controlacceso.seguridadservicios.model.Casa;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuinkio on 4/23/2015.
 */
public class GetAddService {
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    int num1;
    int num2;

    private ArrayList<Casa> casas;

    public String getJsonResult() {
        return jsonResult;
    }

    private String jsonResult;
    private String url = "http://sys.bugs3.com/sys/controller/merompeslasbolas.php";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private String error="bien";




    // Async Task to access the web
    private class JsonReadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
casas=new ArrayList<Casa>();
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(params[0]);
            try {

                List<NameValuePair> parametros = new ArrayList<NameValuePair>();


               parametros.add(new BasicNameValuePair("num1", Integer.toString(getNum1())));
                parametros.add(new BasicNameValuePair("num2", Integer.toString(getNum2())));



                httppost.setEntity(new UrlEncodedFormEntity(parametros));

                HttpResponse response = httpclient.execute(httppost);
                jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
            } catch (ClientProtocolException e) {
                error=e.getMessage();
                e.printStackTrace();
            } catch (IOException e) {
                error=e.getMessage();
                e.printStackTrace();
            }
            return null;
        }

        private StringBuilder inputStreamToString(InputStream is) {
            String rLine = "";
            StringBuilder answer = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                while ((rLine = rd.readLine()) != null) {

                    answer.append(rLine);
                }
            } catch (IOException e) {
                error=e.getMessage();
                // e.printStackTrace();

            }
            return answer;
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }// end async task

    public void accessWebService() {


        JsonReadTask task = new JsonReadTask();
        // passes values for the urls string array
        try {
            task.execute(new String[]{url}).get();
           ListDrawer();

        }catch(Exception e){

        }
    }

    // build hash set for list view

    public void ListDrawer() {

        try {
            JSONArray jsonResponse = new JSONArray(jsonResult);

            for (int i = 0; i < jsonResponse.length(); i++) {
                Casa temp=new Casa();

                temp.setNombre(jsonResponse.getJSONObject(i).getString("tbl_casa_nombre"));

                temp.setUsuario(jsonResponse.getJSONObject(i).getString("tbl_casa_id_usuario"));
                temp.setId(jsonResponse.getJSONObject(i).getString("tbl_casa_id"));

                temp.setPassword(jsonResponse.getJSONObject(i).getString("tbl_password"));


casas.add(temp);


            }


        } catch (JSONException e) {
            error=e.getMessage();
        }

    }

}