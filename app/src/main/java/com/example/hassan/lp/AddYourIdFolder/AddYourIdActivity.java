package com.example.hassan.lp.AddYourIdFolder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.example.hassan.lp.R;

public class AddYourIdActivity extends AppCompatActivity {
    Toolbar toolbar; //TOOLBAR K LYE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_your_id);


       /* toolbar = this.<Toolbar>findViewById(R.id.toobarMyCource); //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add your ID");*/
        //  ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("sub title here");
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }
}
