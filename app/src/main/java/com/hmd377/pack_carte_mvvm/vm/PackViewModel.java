package com.hmd377.pack_carte_mvvm.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hmd377.pack_carte_mvvm.model.PackModel;
import com.hmd377.pack_carte_mvvm.repository.PackRepository;

import java.util.List;

public class PackViewModel extends AndroidViewModel {
    private Integer myNumber=0;
    private PackRepository repository;
    private LiveData<List<PackModel>> allPacks;

    public PackViewModel(@NonNull Application application) {
        super(application);
        repository = new PackRepository(application);
        allPacks = repository.getAllPacks();
    }

    public Integer getMyNumber() {
        if(myNumber+1 < allPacks.getValue().size()) {
            myNumber++;
            return myNumber-1;
        }
        return myNumber;
    }

    public Integer getInCartNumber(){
        Integer integ = 0;
        for (PackModel pack :allPacks.getValue()){
            if (pack.getInCart()){
                integ++;
            }
        }
        return integ;
    }

    public LiveData<List<PackModel>> getAllPack(){
        return repository.getAllPacks();
    }

    public PackModel getPack(int id){
        if (0<=id && id < allPacks.getValue().size()){
            return allPacks.getValue().get(id);
        }
        return null;
    }

    public void addToCart(int id){

            if (0<=id && id < allPacks.getValue().size()){
                if (!allPacks.getValue().get(id).getInCart()){
                    allPacks.getValue().get(id).setInCart(true);
                    update(allPacks.getValue().get(id));
                }
            }

    }



    public void excludeFromCart(int id){
        if (0<=id && id < allPacks.getValue().size()){
            if (allPacks.getValue().get(id).getInCart()){
                allPacks.getValue().get(id).setInCart(false);
                update(allPacks.getValue().get(id));
            }
        }
    }

    private void update(PackModel packModel){
        repository.update(packModel);
    }
}
