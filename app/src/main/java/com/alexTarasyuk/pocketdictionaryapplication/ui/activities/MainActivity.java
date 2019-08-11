package com.alexTarasyuk.pocketdictionaryapplication.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.alexTarasyuk.pocketdictionaryapplication.PocketDictionaryApp;
import com.alexTarasyuk.pocketdictionaryapplication.R;
import com.alexTarasyuk.pocketdictionaryapplication.Screens;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.MainInteractor;
import com.alexTarasyuk.pocketdictionaryapplication.presentation.presenters.MainPresenter;
import com.alexTarasyuk.pocketdictionaryapplication.presentation.views.MainView;
import com.alexTarasyuk.pocketdictionaryapplication.ui.fragments.LoginFragment;
import com.alexTarasyuk.pocketdictionaryapplication.ui.fragments.MinicardFragment;
import com.alexTarasyuk.pocketdictionaryapplication.ui.fragments.SavedMinicardsFragment;

import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;



public class MainActivity extends MvpAppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @InjectPresenter
    MainPresenter mMainPresenter;

    @ProvidePresenter
    MainPresenter provideMainPresenter() {
        Router router = PocketDictionaryApp.getInstance().getRouter();
        MainInteractor mainInteractor = PocketDictionaryApp.getAppComponent().getMainInteractor();//TODO
        return new MainPresenter(router, mainInteractor);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.fragment_container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.LOGIN_SCREEN:
                    Log.e(TAG, "LOGIN_SCREEN");
                    return LoginFragment.getInstance();
                case Screens.MINICARD_SCREEN:
                    Log.e(TAG, "MINICARD_SCREEN");
                    return MinicardFragment.getInstance();
                case Screens.SAVED_MINICARDS_SCREEN:
                    Log.e(TAG, "SAVED_MINICARDS_SCREEN");
                    return SavedMinicardsFragment.getInstance();
            }
            Log.e(TAG, "NULL");
            return null;
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        PocketDictionaryApp.getInstance().getNavigatorHolder().setNavigator(navigator);
        Log.e(TAG, "onResume");
        Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        PocketDictionaryApp.getInstance().getNavigatorHolder().removeNavigator();
        super.onPause();
        Log.e(TAG, "onPause");
    }
}
