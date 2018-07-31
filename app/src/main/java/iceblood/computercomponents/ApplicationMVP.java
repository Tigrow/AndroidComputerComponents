package iceblood.computercomponents;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;
import iceblood.computercomponents.model.database.AppDataBase;

/**
 * Aplication
 */

public class ApplicationMVP extends Application {
    private static ApplicationMVP instance;


    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private AppDataBase database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDataBase.class, "database")
                .build();

        initFirebase();
        Log.d("lol", "onCreate: ");
    }


    public static ApplicationMVP getInstance() {
        return instance;
    }

    public AppDataBase getDatabase() {
        return database;
    }

    private void initFirebase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("configuration/dbVersion");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //FirebaseApp.initializeApp(this);
        //получаем точку входа для базы данных
        //mFirebaseDatabase = FirebaseDatabase.getInstance();
        //получаем ссылку для работы с базой данных
        //mDatabaseReference = mFirebaseDatabase.getReference();
    }

}
