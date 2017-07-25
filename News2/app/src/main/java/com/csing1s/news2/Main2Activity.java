package com.csing1s.news2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends ListActivity {
 private NewsData[]mNewsDatas;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
       Parcelable[]  mparcelabel = intent.getParcelableArrayExtra(MainActivity.NEWS_FORCASR);

        mNewsDatas = Arrays.copyOf(mparcelabel,mparcelabel.length,NewsData[].class);

        NewsAdapter mAdapter = new NewsAdapter(this,mNewsDatas);

        setListAdapter(mAdapter);

    }


}
