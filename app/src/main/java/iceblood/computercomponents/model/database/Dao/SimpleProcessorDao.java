package iceblood.computercomponents.model.database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Single;

/**
 * Created by Titan'ik on 19.03.2018.
 */
@Dao
public interface SimpleProcessorDao {
    @Query("SELECT * FROM simpleprocessor")
    Single<List<SimpleProcessor>> getAll();

    @Query("SELECT * FROM simpleprocessor WHERE id = :id")
    SimpleProcessor getById(long id);

    @Insert
    void insert(SimpleProcessor simpleProcessor);

    @Update
    void update(SimpleProcessor simpleProcessor);

    @Delete
    void delete(SimpleProcessor simpleProcessor);
}
