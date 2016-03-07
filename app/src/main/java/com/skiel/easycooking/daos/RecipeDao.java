package com.skiel.easycooking.daos;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.skiel.easycooking.models.Hits;
import com.skiel.easycooking.models.Recipe;
import com.skiel.easycooking.services.HttpConnectionManager;
import com.skiel.easycooking.services.OnServiceFinish;
import com.skiel.easycooking.utils.UrlUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

/**
 * Created by ezequiel on 02/03/16.
 */
public class RecipeDao {

    public RecipeDao(){}

    public void getRecipes(String params, Context context, final OnServiceFinish onServiceFinish){
        HttpConnectionManager.getInstance().connectWebServiceResponse(UrlUtils.URL_BASE, params, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    Type listType = new TypeToken<List<Hits>>(){}.getType();
                    onServiceFinish.onFinish((List<Objects>) new Gson().fromJson(jsonObject.getJSONArray("hits").toString(), listType));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onServiceFinish.onFail(error.getMessage());
            }
        },context);
    }

}
