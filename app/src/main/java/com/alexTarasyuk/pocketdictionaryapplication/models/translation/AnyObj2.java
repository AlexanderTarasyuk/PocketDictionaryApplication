package com.alexTarasyuk.pocketdictionaryapplication.models.translation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


class AnyObj2 {

    @SerializedName("Markup")
    @Expose
    List<AnyObj3> markups;
}
