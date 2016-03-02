package com.skiel.easycooking.daos;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.skiel.easycooking.models.Recipe;
import com.skiel.easycooking.services.HttpConnectionManager;
import com.skiel.easycooking.services.OnServiceFinish;
import com.skiel.easycooking.utils.UrlUtils;

/**
 * Created by ezequiel on 02/03/16.
 */
public class RecipeDao {

    public RecipeDao(){}

    public void getRecipes(String params, Context context, final OnServiceFinish onServiceFinish){
        HttpConnectionManager.getInstance().connectWebServiceResponse(UrlUtils.URL_BASE, params, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                onServiceFinish.onFinish(new Gson().fromJson(response, Recipe.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onServiceFinish.onFail(error.getMessage());
            }
        },context);
    }

}
