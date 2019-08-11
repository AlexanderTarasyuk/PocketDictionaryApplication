package com.alexTarasyuk.pocketdictionaryapplication.data.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.Translation;

import io.reactivex.Single;



@Dao
public interface TranslationDao {

    @Query("SELECT * FROM translation")
    Single<Translation> getTranslation();
}
