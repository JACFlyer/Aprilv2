package edu.cnm.deepdive.aprilv2.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public abstract class Assessment implements Comparable<Assessment> {

  @NonNull
  @ColumnInfo(index = true)
  protected Date timestamp = new Date();

  public abstract long getId();

  public abstract void setId(long id);


  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public int compareTo(Assessment other) {
    return -timestamp.compareTo(other.timestamp);
  }
}





