package com.alexTarasyuk.pocketdictionaryapplication.models.translation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


class ParticularDictionaryModel {

    @SerializedName("Title")
    @Expose
    String title;
    @SerializedName("Dictionary")
    @Expose
    String dictionary;
    @SerializedName("Body")
    @Expose
    List<Body> bodies;
}
