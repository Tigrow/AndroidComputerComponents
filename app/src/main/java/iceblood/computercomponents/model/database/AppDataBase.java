package iceblood.computercomponents.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import iceblood.computercomponents.model.database.Dao.AssemblyDao;
import iceblood.computercomponents.model.database.Dao.SimpleProcessorDao;
import iceblood.computercomponents.model.objects.Assembly;
import iceblood.computercomponents.model.objects.SimpleProcessor;

/**
 * Created by Titan'ik on 19.03.2018.
 */

@Database(entities = {Assembly.class, SimpleProcessor.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AssemblyDao assemblyDao();
    public abstract SimpleProcessorDao simpleProcessorDao();
}
