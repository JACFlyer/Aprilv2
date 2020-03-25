package edu.cnm.deepdive.aprilv2.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * This is the Contraction entity class.
 */
@Entity(inheritSuperIndices = true)
public class Contraction extends Assessment {

  /**
   * Class fields There is no foreign key.
   */
  @ColumnInfo(name = "contraction_id")
  @PrimaryKey(autoGenerate = true)
  private long id;


  private Date start;
  private Date end;
  private int intensity;


  /**
   * Getters and Setters
   *
   * @return
   */
  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public int getIntensity() {
    return intensity;
  }

  public void setIntensity(int intensity) {
    this.intensity = intensity;
  }
}
