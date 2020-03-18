package edu.cnm.deepdive.aprilv2.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;


@Entity(inheritSuperIndices = true)
public class FetalHeartRate extends Assessment {

  @ColumnInfo(name = "fetal_id")
  @PrimaryKey(autoGenerate = true)
  private long id;


  @NonNull
  @ColumnInfo(name = "fhr")
  private int fhr;


  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }


  public int getFhr() {
    return fhr;
  }

  public void setFhr(int fhr) {
    this.fhr = fhr;
  }
}





