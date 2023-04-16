package com.example.bodyboost;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    private int percentageValue = 100;
    private TextView percentage;
    private ProgressBar percentageBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        percentage = view.findViewById(R.id.percentage);
        percentage.setText(percentageValue + "%");

        percentageBar = view.findViewById(R.id.percentageBar);
        percentageBar.setProgress(percentageValue);

    }

}
