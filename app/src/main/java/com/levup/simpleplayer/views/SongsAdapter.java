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

import com.bumptech.glide.Glide;
import com.levup.simpleplayer.R;
import com.levup.simpleplayer.models.Song;
import com.levup.simpleplayer.presenters.SongRepository;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder>{

    private List<Song> mDataSource = null;

    public void setDataSource(List<Song> dataSource) {
        mDataSource = dataSource;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private View.OnClickListener mOnItemClickListener;

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
        holder.itemView.setOnClickListener(mOnItemClickListener);
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
            String cover = SongRepository.getAlbumCover(itemView.getContext(), song.albumId);
            Glide
                .with(itemView.getContext())
                .load(cover)
                .centerCrop()
                .placeholder(new ColorDrawable(Color.GRAY))
                .crossFade()
                .into(mCoverImageView);
        }

        public Song getSong(){
            return mSong;
        }
    }


}
