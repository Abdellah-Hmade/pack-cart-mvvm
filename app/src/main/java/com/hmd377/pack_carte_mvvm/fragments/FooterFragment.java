package com.hmd377.pack_carte_mvvm.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hmd377.pack_carte_mvvm.R;

public class FooterFragment extends Fragment {

    private Button addToCartButton;
    private Button continueButton;
    private Button backButton;

    Boolean defaultO = true;
    public FooterFragment(){}
    public FooterFragment(Boolean bool) {
     defaultO = bool;
    }

    public FooterFragment(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
           if (defaultO) {
               return inflater.inflate(R.layout.custom_layout_button_bar,container,false);
           }
           else {
               return inflater.inflate(R.layout.custom_layout_button_bar_2,container,false);
           }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        addToCartButton = view.findViewById(R.id.addCart);
        continueButton = view.findViewById(R.id.continue_button);
        backButton = view.findViewById(R.id.continue_button);
    }
}
