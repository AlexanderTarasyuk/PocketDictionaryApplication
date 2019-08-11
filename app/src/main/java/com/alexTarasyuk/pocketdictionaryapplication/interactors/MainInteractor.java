package com.alexTarasyuk.pocketdictionaryapplication.interactors;

import io.reactivex.Single;



public class MainInteractor {

    private static final String TAG = MainInteractor.class.getSimpleName();

    public Single<Boolean> checkLoggedIn() {
        return Single.just(false);
    }
}
