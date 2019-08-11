package com.alexTarasyuk.pocketdictionaryapplication.di;

import com.alexTarasyuk.pocketdictionaryapplication.interactors.LoginInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.MainInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.MinicardInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.SavedMinicardsInteractor;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainInteractor getMainInteractor();
    LoginInteractor getLoginInteractor();
    MinicardInteractor getMinicardInteractor();
    SavedMinicardsInteractor getSavedMinicardsInteractor();
}
