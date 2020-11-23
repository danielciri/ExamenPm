package com.danielcirilo.examenpm;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Parser {

    private ArrayList <Star> stars;
    private InputStream isStar;

    public Parser(Context c) {
        isStar = c.getResources().openRawResource(R.raw.stars);

    }


    public boolean parse(){
        boolean parsed = false;
        String json = null;
        stars = null;

        try {
            int size = isStar.available();
            byte[] buffer = new byte[size];
            isStar.read(buffer);
            isStar.close();
            json = new String(buffer,"UTF-8");

            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            stars = new ArrayList<>();

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                int hip = jsonObject.getInt("hip");
                String bf = jsonObject.getString("bf");
                String proper = jsonObject.getString("proper");
                double re = jsonObject.getDouble("ra");
                double dec = jsonObject.getDouble("dec");
                double dist = jsonObject.getDouble("dist");
                double mag = jsonObject.getDouble("mag");
                String spect = jsonObject.getString("spect");

                stars.add(new Star(id,hip,bf,proper,re,dec,dist,mag,spect));
            }
            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public ArrayList<Star> getStars() {
        Collections.sort(stars);
        return stars;
    }
}
