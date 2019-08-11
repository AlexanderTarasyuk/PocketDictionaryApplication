package com.alexTarasyuk.pocketdictionaryapplication.presentation.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;



@StateStrategyType(AddToEndSingleStrategy.class)
public interface MinicardView extends MvpView {

    void showMinicard(MinicardModel minicardModel);
    void showNewTranslation();
}
