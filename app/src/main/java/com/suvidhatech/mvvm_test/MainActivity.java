package com.suvidhatech.mvvm_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.suvidhatech.mvvm_test.adapters.RecyclerAdapter;
import com.suvidhatech.mvvm_test.models.NicePlace;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerAdapter = new RecyclerAdapter(this, new ArrayList<NicePlace>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
