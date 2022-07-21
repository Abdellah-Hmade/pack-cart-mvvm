package com.hmd377.pack_carte_mvvm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.widget.TextView;

import com.hmd377.pack_carte_mvvm.fragments.FooterFragment;
import com.hmd377.pack_carte_mvvm.fragments.StaticBodyFragment;
import com.hmd377.pack_carte_mvvm.model.PackModel;
import com.hmd377.pack_carte_mvvm.vm.PackViewModel;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //private PackViewModel packViewModel=null;
    private List<PackModel> packs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tv = findViewById(R.id.data_text_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.bmci);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new StaticBodyFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2,new FooterFragment(true)).commit();

        /*ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        packViewModel = new ViewModelProvider(this,factory).get(PackViewModel.class);

        packViewModel.getAllPack().observe(this, new Observer<List<PackModel>>() {
            @Override
            public void onChanged(List<PackModel> packModels) {
                changeTextV();
            }
        });

        changeTextV();*/
    }

    /*public void changeTextV(){
        String text="";
        for(PackModel pack: packViewModel.getAllPack().getValue()){
            text = pack.getTitle() +"\n";
        }
        tv.setText(text);
    }*/
}