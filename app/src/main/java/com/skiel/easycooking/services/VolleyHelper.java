package com.skiel.easycooking.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ezequiel on 19/05/15.
 */
public class VolleyHelper {

    private static VolleyHelper instance;
    private static Context context;
    private RequestQueue requestQueue;

    public static VolleyHelper getInstance(Context context){
        if(instance==null){
            instance = new VolleyHelper(context);
        }
        return instance;
    }

    private VolleyHelper(Context ctx){
        context = ctx;
        requestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());

        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req,String tag) {
        getRequestQueue().add(req.setTag(tag));
    }

    public void cancellRequestQueue(String tag){
        if (getRequestQueue() != null) {
            getRequestQueue().cancelAll(tag);
        }
    }

}
