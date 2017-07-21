package com.example.tjss.moviez;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentOne extends Fragment implements View.OnClickListener{
    private EditText mEtTitle, mEtGenre, mEtYear;
    private FragmentOneInterface mCallback;
    public FragmentOne() {

    }

    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentOneInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentOneInterface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mEtTitle= rootView.findViewById(R.id.et_01);
        mEtGenre= rootView.findViewById(R.id.et_02);
        mEtYear= rootView.findViewById(R.id.et_03);
        Button button=rootView.findViewById(R.id.button);
        button.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        String title=mEtTitle.getText().toString();
        String genre=mEtGenre.getText().toString();
        String year=mEtYear.getText().toString();
        Movie movie=new Movie (title, genre, year);
        mCallback.addMovie(movie);
    }

    public interface FragmentOneInterface {
    void addMovie(Movie movie);
    }
}

