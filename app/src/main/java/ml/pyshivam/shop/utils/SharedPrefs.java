package ml.pyshivam.shop.utils;

import android.content.SharedPreferences;

public class SharedPrefs {

    public SharedPrefs(SharedPreferences sharedpreferences) {
        this.sharedpreferences = sharedpreferences;
    }

    private SharedPreferences sharedpreferences;

    public void putString(String key, String value){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void putBoolean(String key, Boolean value){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getString(String key){
        return sharedpreferences.getString(key, " ");
    }

    public Boolean getBoolean(String key){
        return sharedpreferences.getBoolean(key, false);
    }

    public void clear(){
        sharedpreferences.edit().clear().commit();
    }


}
