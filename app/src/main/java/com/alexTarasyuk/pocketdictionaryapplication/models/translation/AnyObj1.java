package com.alexTarasyuk.pocketdictionaryapplication.models.translation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



class AnyObj1 {

    @SerializedName("Type")
    @Expose
    Integer type;
    @SerializedName("Items")
    @Expose
    List<AnyObj2> items;
}
