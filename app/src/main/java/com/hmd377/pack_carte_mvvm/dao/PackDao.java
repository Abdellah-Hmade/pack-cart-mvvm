package com.hmd377.pack_carte_mvvm.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.hmd377.pack_carte_mvvm.model.PackModel;

import java.util.List;

@Dao
public interface PackDao {
    @Insert
    void insert(PackModel pack);

    @Update
    void update(PackModel pack);


    @Delete
    void delete(PackModel pack);


    @Query("SELECT * FROM packModel order by title Desc")
    LiveData<List<PackModel>> getAllPacks();

}
