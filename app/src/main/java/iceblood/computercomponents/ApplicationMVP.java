package iceblood.computercomponents;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.util.Log;

import iceblood.computercomponents.model.database.AppDataBase;

/**
 * Aplication
 */

public class ApplicationMVP extends Application {
    public static ApplicationMVP instance;

    private AppDataBase database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDataBase.class, "database")
                .build();

        Log.d("lol", "onCreate: ");
    }


    public static ApplicationMVP getInstance() {
        return instance;
    }

    public AppDataBase getDatabase() {
        return database;
    }

}
