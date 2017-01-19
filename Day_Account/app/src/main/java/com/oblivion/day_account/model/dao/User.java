package com.oblivion.day_account.model.dao;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * author:Created by Oblivion on 2017/1/19.
 * 功能描述:
 */
@RealmClass
public class User implements RealmModel {
    @PrimaryKey
    public String id;
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
