package com.alexTarasyuk.pocketdictionaryapplication.interactors;

import io.reactivex.Single;



public interface IAuthorizeRepository {

    Single<Object> sendAuthRequest();
}
