package imy320_android_assignment.personalassistant;

import android.app.Activity;
import android.content.SharedPreferences;

public class CityPreference {

    SharedPreferences prefs;

    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return
    // Pretoria as the default city
    String getCity(){
        return prefs.getString("city", "Pretoria, SA");
    }

    void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }

}
