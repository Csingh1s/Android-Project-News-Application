package com.csing1s.news2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chand on 1/13/2017.
 */

public class Timesofindia implements Parcelable {
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

    public static Creator<Timesofindia> getCREATOR() {
        return CREATOR;
    }



    Timesofindia(){};

    public String getImage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }

    protected Timesofindia(Parcel in) {
        title = in.readString();
        description = in.readString();
        url = in.readString();
        image = in.readString();
    }

    public static final Creator<Timesofindia> CREATOR = new Creator<Timesofindia>() {
        @Override
        public Timesofindia createFromParcel(Parcel in) {
            return new Timesofindia(in);
        }

        @Override
        public Timesofindia[] newArray(int size) {
            return new Timesofindia[size];
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