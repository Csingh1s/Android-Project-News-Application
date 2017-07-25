package com.csing1s.news2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class Main5Activity extends ListActivity{
    private Sports[] mNewsDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Intent intent = getIntent();
        Parcelable[]  mparcelabel = intent.getParcelableArrayExtra(MainActivity.SPORTS);

        mNewsDatas = Arrays.copyOf(mparcelabel,mparcelabel.length,Sports[].class);

        sportsAdaptor mAdapter = new sportsAdaptor(this,mNewsDatas);

        setListAdapter(mAdapter);



    }
}
