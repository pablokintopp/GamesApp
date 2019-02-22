package com.kintopp.pablo.igdbapp.data;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;

@Entity(primaryKeys = ("id"))
public class Game implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("category")
    @Expose
    private Integer category;
    @SerializedName("cover")
    @Expose
    private Integer cover;
    @SerializedName("genres")
    @Expose
    private List<Integer> genres = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("first_release_date")
    @Expose
    private Integer firstReleaseDate;
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

    }
            ;

    protected Game(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.category = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cover = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.genres, (java.lang.Integer.class.getClassLoader()));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.firstReleaseDate = ((Integer) in.readValue((Integer.class.getClassLoader())));
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

    public Integer getCover() {
        return cover;
    }

    public void setCover(Integer cover) {
        this.cover = cover;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(Integer firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
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
        dest.writeList(genres);
        dest.writeValue(name);
        dest.writeValue(firstReleaseDate);
        dest.writeValue(totalRating);
        dest.writeValue(totalRatingCount);
    }

    public int describeContents() {
        return 0;
    }



}
