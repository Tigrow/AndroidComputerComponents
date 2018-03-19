package iceblood.computercomponents.model.database.Dao;

import android.arch.persistence.room.*;

import java.util.List;

import iceblood.computercomponents.model.objects.Assembly;

/**
 * Dao Table Assembly
 */
@Dao
public interface AssemblyDao {
    @Query("SELECT * FROM assembly")
    List<Assembly> getAll();

    @Query("SELECT * FROM assembly WHERE id = :id")
    Assembly getById(long id);

    @Insert
    void insert(Assembly assembly);

    @Update
    void update(Assembly assembly);

    @Delete
    void delete(Assembly assembly);
}
