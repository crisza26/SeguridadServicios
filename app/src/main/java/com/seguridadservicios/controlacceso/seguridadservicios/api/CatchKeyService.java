package com.seguridadservicios.controlacceso.seguridadservicios.api;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dianita on 24/04/2015.
 */
public class CatchKeyService {

        public String getJsonResult() {
            return jsonResult;
        }

        private String jsonResult;
        private String url = "http://sys.bugs3.com/sys/controller/TOTP.php";

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
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(params[0]);
                try {

                    List<NameValuePair> parametros = new ArrayList<NameValuePair>();
                   // parametros.add(new BasicNameValuePair("user", getUser()));
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

    public void ListDrawer() {

        try {
            JSONArray jsonResponse = new JSONArray(jsonResult);
            jsonResult=jsonResponse.toString();



        } catch (JSONException e) {
            error=e.getMessage();
        }

    }


}