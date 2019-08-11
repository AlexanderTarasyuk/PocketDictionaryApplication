package com.alexTarasyuk.pocketdictionaryapplication.data.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.OnConflictStrategy;

import com.alexTarasyuk.pocketdictionaryapplication.data.room.entity.MinicardEntity;

import io.reactivex.Maybe;

import java.util.List;



@Dao
public interface MinicardDao {

    @Query("SELECT * FROM minicardentity WHERE heading = :string")
    Maybe<MinicardEntity> getMinicardEntity(String string);

    @Query("SELECT * FROM minicardentity")
    Maybe<List<MinicardEntity>> getAllMinicards();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertMinicardEntity(MinicardEntity minicardEntity);
}
