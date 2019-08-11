package com.alexTarasyuk.pocketdictionaryapplication.repository;

import io.reactivex.Completable;



public class LoginRepository {

    private static final String TAG = LoginRepository.class.getSimpleName();

    public Completable login(String email, String password) {
        return Completable.complete();//TODO
    }
}
