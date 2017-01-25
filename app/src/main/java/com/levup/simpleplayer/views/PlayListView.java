package com.levup.simpleplayer.views;

import com.levup.simpleplayer.models.Song;

import java.util.List;

public interface PlayListView {

    public void onPlayListLoader(List<Song> list);
}