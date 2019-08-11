package com.alexTarasyuk.pocketdictionaryapplication.repository;

import android.arch.persistence.room.Room;

import com.alexTarasyuk.pocketdictionaryapplication.PocketDictionaryApp;
import com.alexTarasyuk.pocketdictionaryapplication.data.room.PocketDictionaryAppDatabase;
import com.alexTarasyuk.pocketdictionaryapplication.data.room.dao.MinicardDao;
import com.alexTarasyuk.pocketdictionaryapplication.data.room.entity.MinicardEntity;
import com.alexTarasyuk.pocketdictionaryapplication.interactors.IMinicardRepository;
import com.alexTarasyuk.pocketdictionaryapplication.models.ModelMapper;
import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;

import io.reactivex.Single;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Callable;
import java.util.List;



public class RoomRepository implements IMinicardRepository {

    private static final String TAG = RoomRepository.class.getSimpleName();

    private PocketDictionaryAppDatabase mPocketDictionaryAppDatabase = Room
                    .databaseBuilder(PocketDictionaryApp.getInstance().getApplicationContext(),
                            PocketDictionaryAppDatabase.class, "PocketDictionaryAppDatabase")
            .fallbackToDestructiveMigration()
            .build();
    private MinicardDao mMinicardDao = mPocketDictionaryAppDatabase.minicardDao();

    @Override
    public Maybe<MinicardModel> getMinicard(String string) {
        return mMinicardDao.getMinicardEntity(string)
                .subscribeOn(Schedulers.io())
                .map(new Function<MinicardEntity, MinicardModel>() {
                    @Override
                    public MinicardModel apply(MinicardEntity minicardEntity) throws Exception {
                        return ModelMapper.mapRoomToAbbyyLingvoApi(minicardEntity);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Maybe<List<MinicardModel>> getAllMinicards() {
        return mMinicardDao.getAllMinicards()
                .subscribeOn(Schedulers.io())
                .map(new Function<List<MinicardEntity>, List<MinicardModel>>() {
                    @Override
                    public List<MinicardModel> apply(List<MinicardEntity> minicardEntities) throws Exception {
                        return ModelMapper.mapAllRoomToAbbyyLingvoApi(minicardEntities);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Long> saveMinicard(final MinicardModel minicardModel) {
        return Single.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mMinicardDao.insertMinicardEntity(ModelMapper.mapAbbyyLingvoApiToRoom(minicardModel));
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
