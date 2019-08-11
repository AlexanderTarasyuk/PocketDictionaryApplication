package com.alexTarasyuk.pocketdictionaryapplication.data.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class UserEntity {

    @PrimaryKey
    private long id;

    String login;
    String passwordHash;
    String token;
}
