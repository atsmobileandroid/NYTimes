package com.shakatreh.nytimes.model.article;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media implements Parcelable {

    @SerializedName("approved_for_syndication")
    private Long approvedForSyndication;
    @SerializedName("caption")
    private String caption;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("media-metadata")
    private List<MediaMetadata> mediaMetadata;
    @SerializedName("subtype")
    private String subtype;
    @SerializedName("type")
    private String type;

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    protected Media(Parcel in) {
        if (in.readByte() == 0) {
            approvedForSyndication = null;
        } else {
            approvedForSyndication = in.readLong();
        }
        caption = in.readString();
        copyright = in.readString();
        mediaMetadata = in.createTypedArrayList(MediaMetadata.CREATOR);
        subtype = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (approvedForSyndication == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(approvedForSyndication);
        }
        dest.writeString(caption);
        dest.writeString(copyright);
        dest.writeTypedList(mediaMetadata);
        dest.writeString(subtype);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Long getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(Long approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<MediaMetadata> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadata> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
