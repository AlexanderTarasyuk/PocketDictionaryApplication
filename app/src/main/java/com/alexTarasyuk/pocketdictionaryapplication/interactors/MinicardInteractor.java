package com.alexTarasyuk.pocketdictionaryapplication.interactors;

import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.alexTarasyuk.pocketdictionaryapplication.repository.RoomRepository;

import io.reactivex.Single;
import io.reactivex.Maybe;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;


public class MinicardInteractor {

    private static final String TAG = MinicardInteractor.class.getSimpleName();

    private RoomRepository mRoomRepository;
    private IGetMinicard mAbbyyLingvoApiRepository;
    private BehaviorSubject<MinicardModel> minicardBuffer = BehaviorSubject.create();//TODO is it necessary or to try field

    public MinicardInteractor(RoomRepository roomRepository, IGetMinicard abbyyLingvoApiMinicardRepository) {
        mRoomRepository = roomRepository;
        mAbbyyLingvoApiRepository = abbyyLingvoApiMinicardRepository;
    }

    public Maybe<MinicardModel> getMinicard(String string) {
        return Maybe.concat(mRoomRepository.getMinicard(string), mAbbyyLingvoApiRepository.getMinicard(string))
                .firstElement()
                .doOnSuccess(new Consumer<MinicardModel>() {
                    @Override
                    public void accept(MinicardModel minicardModel) throws Exception {
                        getMinicardBuffer().onNext(minicardModel);
                    }
                });
    }

    public Single<Long> saveMinicardToRoom() {
        return mRoomRepository.saveMinicard(getMinicardBuffer().getValue());
    }

    private BehaviorSubject<MinicardModel> getMinicardBuffer() {
        return minicardBuffer;
    }
}
