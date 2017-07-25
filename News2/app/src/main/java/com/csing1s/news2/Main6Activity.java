package com.csing1s.news2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class Main6Activity extends ListActivity {
    private Timesofindia[] mNewsDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Intent intent = getIntent();
        Parcelable[]  mparcelabel = intent.getParcelableArrayExtra(MainActivity.TIMES);

        mNewsDatas = Arrays.copyOf(mparcelabel,mparcelabel.length,Timesofindia[].class);

        Timesofindaadaptor mAdapter = new Timesofindaadaptor(this,mNewsDatas);

        setListAdapter(mAdapter);

    }
}
