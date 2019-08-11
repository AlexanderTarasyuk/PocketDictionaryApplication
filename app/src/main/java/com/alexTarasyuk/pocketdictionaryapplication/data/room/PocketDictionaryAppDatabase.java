package com.alexTarasyuk.pocketdictionaryapplication.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.alexTarasyuk.pocketdictionaryapplication.data.room.dao.MinicardDao;
import com.alexTarasyuk.pocketdictionaryapplication.data.room.entity.MinicardEntity;


@Database(entities = {MinicardEntity.class/*, Translation.class*/}, version = 2, exportSchema = false)
public abstract class PocketDictionaryAppDatabase extends RoomDatabase {

    public abstract MinicardDao minicardDao();
    //public abstract TranslationDao translationDao();
}
