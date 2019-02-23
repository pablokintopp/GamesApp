package com.kintopp.pablo.igdbapp.data.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kintopp.pablo.igdbapp.data.converter.CoverTypeConverter;
import com.kintopp.pablo.igdbapp.data.converter.GenreListTypeConverter;

import androidx.room.Entity;
import androidx.room.TypeConverters;

@Entity(primaryKeys = ("id"))
public class Game implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("category")
    @Expose
    private Integer category;
    @SerializedName("cover")
    @Expose
    @TypeConverters(CoverTypeConverter.class)
    private Cover cover;
    @SerializedName("first_release_date")
    @Expose
    private Integer firstReleaseDate;
    @SerializedName("genres")
    @Expose
    @TypeConverters(GenreListTypeConverter.class)
    private List<Genre> genres;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("total_rating")
    @Expose
    private Double totalRating;
    @SerializedName("total_rating_count")
    @Expose
    private Integer totalRatingCount;
    public final static Parcelable.Creator<Game> CREATOR = new Creator<Game>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        public Game[] newArray(int size) {
            return (new Game[size]);
        }

    };

    protected Game(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.category = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cover = ((Cover) in.readValue((Cover.class.getClassLoader())));
        this.firstReleaseDate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.genres, (Genre.class.getClassLoader()));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.summary = ((String) in.readValue((String.class.getClassLoader())));
        this.totalRating = ((Double) in.readValue((Double.class.getClassLoader())));
        this.totalRatingCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Integer getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(Integer firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Double totalRating) {
        this.totalRating = totalRating;
    }

    public Integer getTotalRatingCount() {
        return totalRatingCount;
    }

    public void setTotalRatingCount(Integer totalRatingCount) {
        this.totalRatingCount = totalRatingCount;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(category);
        dest.writeValue(cover);
        dest.writeValue(firstReleaseDate);
        dest.writeList(genres);
        dest.writeValue(name);
        dest.writeValue(summary);
        dest.writeValue(totalRating);
        dest.writeValue(totalRatingCount);
    }

    public int describeContents() {
        return 0;
    }

}
