package edu.cnm.deepdive.aprilv2.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;


@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Assessment.class,
            parentColumns = "assessment_id",
            childColumns = "assessment_id"
        )
    }
)
public class Labor {

  @ColumnInfo(name = "labor_id")
  @PrimaryKey(autoGenerate = true)
  private long laborId;


  @ColumnInfo(name = "assessment_id", index = true)
  private long assessmentId;


  @ColumnInfo(name = "rupture_of_membranes")
  private boolean ruptureOfMembranes;


  @ColumnInfo(name = "contraction")
  private boolean contraction;


  @NonNull
  private Date timestamp = new Date();

  public void setTimestamp(@NonNull Date timestamp) {
    this.timestamp = timestamp;
  }

  public long getLaborId() {
    return laborId;
  }

  public void setLaborId(long laborId) {
    this.laborId = laborId;
  }

  @NonNull
  public Date getTimestamp() {
    return timestamp;
  }

  public boolean isRuptureOfMembranes() {
    return ruptureOfMembranes;
  }

  public void setRuptureOfMembranes(boolean ruptureOfMembranes) {
    this.ruptureOfMembranes = ruptureOfMembranes;
  }

  public boolean isContraction() {
    return contraction;
  }

  public void setContraction(boolean contraction) {
    this.contraction = contraction;
  }

  public long getAssessmentId() {
    return assessmentId;
  }

  public void setAssessmentId(long assessmentId) {
    this.assessmentId = assessmentId;
  }
}
