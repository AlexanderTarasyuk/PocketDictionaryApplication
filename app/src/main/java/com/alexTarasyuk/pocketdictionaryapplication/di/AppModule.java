package com.alexTarasyuk.pocketdictionaryapplication.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.alexTarasyuk.pocketdictionaryapplication.data.SharedPreferencesManager;
import com.alexTarasyuk.pocketdictionaryapplication.data.api.AbbyyLingvoApi;
import com.alexTarasyuk.pocketdictionaryapplication.data.api.ApiManager;
import com.alexTarasyuk.pocketdictionaryapplication.data.room.PocketDictionaryAppDatabase;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.LoginInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.MainInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.MinicardInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.SavedMinicardsInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.repository.AbbyyLingvoApiRepository;
import com.alexTarasyuk.pocketdictionaryapplication.repository.LoginRepository;
import com.alexTarasyuk.pocketdictionaryapplication.repository.RoomRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;



@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    PocketDictionaryAppDatabase providePocketDictionaryAppDatabase() {
        return Room.databaseBuilder(mContext,
                PocketDictionaryAppDatabase.class, "PocketDictionaryAppDatabase")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    AbbyyLingvoApi provideAbbyyLingvoApi() {
        return ApiManager.getAbbyyLingvoApi();
    }

    @Provides
    MainInteractor provideMainInteractor() {
        return new MainInteractor();
    }

    @Provides
    LoginInteractor provideLoginInteractor(LoginRepository loginRepository, AbbyyLingvoApiRepository abbyyLingvoApiRepository, SharedPreferencesManager sharedPreferencesManager) {
        return new LoginInteractor(loginRepository, abbyyLingvoApiRepository, sharedPreferencesManager);
    }

    @Provides
    MinicardInteractor provideMinicardInteractor(RoomRepository roomRepository, AbbyyLingvoApiRepository abbyyLingvoApiRepository) {
        return new MinicardInteractor(roomRepository, abbyyLingvoApiRepository);
    }

    @Provides
    SavedMinicardsInteractor provideSavedMinicardsInteractor(RoomRepository roomRepository) {
        return new SavedMinicardsInteractor(roomRepository);
    }

    @Provides
    LoginRepository provideLoginRepository() {
        return new LoginRepository();
    }

    @Provides
    RoomRepository provideRoomRepository() {
        return new RoomRepository();
    }

    @Provides
    AbbyyLingvoApiRepository provideAbbyyLingvoApiRepository(AbbyyLingvoApi abbyyLingvoApi, SharedPreferencesManager sharedPreferencesManager) {
        return new AbbyyLingvoApiRepository(abbyyLingvoApi, sharedPreferencesManager);
    }

    @Provides
    SharedPreferencesManager provideSharedPreferencesManager(SharedPreferences sharedPreferences) {
        return new SharedPreferencesManager(sharedPreferences);
    }

    @Provides
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager
                .getDefaultSharedPreferences(mContext);
    }
}
