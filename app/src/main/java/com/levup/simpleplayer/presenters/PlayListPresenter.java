package com.levup.simpleplayer.presenters;

import android.support.annotation.NonNull;

import com.levup.simpleplayer.models.PlayListModel;
import com.levup.simpleplayer.repository.PlayListRepository;
import com.levup.simpleplayer.views.PlayListView;

public class PlayListPresenter {

    private PlayListView mView = null;

    private PlayListRepository mPlayListRepository = null;

    public void onAttachToView(@NonNull PlayListView songsView) {
        mView = songsView;
    }

    public void loadPlayList(){
        mPlayListRepository.loadPlayList()
                .map(PlayListModel::getSongRealmList)
                .subscribe(songs -> mView.onPlayListLoader(songs), Throwable::printStackTrace);
    }
}
