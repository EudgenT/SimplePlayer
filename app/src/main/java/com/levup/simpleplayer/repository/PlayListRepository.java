package com.levup.simpleplayer.repository;

import com.levup.simpleplayer.models.PlayListModel;
import com.levup.simpleplayer.models.Song;

import java.util.List;
import java.util.concurrent.Callable;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import rx.Completable;
import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class PlayListRepository {

    private Realm mRealm = Realm.getDefaultInstance();

    public Single<PlayListModel> loadPlayList() {
        return Single.create(singleSubscriber -> {
            mRealm.executeTransaction(realm -> {
                PlayListModel result = realm
                        .where(PlayListModel.class)
                        .findFirst();
                if (result == null) {

                }
                singleSubscriber.onSuccess(result);
            });
        });
    }

    public void addSong(Song song) {
        mRealm.executeTransactionAsync(realm -> {
            PlayListModel playListModel = realm.where(PlayListModel.class).findFirst();
            playListModel.getSongRealmList().add(song);
            realm.copyToRealmOrUpdate(playListModel);
        });
    }

    private Single<Song> getSongAfter(long id) {
        return Single.create(singleSubscriber -> {
            mRealm.executeTransactionAsync(realm -> {
                PlayListModel playList = realm
                        .where(PlayListModel.class)
                        .findFirst();
                RealmList<Song> songs = playList.getSongRealmList();
                int currentSongIndex = -1;
                for (int index = 0; index <= songs.size(); index++) {
                    if (songs.get(index).getId() == id) {
                        currentSongIndex = index;
                        break;
                    }
                }
                if (currentSongIndex == -1) {
                    singleSubscriber.onError(new IllegalArgumentException("can't find song with id = " + id));
                }
                currentSongIndex++;
                if(currentSongIndex<=songs.size()){
                    singleSubscriber.onSuccess(songs.get(currentSongIndex));
                } else {
                    singleSubscriber.onError(new IllegalArgumentException("It was last song!"));
                }
            });
        });
    }

    private Completable clear() {
        return Completable.fromAction(() -> mRealm.delete(PlayListModel.class));
    }
}
