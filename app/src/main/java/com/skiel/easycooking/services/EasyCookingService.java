package com.skiel.easycooking.services;

import android.content.Context;

import com.skiel.easycooking.daos.RecipeDao;

/**
 * Created by ezequiel on 02/03/16.
 */
public class EasyCookingService {

    private EasyCookingService instance;
    private RecipeDao recipeDao;

    public EasyCookingService getInstance(){
        if(instance==null){
            instance = new EasyCookingService();
        }
        return instance;
    }

    public EasyCookingService(){
        recipeDao = new RecipeDao();
    }

    public void getRecipes(String params,Context context, OnServiceFinish onServiceFinish){
        recipeDao.getRecipes(params, context, onServiceFinish);
    }
}
