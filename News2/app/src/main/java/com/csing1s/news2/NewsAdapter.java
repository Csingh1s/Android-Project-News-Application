package com.csing1s.news2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;



/**
 * Created by Csing1s on 11/15/2016.
 */
public  class NewsAdapter extends BaseAdapter {
    private NewsData[] mNewsDatas;
    private Context mcontext1;
    public NewsAdapter(Context context,NewsData[]data){
        mcontext1 =context;
        mNewsDatas=data;}

    @Override
    public int getCount() {
        return mNewsDatas.length;
    }

    @Override
    public Object getItem(int position) {
        return mNewsDatas[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int postion , View Convertview, ViewGroup parent) {

        ViewHolder holder;
        if(Convertview == null)
        {
            Convertview = LayoutInflater.from(mcontext1).inflate(R.layout.newslist,null);
            holder = new ViewHolder();
           holder.mTitle= (TextView) Convertview.findViewById(R.id.Titlebar);
            holder.mDescription= (TextView) Convertview.findViewById(R.id.Descriptionlabel);
           holder.murl = (TextView) Convertview.findViewById(R.id.textView);
            holder.mimage= (ImageView) Convertview.findViewById(R.id.imageViewnews);


/*
           holder.murl.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View view) {

                }
           });
           */

            Convertview.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) Convertview.getTag();
        }
        NewsData madapter = mNewsDatas[postion];
        holder.mTitle.setText(madapter.getTitle());
       holder.mDescription.setText(madapter.getDescription());
        holder.murl.setText(madapter.getUrl());
        Picasso.with(mcontext1).load(madapter.getImage()).into(holder.mimage);

        return Convertview;
    }
    private static class ViewHolder
    {
        TextView mDescription;
        TextView mTitle;
        TextView murl;
        ImageView mimage;

    }
}
/*

 */



