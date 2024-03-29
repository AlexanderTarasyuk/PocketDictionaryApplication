package com.alexTarasyuk.pocketdictionaryapplication.presentation.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.alexTarasyuk.pocketdictionaryapplication.Screens;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.MainInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.presentation.views.MainView;

import io.reactivex.observers.DisposableSingleObserver;
import ru.terrakok.cicerone.Router;



@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private Router mRouter;
    private MainInteractor mMainInteractor;

    public MainPresenter(Router router, MainInteractor mainInteractor) {
        mRouter = router;
        mMainInteractor = mainInteractor;
    }

    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        mMainInteractor.checkLoggedIn()
                .subscribe(new DisposableSingleObserver<Boolean>() {
                    @Override
                    public void onSuccess(Boolean aBoolean) {
                        if (aBoolean) {
                            mRouter.navigateTo(Screens.MINICARD_SCREEN);
                        }
                        else mRouter.navigateTo(Screens.LOGIN_SCREEN);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                    }
                });
    }
}
