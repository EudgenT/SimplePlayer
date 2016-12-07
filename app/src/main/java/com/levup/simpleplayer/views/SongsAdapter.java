package com.levup.simpleplayer.views;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.levup.simpleplayer.R;
import com.levup.simpleplayer.models.Song;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder>{

    private List<Song> mDataSource = null;

    public void setDataSource(List<Song> dataSource) {
        mDataSource = dataSource;
        notifyDataSetChanged();
    }

    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_main_song, parent, false);
        return new SongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongsViewHolder holder, int position) {
        final Song song = mDataSource.get(position);
        holder.bind(song);
    }

    @Override
    public int getItemCount() {
        return mDataSource == null ? 0 : mDataSource.size();
    }

    public static class SongsViewHolder extends RecyclerView.ViewHolder {

        private Song mSong;

        private TextView mArtistTextView;
        private TextView mTitleTextView;
        private ImageView mCoverImageView;

        public SongsViewHolder(View itemView) {
            super(itemView);
            mArtistTextView = (TextView) itemView.findViewById(R.id.artistTextView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            mCoverImageView = (ImageView) itemView.findViewById(R.id.coverImageView);
        }

        public void bind(@NonNull Song song) {
            mSong = song;
            mArtistTextView.setText(song.title);
            mTitleTextView.setText(song.artistName);
            mCoverImageView.setImageDrawable(new ColorDrawable(Color.GRAY));
        }

        public Song getSong(){
            return mSong;
        }
    }


}
