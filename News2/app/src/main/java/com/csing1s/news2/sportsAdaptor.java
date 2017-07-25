package com.csing1s.news2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by chand on 1/13/2017.
 */

public class sportsAdaptor extends BaseAdapter {
    private Sports[] mNewsDatas;
    private Context mcontext1;
    public sportsAdaptor(Context context,Sports[]data){
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
            Convertview = LayoutInflater.from(mcontext1).inflate(R.layout.sport,null);
            holder = new ViewHolder();
            holder.mTitle= (TextView) Convertview.findViewById(R.id.Titlebar4);
            holder.mDescription= (TextView) Convertview.findViewById(R.id.Descriptionlabel4);
            holder.murl = (TextView) Convertview.findViewById(R.id.textView4);
            holder.mimage= (ImageView) Convertview.findViewById(R.id.imageViewnews4);


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
        Sports madapter = mNewsDatas[postion];
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