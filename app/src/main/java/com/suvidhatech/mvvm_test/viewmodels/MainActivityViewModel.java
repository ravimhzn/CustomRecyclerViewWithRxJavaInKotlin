package com.suvidhatech.mvvm_test.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.suvidhatech.mvvm_test.models.NicePlace;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;

    public LiveData<List<NicePlace>> getNicePlaces(){
        return mNicePlaces;
    }
}
