package iceblood.computercomponents.model.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import iceblood.computercomponents.model.objects.Assembly;
import iceblood.computercomponents.model.objects.SimpleProcessor;

import static iceblood.computercomponents.model.database.Contract.*;

/**
 * DbHandler
 */

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE " + SimpleEntity.TABLE_NAME + "("
                        + SimpleEntity._ID + " INTEGER PRIMARY KEY, "
                        + SimpleEntity.KEY_NAME + " TEXT, "
                        + SimpleEntity.KEY_DESCRIPTION + " TEXT, "
                        + SimpleEntity.KEY_PRIORITY + " INTEGER)"
        );
        db.execSQL(
                "CREATE TABLE " + AssemblyEntity.TABLE_NAME + "("
                        + AssemblyEntity._ID + " INTEGER PRIMARY KEY, "
                        + AssemblyEntity.CPU_ID + " INTEGER, "
                        + AssemblyEntity.MOTHERBOARD_ID + " INTEGER, "
                        + AssemblyEntity.GPU_ID + " INTEGER, "
                        + AssemblyEntity.GPU2_ID + " INTEGER, "
                        + AssemblyEntity.GPU3_ID + " INTEGER, "
                        + AssemblyEntity.GPU4_ID + " INTEGER, "
                        + AssemblyEntity.GPU5_ID + " INTEGER, "
                        + AssemblyEntity.GPU6_ID + " INTEGER, "
                        + AssemblyEntity.RAM_SIZE + " INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + SimpleEntity.TABLE_NAME);
        onCreate(db);
    }

    public void addSimpleData(SimpleProcessor simpleData) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SimpleEntity._ID, simpleData.getId());
        cv.put(SimpleEntity.KEY_NAME, simpleData.getName());

        db.insert(SimpleEntity.TABLE_NAME, null, cv);
        db.close();
    }

    public boolean isSimpleDataLiked(int ID) {
        boolean isEmpty;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(SimpleEntity.TABLE_NAME, new String[]{SimpleEntity.KEY_NAME},
                SimpleEntity._ID + "=?", new String[]{String.valueOf(ID)}, null, null, null);
        isEmpty = cursor.getCount() != 0;
        cursor.close();

        return isEmpty;
    }

    public int delete(int id) {

        int number;
        SQLiteDatabase db = getWritableDatabase();
        number = db.delete(SimpleEntity.TABLE_NAME, SimpleEntity._ID + "=?", new String[]{String.valueOf(id)});
        db.close();

        return number;
    }

    public List<Assembly> getAllTasks() {

        List<Assembly> tasks = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + AssemblyEntity.TABLE_NAME, null);
        while (cursor.moveToNext()) {
            Assembly assembly = new Assembly();
            /*assembly.setCpuID(cursor.getInt());
            task.set_id(cursor.getInt(0));
            task.set_name(cursor.getString(1));
            task.set_description(cursor.getString(2));
            task.set_priority(cursor.getInt(3));

            tasks.add(task);*/
        }
        cursor.close();
        return tasks;
    }

    public int getTasksCount() {
        int count;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + SimpleEntity.TABLE_NAME, null);
        count = cursor.getCount();
        cursor.close();

        return count;
    }

    /*public int update(Task task, int id) {

        int number = -1;

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TaskEntry.KEY_NAME, task.get_name());
        cv.put(TaskEntry.KEY_DESCRIPTION, task.get_description());
        cv.put(TaskEntry.KEY_PRIORITY, task.get_priority());

        number = db.update(TaskEntry.TABLE_TASKS, cv, TaskEntry._ID + "=?", new String[]{String.valueOf(id)});
        db.close();

        return number;
    }*/


    /*public void swap(Task firstMember, Task secondMember) {

        update(firstMember,secondMember.get_id());
        update(secondMember,firstMember.get_id());
    }*/
}
