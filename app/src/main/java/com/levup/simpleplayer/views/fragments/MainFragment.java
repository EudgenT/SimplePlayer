package com.levup.simpleplayer.views.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.levup.simpleplayer.R;
import com.levup.simpleplayer.views.MenuInteractionListener;

import org.w3c.dom.Text;

public class MainFragment extends Fragment {

    private MenuInteractionListener mListener = null;

    public static final String SOME_VALUE = "SOME_VALUE";

    public static MainFragment newInstance(int value) {

        Bundle args = new Bundle();
        args.putInt(SOME_VALUE, value);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof MenuInteractionListener){
            mListener = (MenuInteractionListener) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn).setOnClickListener(btnView -> {
            mListener.onMainFragmentEventListener(getArguments().getInt(SOME_VALUE));
        });
    }

    public void showText(CharSequence text){
        if(getView() == null) return;
        final TextView textView = (TextView) getView().findViewById(R.id.textView);
        textView.setText(text);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
