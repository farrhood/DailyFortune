package ninja.farhood.dailyfortune;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Daily Fortune";
    private static final String IS_FIRSTTIME = "IsFirstTime";
    public static final String UserName = "name";

    // Constructor
    public MyPreferences(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    // Methods to keep track of the first time user visits the app
    public boolean isFirstTime() {
        return pref.getBoolean(IS_FIRSTTIME, true);
    }

    public void setOld(boolean b){
        if(b){
            editor.putBoolean(IS_FIRSTTIME, false);
            editor.commit();
        }
    }

    // Methods to save and retrieve username
    public String getUserName() {
        return pref.getString(UserName, "");
    }
    public void setUserName(String name) {
        editor.putString(UserName, name);
        editor.commit();
    }
}
