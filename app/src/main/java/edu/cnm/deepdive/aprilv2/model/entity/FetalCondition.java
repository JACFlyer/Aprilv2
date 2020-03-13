package edu.cnm.deepdive.aprilv2.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;


@Entity(
    foreignKeys = @ForeignKey(
        entity = Assessment.class,
        parentColumns = "assessment_id",
        childColumns = "assessment_id",
        onDelete = ForeignKey.CASCADE
    )
)
public class FetalCondition {

  @ColumnInfo(name = "fetal_id")
  @PrimaryKey(autoGenerate = true)
  private long id;


  @ColumnInfo(name = "assessment_id")
  private long assessmentId;



  @NonNull
  @ColumnInfo(name = "fhr")
  private int fhr;


  @NonNull
  private Date timestamp = new Date();




  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAssessmentId() {
    return assessmentId;
  }

  public void setAssessmentId(long assessmentId) {
    this.assessmentId = assessmentId;
  }


  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }


  public int getFhr() {
    return fhr;
  }

  public void setFhr(int fhr) {
    this.fhr = fhr;
  }
}





