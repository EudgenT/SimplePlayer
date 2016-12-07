package com.levup.simpleplayer.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.levup.simpleplayer.models.Song;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder>{

    private List<Song> mDataSource = null;

    public void setDataSource(List<Song> dataSource) {
        this.mDataSource = dataSource;
    }

    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SongsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataSource == null ? 0 : mDataSource.size();
    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder {

        public SongsViewHolder(View itemView) {
            super(itemView);
        }

    }
}
