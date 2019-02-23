package com.kintopp.pablo.igdbapp.data.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kintopp.pablo.igdbapp.data.model.Cover;
import java.lang.reflect.Type;


import androidx.room.TypeConverter;

public class CoverTypeConverter {

    @TypeConverter
    public Cover fromString(String value) {
        Type type = new TypeToken<Cover>() {
        }.getType();
        Cover cover = new Gson().fromJson(value, type);
        return cover;
    }

    @TypeConverter
    public String toString(Cover cover) {
        return new Gson().toJson(cover);
    }
}
