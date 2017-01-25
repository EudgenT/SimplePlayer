package com.levup.simpleplayer.models;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class PlayListModel implements RealmModel {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @PrimaryKey
    private long id = 1;

    private RealmList<Song> songRealmList = new RealmList<>();

    public RealmList<Song> getSongRealmList() {
        return songRealmList;
    }

    public void setSongRealmList(RealmList<Song> songRealmList) {
        this.songRealmList = songRealmList;
    }
}
