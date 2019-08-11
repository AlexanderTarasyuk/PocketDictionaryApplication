package com.alexTarasyuk.pocketdictionaryapplication.models.translation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class ApiResponseModel {

    @SerializedName("")
    @Expose
    List<ParticularDictionaryModel> particularDictionaryModels;
}
