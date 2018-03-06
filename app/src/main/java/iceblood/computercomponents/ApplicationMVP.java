package iceblood.computercomponents;

import android.app.Application;
import android.util.Log;

import iceblood.computercomponents.model.database.DbHandler;

/**
 * Aplication
 */

public class ApplicationMVP extends Application {
    private static DbHandler dbHandler;
    @Override
    public void onCreate() {
        super.onCreate();
        dbHandler = new DbHandler(getApplicationContext());
        Log.d("lol", "onCreate: ");
    }

    public static DbHandler getDbHandler() {
        return dbHandler;
    }
}
