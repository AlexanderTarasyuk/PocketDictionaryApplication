package com.alexTarasyuk.pocketdictionaryapplication.interactors;

import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;
import com.alexTarasyuk.pocketdictionaryapplication.repository.RoomRepository;

import java.util.List;

import io.reactivex.Maybe;



public class SavedMinicardsInteractor {

    private RoomRepository mRoomRepository;

    public SavedMinicardsInteractor(RoomRepository roomRepository) {
        mRoomRepository = roomRepository;
    }

    public Maybe<List<MinicardModel>> getAllMinicards() {
        return mRoomRepository.getAllMinicards();
    }
}
