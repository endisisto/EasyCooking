package com.skiel.easycooking.services;


import com.skiel.easycooking.models.Response;

import java.util.List;
import java.util.Objects;

/**
 * Created by ezequiel on 20/05/15.
 */
public abstract class OnServiceFinish {

    public void onFinish(Objects serviceResponse){}
    public void onFinish(List<Objects> serviceResponseList){}
    public void onFinish(String response){}
    public void onFail(String error){}

}
