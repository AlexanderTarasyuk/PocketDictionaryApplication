package com.alexTarasyuk.pocketdictionaryapplication.models;

import com.alexTarasyuk.pocketdictionaryapplication.data.room.entity.MinicardEntity;
import com.alexTarasyuk.pocketdictionaryapplication.models.minicard.MinicardModel;

import java.util.ArrayList;
import java.util.List;



public class ModelMapper {

    private static final String TAG = ModelMapper.class.getSimpleName();

    public static MinicardModel mapRoomToAbbyyLingvoApi(MinicardEntity minicardEntity) {
        MinicardModel minicardModel = new MinicardModel();
        minicardModel.setHeading(minicardEntity.getHeading());//TODO NPE!!!
        minicardModel.setTranslation(minicardEntity.getTranslation());
        return minicardModel;
    }

    public static MinicardEntity mapAbbyyLingvoApiToRoom(MinicardModel minicardModel) {
        MinicardEntity minicardEntity = new MinicardEntity();
        minicardEntity.setHeading(minicardModel.getHeading());//TODO NPE!!!
        minicardEntity.setTranslation(minicardModel.getTranslation());
        return minicardEntity;
    }

    public static List<MinicardModel> mapAllRoomToAbbyyLingvoApi(List<MinicardEntity> minicardEntities) {
        List<MinicardModel> minicardModels = new ArrayList<>(minicardEntities.size());
        if (!minicardEntities.isEmpty() && minicardEntities.size()>0) {
            for (MinicardEntity minicardEntity : minicardEntities) {
                minicardModels.add(mapRoomToAbbyyLingvoApi(minicardEntity));
            }
        }
        return minicardModels;
    }
}
