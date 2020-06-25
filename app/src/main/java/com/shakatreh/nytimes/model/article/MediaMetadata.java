package com.shakatreh.nytimes.model.article;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class MediaMetadata implements Parcelable {
    @SerializedName("format")
    private String format;
    @SerializedName("height")
    private Long height;
    @SerializedName("width")
    private Long width;
    @SerializedName("url")
    private String url;


    protected MediaMetadata(Parcel in) {
        format = in.readString();
        if (in.readByte() == 0) {
            height = null;
        } else {
            height = in.readLong();
        }
        if (in.readByte() == 0) {
            width = null;
        } else {
            width = in.readLong();
        }
        url = in.readString();
    }

    public static final Creator<MediaMetadata> CREATOR = new Creator<MediaMetadata>() {
        @Override
        public MediaMetadata createFromParcel(Parcel in) {
            return new MediaMetadata(in);
        }

        @Override
        public MediaMetadata[] newArray(int size) {
            return new MediaMetadata[size];
        }
    };

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(format);
        if (height == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(height);
        }
        if (width == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(width);
        }
        dest.writeString(url);
    }
}
