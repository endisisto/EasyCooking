package com.skiel.easycooking.services;


import com.skiel.easycooking.models.Response;

import java.util.List;

/**
 * Created by ezequiel on 20/05/15.
 */
public abstract class OnServiceFinish {

    public void onFinish(Response serviceResponse){}
    public void onFinish(List<Response> serviceResponseList){}
    public void onFinish(String response){}
    public void onFail(String error){}

}
