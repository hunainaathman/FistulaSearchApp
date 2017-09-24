package com.example.hunaina.fistulasearchapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Hunaina on 6/25/2017.
 */
public class ParseJSON {
    public static String[] ids;
    public static String[] firstnames;
    public static String[] secondnames;
    public static String[] lastnames;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_FIRSTNAME = "firstname";
    public static final String KEY_SECONDNAME = "secondname";
    public static final String KEY_LASTNAME = "lastname";


    private JSONArray diagnosedpatients = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void ParseJSON(){
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject(json);
            diagnosedpatients = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[diagnosedpatients.length()];
            firstnames = new String[diagnosedpatients.length()];
            secondnames = new String[diagnosedpatients.length()];
            lastnames = new String[diagnosedpatients.length()];

            for (int i = 0; i < diagnosedpatients.length(); i++){
                JSONObject jo = diagnosedpatients.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                firstnames[i] = jo.getString(KEY_FIRSTNAME);
                secondnames[i] = jo.getString(KEY_SECONDNAME);
                lastnames[i] = jo.getString(KEY_LASTNAME);


            }
        }catch (JSONException e){
            e.printStackTrace();

        }


    }
}
