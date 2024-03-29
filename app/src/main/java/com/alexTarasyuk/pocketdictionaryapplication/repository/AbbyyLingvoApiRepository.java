package com.alexTarasyuk.pocketdictionaryapplication.repository;

import com.alexTarasyuk.pocketdictionaryapplication.data.SharedPreferencesManager;
import com.alexTarasyuk.pocketdictionaryapplication.data.api.AbbyyLingvoApi;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.IAuthorizeRepository;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.IGetMinicard;
import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;

import io.reactivex.Single;
import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;



public class AbbyyLingvoApiRepository implements IGetMinicard, IAuthorizeRepository {

    private static final String TAG = AbbyyLingvoApiRepository.class.getSimpleName();
    private static final Integer SRC_LANG = 1033;
    private static final Integer DST_LANG = 1049;

    private AbbyyLingvoApi mAbbyyLingvoApi;
    private SharedPreferencesManager mSharedPreferencesManager;

    public AbbyyLingvoApiRepository(AbbyyLingvoApi abbyyLingvoApi, SharedPreferencesManager sharedPreferencesManager) {
        mAbbyyLingvoApi = abbyyLingvoApi;
        mSharedPreferencesManager = sharedPreferencesManager;
    }

    public Single<Object> sendAuthRequest() {
        return mAbbyyLingvoApi.getAuthData("Basic ODk1OWNlNTgtZTNjOS00Y2U2LTlhZDEtMWNlYmJlNTU3N2JjOjJmNTg2YzJhZGQxMDQ5YzFhN2E4ZDM3YjE2ZDE1NTBk")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Maybe<MinicardModel> getMinicard(String string) {
        String token = "Bearer " + mSharedPreferencesManager.readToken();
        return mAbbyyLingvoApi.getMinicardData(token, string, SRC_LANG, DST_LANG)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
