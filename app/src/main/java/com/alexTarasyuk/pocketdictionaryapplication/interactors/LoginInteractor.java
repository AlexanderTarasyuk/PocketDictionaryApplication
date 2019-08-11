package com.alexTarasyuk.pocketdictionaryapplication.interactors;

import android.text.TextUtils;
import android.util.Log;

import com.alexTarasyuk.pocketdictionaryapplication.data.SharedPreferencesManager;
import com.alexTarasyuk.pocketdictionaryapplication.repository.LoginRepository;
import io.reactivex.Completable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.Single;


public class LoginInteractor {

    private static final String TAG = LoginInteractor.class.getSimpleName();
    private LoginRepository mLoginRepository;
    private IAuthorizeRepository mAbbyyLingvoApiRepository;
    private SharedPreferencesManager mSharedPreferencesManager;

    public LoginInteractor(LoginRepository loginRepository, IAuthorizeRepository abbyyLingvoApiRepository, SharedPreferencesManager sharedPreferencesManager) {
        mLoginRepository = loginRepository;
        mAbbyyLingvoApiRepository = abbyyLingvoApiRepository;
        mSharedPreferencesManager = sharedPreferencesManager;
    }

    public Completable login(String email, String password) {
        if (isValidEmail(email) && isValidPassword(password)) {
            return mLoginRepository.login(email, password);
        }
        return Completable.error(new IllegalArgumentException("Wrong email or password!"));
    }

    public Single<Boolean> authorize() {
        return mAbbyyLingvoApiRepository.sendAuthRequest()
                .doOnSuccess(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mSharedPreferencesManager.saveToken(o.toString());
                        Log.e(TAG, o.toString());
                    }
                })
                .map(new Function<Object, Boolean>() {
                    @Override
                    public Boolean apply(Object o) throws Exception {
                        return true;//TODO
                    }
                });
    }

    private boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email);
    }

    private boolean isValidPassword(CharSequence password) {
        return !TextUtils.isEmpty(password);

    }
}
