package com.shakatreh.nytimes.model.article;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article implements Parcelable {

    @SerializedName("abstract")
    private String _abstract;
    @SerializedName("adx_keywords")
    private String adxKeywords;
    @SerializedName("asset_id")
    private Long assetId;
    @SerializedName("byline")
    private String byline;
    @SerializedName("column")
    private Object column;
    @SerializedName("des_facet")
    private Object desFacet;
    @SerializedName("geo_facet")
    private Object geoFacet;
    @SerializedName("id")
    private Long id;
    @SerializedName("media")
    private List<Media> media;
    @SerializedName("org_facet")
    private Object orgFacet;
    @SerializedName("per_facet")
    private Object perFacet;
    @SerializedName("published_date")
    private String publishedDate;
    @SerializedName("section")
    private String section;
    @SerializedName("source")
    private String source;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("views")
    private Long views;

    protected Article(Parcel in) {
        _abstract = in.readString();
        adxKeywords = in.readString();
        if (in.readByte() == 0) {
            assetId = null;
        } else {
            assetId = in.readLong();
        }
        byline = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        media = in.createTypedArrayList(Media.CREATOR);
        publishedDate = in.readString();
        section = in.readString();
        source = in.readString();
        title = in.readString();
        type = in.readString();
        url = in.readString();
        if (in.readByte() == 0) {
            views = null;
        } else {
            views = in.readLong();
        }
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public Object getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(Object desFacet) {
        this.desFacet = desFacet;
    }

    public Object getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(Object geoFacet) {
        this.geoFacet = geoFacet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public Object getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(Object orgFacet) {
        this.orgFacet = orgFacet;
    }

    public Object getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(Object perFacet) {
        this.perFacet = perFacet;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_abstract);
        dest.writeString(adxKeywords);
        if (assetId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(assetId);
        }
        dest.writeString(byline);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeTypedList(media);
        dest.writeString(publishedDate);
        dest.writeString(section);
        dest.writeString(source);
        dest.writeString(title);
        dest.writeString(type);
        dest.writeString(url);
        if (views == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(views);
        }
    }
}
