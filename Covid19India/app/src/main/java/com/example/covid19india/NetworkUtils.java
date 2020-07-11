package com.example.covid19india;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    //to do create country list
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    //Base Url of the covid data india
    private static final String BASE_URL = "https://api.covid19api.com/";
    // For Searching in a particular country
    //private static final String COUNTRY_BASE = "country";
    /*
    * @params: string
    * */
    // @params: str
    static String getCovidInfo(String countryName){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String dataJSONString = null;
        try{
            Uri builtURI = Uri.parse(BASE_URL+"dayone/country/"+countryName).buildUpon().build();
            URL requestURL = new URL(builtURI.toString());

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            dataJSONString = reader.readLine();
            /*"""try{
                JSONArray jsonArray = new JSONArray(dataJSONString);
            }catch (JSONException ex){
                ex.printStackTrace();
            }"""*/

        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataJSONString;
    }

}
