package com.alexTarasyuk.pocketdictionaryapplication.presentation.views;

import com.arellomobile.mvp.MvpView;
import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;

import java.util.List;



public interface SavedMinicardsView extends MvpView {

    void showSavedMinicards(List<MinicardModel> minicardModels);
}
