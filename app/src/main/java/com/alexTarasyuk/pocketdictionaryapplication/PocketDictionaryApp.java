package com.alexTarasyuk.pocketdictionaryapplication;

import android.app.Application;
import android.util.Log;

import com.alexTarasyuk.pocketdictionaryapplication.di.AppComponent;
import com.alexTarasyuk.pocketdictionaryapplication.di.AppModule;
import com.alexTarasyuk.pocketdictionaryapplication.di.DaggerAppComponent;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;


public class PocketDictionaryApp extends Application {

    private static final String TAG = PocketDictionaryApp.class.getSimpleName();

    private static PocketDictionaryApp instance;
    private Cicerone<Router> cicerone;
    public Router mRouter;
    public NavigatorHolder mNavigatorHolder;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        cicerone = Cicerone.create();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();

        Log.e(TAG, String.valueOf(cicerone));
    }

    public NavigatorHolder getNavigatorHolder() {
        Log.e(TAG, "getNavigatorHolder");
        if (mNavigatorHolder == null) mNavigatorHolder = cicerone.getNavigatorHolder();
        return mNavigatorHolder;
    }

    public Router getRouter() {
        Log.e(TAG, "getRouter");
        if (mRouter == null) mRouter = cicerone.getRouter();
        return mRouter;
    }

    public static PocketDictionaryApp getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
