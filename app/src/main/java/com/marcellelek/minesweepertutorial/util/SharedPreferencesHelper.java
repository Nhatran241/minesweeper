package com.marcellelek.minesweepertutorial.util;

import android.content.Context;

public class SharedPreferencesHelper {
    public static String name="APP";

    private SharedPreferencesHelper(Context context){
    }

    private static void ensureNotNull(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context is null.");
        }
    }
    public static void setGold(Context context){
        ensureNotNull(context);
        context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .edit().putInt("Gold",getGold(context)+1).apply();
    }

    public static int getGold(Context context){
        ensureNotNull(context);
        return context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .getInt("Gold",0);
    }

    public static void setEXP(Context context){
        ensureNotNull(context);
        context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .edit().putInt("EXP",getEXP(context)+1).apply();
    }
    public static void setEXP(Context context,int num){
        ensureNotNull(context);
        context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .edit().putInt("EXP",num).apply();
    }
    public static int getEXP(Context context){
        ensureNotNull(context);
        return context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .getInt("EXP",0);
    }
    public static void setLevel(Context context){
        ensureNotNull(context);
        context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .edit().putInt("Level",getLevel(context)+1).apply();
    }
    public static int getLevel(Context context){
        ensureNotNull(context);
        return context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .getInt("Level",1);
    }

    public static void setLock(Context context,String lock){
        ensureNotNull(context);
        context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .edit().putBoolean(lock,false).apply();
    }
    public static boolean getLock(Context context,String lock){
        ensureNotNull(context);
        return context.getSharedPreferences(name,Context.MODE_PRIVATE)
                .getBoolean(lock,true);
    }


}