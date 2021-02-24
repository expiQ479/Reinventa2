package com.doubletrouble.covidrun.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.TypeConverter;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

class DateConverter {

    @TypeConverter
    public static Date toDate(Long dateLong){
        return dateLong == null ? null: new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date){
        return date == null ? null : date.getTime();
    }
}

@Entity(tableName = "planes_usuario", primaryKeys = {"planId", "userId", "date"}, indices = {@Index(value = {"planId", "userId", "date"}, unique = true)})
public class Planes_Usuario {

    public long planId;
    @NonNull
    public String userId;
    public long date;

    public Planes_Usuario(long planId, @NotNull String userId) {
        this.planId = planId;
        this.userId = userId;
        this.date = DateConverter.fromDate(java.util.Calendar.getInstance().getTime());
    }

}

