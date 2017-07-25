package com.csing1s.news2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chand on 1/6/2017.
 */
class customAdapter extends BaseAdapter {

int img[];
    MainActivity mainActivity;
    LayoutInflater layoutInflater= null;
    public customAdapter(MainActivity mainActivity,int img[])
    { this.img = img;
        this.mainActivity =mainActivity;
        layoutInflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowview=layoutInflater.inflate(R.layout.item,null);
        ImageView imageView = (ImageView) rowview.findViewById(R.id.itemimage);
        imageView.setImageResource(img[position]);
        return rowview;
    }
}


