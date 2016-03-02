package com.skiel.easycooking.services;

import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Map;

import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;

/**
 * Created by ezequiel on 20/10/15.
 */
public class HttpConnectionManager {


    private static HttpConnectionManager instance;

    public static HttpConnectionManager getInstance() {
        if (instance == null) {
            instance = new HttpConnectionManager();
        }
        return instance;
    }

    public void connectWebServiceResponse(String url, final String params, Response.Listener<String> responseListener, Response.ErrorListener errorListener, final Context context){

        StringRequest jsObjRequest = new StringRequest(GET, url + params, responseListener,errorListener);
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleyHelper.getInstance(context).addToRequestQueue(jsObjRequest,url);
    }

    public void cancelService(Context context,String serviceTag){
        VolleyHelper.getInstance(context).getRequestQueue().cancelAll(serviceTag);
    }

}
