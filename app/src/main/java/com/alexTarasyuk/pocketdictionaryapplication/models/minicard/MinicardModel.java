package com.alexTarasyuk.pocketdictionaryapplication.models.minicard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class MinicardModel {

    @SerializedName("SourceLanguage")
    @Expose
    Integer sourceLanguage;
    @SerializedName("TargetLanguage")
    @Expose
    Integer targetLanguage;
    @SerializedName("Heading")
    @Expose
    String heading;
    @SerializedName("Translation")
    @Expose
    Translation translation;
    @SerializedName("SeeAlso")
    @Expose
    List<Object> seeAlso;
}
