package com.levup.simpleplayer.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.levup.simpleplayer.R;

public class PlayListsFragment extends Fragment {

    public static PlayListsFragment newInstance() {
        Bundle args = new Bundle();
        PlayListsFragment fragment = new PlayListsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play_lists, container, false);

    }

}
