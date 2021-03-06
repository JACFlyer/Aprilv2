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

/**
 * This is the abstract class to which all entity classes reference.
 */
public abstract class Assessment implements Comparable<Assessment> {

  /**
   * Class fields
   */
  @NonNull
  @ColumnInfo(index = true)
  protected Date timestamp = new Date();

  /**
   * Getters and Setters
   *
   * @return
   */
  public abstract long getId();

  public abstract void setId(long id);


  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * This method allows the timestamp of the entity objects to be compared to the timestamp of the
   * abstract class.
   *
   * @param other
   * @return
   */
  @Override
  public int compareTo(Assessment other) {
    return -timestamp.compareTo(other.timestamp);
  }
}





