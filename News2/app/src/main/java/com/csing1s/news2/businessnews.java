package com.csing1s.news2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chand on 1/11/2017.
 */

public class businessnews implements Parcelable {
    private String title;
    private String description;
    private String image;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Parcelable.Creator<businessnews> getCREATOR() {
        return CREATOR;
    }



    businessnews(){};

    public String getImage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }

    protected businessnews(Parcel in) {
        title = in.readString();
        description = in.readString();
        url = in.readString();
        image = in.readString();
    }

    public static final Parcelable.Creator<businessnews> CREATOR = new Parcelable.Creator<businessnews>() {
        @Override
        public businessnews createFromParcel(Parcel in) {
            return new businessnews(in);
        }

        @Override
        public businessnews[] newArray(int size) {
            return new businessnews[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(url);
        parcel.writeString(image);
    }

}
