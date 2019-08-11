package com.alexTarasyuk.pocketdictionaryapplication.presentation.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.SavedMinicardsInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.alexTarasyuk.pocketdictionaryapplication.presentation.views.SavedMinicardsView;

import java.util.List;

import io.reactivex.observers.DisposableMaybeObserver;
import ru.terrakok.cicerone.Router;



@InjectViewState
public class SavedMinicardsPresenter extends MvpPresenter<SavedMinicardsView> {

    private static final String TAG = SavedMinicardsPresenter.class.getSimpleName();

    private Router mRouter;
    private SavedMinicardsInteractor mSavedMinicardsInteractor;

    public SavedMinicardsPresenter(Router router, SavedMinicardsInteractor savedMinicardsInteractor){
        mRouter = router;
        mSavedMinicardsInteractor = savedMinicardsInteractor;
    }

    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        mSavedMinicardsInteractor.getAllMinicards()
                .subscribe(new DisposableMaybeObserver<List<MinicardModel>>() {
                    @Override
                    public void onSuccess(List<MinicardModel> minicardModels) {
                        getViewState().showSavedMinicards(minicardModels);
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
}
