package com.example.khadamat.viewmodel;

import android.content.Context;

import java.util.Observable;

public class CategoryViewModel extends Observable {
    Context context;

    public CategoryViewModel(Context context) {
        this.context = context;
    }

}
