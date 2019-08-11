package com.alexTarasyuk.pocketdictionaryapplication.presentation.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.MinicardInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.alexTarasyuk.pocketdictionaryapplication.presentation.views.MinicardView;

import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.observers.DisposableSingleObserver;
import ru.terrakok.cicerone.Router;

import com.alexTarasyuk.pocketdictionaryapplication.Screens;



@InjectViewState
public class MinicardPresenter extends MvpPresenter<MinicardView> {

    private static final String TAG = MinicardPresenter.class.getSimpleName();

    private Router mRouter;
    private MinicardInteractor mMinicardInteractor;

    public MinicardPresenter(Router router, MinicardInteractor minicardInteractor) {
        mRouter = router;
        mMinicardInteractor = minicardInteractor;
    }

    public void onTranslateClicked(String string) {
        mMinicardInteractor.getMinicard(string)
                .subscribe(new DisposableMaybeObserver<MinicardModel>() {
                    @Override
                    public void onSuccess(MinicardModel minicardModel) {
                        getViewState().showMinicard(minicardModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                    }
                });
    }

    public void onNewTranslationClicked() {
        getViewState().showNewTranslation();
    }

    public void onSaveMinicardMenuClicked() {
        mMinicardInteractor.saveMinicardToRoom()
                /*.subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onSaveMinicardMenuClicked:   " + "saved");
                        mRouter.showSystemMessage("Minicard is saved!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                    }
                });*/
                .subscribe(new DisposableSingleObserver<Long>() {
                    @Override
                    public void onSuccess(Long o) {
                        Log.e(TAG, "onSaveMinicardMenuClicked:   " + o + "saved");
                        mRouter.showSystemMessage("Minicard is saved!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                    }
                });
    }

    public void onSavedMinicardMenuClicked() {
        mRouter.navigateTo(Screens.SAVED_MINICARDS_SCREEN);
    }
}
