package com.alexTarasyuk.pocketdictionaryapplication.interactors;

import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;

import io.reactivex.Maybe;



public interface IGetMinicard {

    Maybe<MinicardModel> getMinicard(String string);
}
