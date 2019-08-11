package com.alexTarasyuk.pocketdictionaryapplication.interactors;

import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;

import java.util.List;

import io.reactivex.Maybe;



public interface IGetAllMinicards {

    Maybe<List<MinicardModel>> getAllMinicards();
}
