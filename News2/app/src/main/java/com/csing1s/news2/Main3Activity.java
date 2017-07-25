package com.csing1s.news2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

import butterknife.ButterKnife;

public class Main3Activity extends ListActivity {
  private BBCNews[] mNewsDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Parcelable[]  mparcelabel = intent.getParcelableArrayExtra(MainActivity.BBCNEWS);

        mNewsDatas = Arrays.copyOf(mparcelabel,mparcelabel.length,BBCNews[].class);

        BBCNewsAdaptor mAdapter = new BBCNewsAdaptor(this,mNewsDatas);

        setListAdapter(mAdapter);

    }
}
