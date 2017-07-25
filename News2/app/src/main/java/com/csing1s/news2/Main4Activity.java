package com.csing1s.news2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class Main4Activity extends ListActivity {
   private businessnews[] mNewsDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        Parcelable[]  mparcelabel = intent.getParcelableArrayExtra(MainActivity.Busssiness);

        mNewsDatas = Arrays.copyOf(mparcelabel,mparcelabel.length,businessnews[].class);

        BussinessAdaptor mAdapter = new BussinessAdaptor(this,mNewsDatas);

        setListAdapter(mAdapter);

    }
    }

