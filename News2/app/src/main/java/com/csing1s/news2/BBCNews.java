package com.csing1s.news2;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chand on 1/11/2017.
 */

public class BBCNews implements Parcelable {
    private String title1;
    private String description1;
    private String image1;
    private String url1;

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url) {
        this.url1 = url;
    }

    public static Creator<BBCNews> getCREATOR() {
        return CREATOR;
    }



    BBCNews(){};

    public String getImage1() {
        return image1;
    }

    public void setimage1(String image) {
        this.image1 = image;
    }

    protected BBCNews(Parcel in) {
        title1 = in.readString();
        description1 = in.readString();
        url1 = in.readString();
        image1 = in.readString();
    }

    public static final Creator<BBCNews> CREATOR = new Creator<BBCNews>() {
        @Override
        public BBCNews createFromParcel(Parcel in) {
            return new BBCNews(in);
        }

        @Override
        public BBCNews[] newArray(int size) {
            return new BBCNews[size];
        }
    };

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title) {
        this.title1 = title;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description) {
        this.description1 = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title1);
        parcel.writeString(description1);
        parcel.writeString(url1);
        parcel.writeString(image1);
    }

}