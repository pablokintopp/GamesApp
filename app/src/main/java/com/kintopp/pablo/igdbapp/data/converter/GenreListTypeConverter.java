package com.kintopp.pablo.igdbapp.data.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kintopp.pablo.igdbapp.data.model.Genre;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class GenreListTypeConverter {

    @TypeConverter
    public List<Genre> fromString(String value) {
        Type type = new TypeToken<Genre>() {
        }.getType();
        List<Genre> genres = new Gson().fromJson(value, type);
        return genres;
    }

    @TypeConverter
    public String fromList(List<Genre> genres) {
        return new Gson().toJson(genres);
    }
}
