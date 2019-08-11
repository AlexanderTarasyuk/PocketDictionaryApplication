package com.alexTarasyuk.pocketdictionaryapplication.models.minicard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
//@Entity
public class Translation {

    //@PrimaryKey
    //private long id;

    @SerializedName("Heading")
    @Expose
    String heading;
    @SerializedName("Translation")
    @Expose
    String translation;
    @SerializedName("DictionaryName")
    @Expose
    String dictionaryName;
    @SerializedName("SoundName")
    @Expose
    String soundName;
    @SerializedName("Type")
    @Expose
    Integer type;
    @SerializedName("OriginalWord")
    @Expose
    String originalWord;
}
