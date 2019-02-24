package com.kintopp.pablo.igdbapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Cover implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("game")
    @Expose
    private Integer game;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("alpha_channel")
    @Expose
    private Boolean alphaChannel;
    @SerializedName("animated")
    @Expose
    private Boolean animated;
    public final static Parcelable.Creator<Cover> CREATOR = new Creator<Cover>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Cover createFromParcel(Parcel in) {
            return new Cover(in);
        }

        public Cover[] newArray(int size) {
            return (new Cover[size]);
        }

    };

    protected Cover(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.game = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.imageId = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.alphaChannel = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.animated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Cover() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public String getFormatedUrl(){
        String url = "";

        if(this.imageId != null){
            url = "https://images.igdb.com/igdb/image/upload/t_screenshot_med/" + this.imageId + ".jpg";
        }

        return  url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Boolean getAlphaChannel() {
        return alphaChannel;
    }

    public void setAlphaChannel(Boolean alphaChannel) {
        this.alphaChannel = alphaChannel;
    }

    public Boolean getAnimated() {
        return animated;
    }

    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(game);
        dest.writeValue(height);
        dest.writeValue(imageId);
        dest.writeValue(url);
        dest.writeValue(width);
        dest.writeValue(alphaChannel);
        dest.writeValue(animated);
    }

    public int describeContents() {
        return 0;
    }

}