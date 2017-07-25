package com.csing1s.news2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Csing1s on 11/15/2016.
 */
public class NewsData implements Parcelable {
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

    public static Creator<NewsData> getCREATOR() {
        return CREATOR;
    }



      NewsData(){};

    public String getImage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }

    protected NewsData(Parcel in) {
        title = in.readString();
        description = in.readString();
        url = in.readString();
        image = in.readString();
    }

    public static final Creator<NewsData> CREATOR = new Creator<NewsData>() {
        @Override
        public NewsData createFromParcel(Parcel in) {
            return new NewsData(in);
        }

        @Override
        public NewsData[] newArray(int size) {
            return new NewsData[size];
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