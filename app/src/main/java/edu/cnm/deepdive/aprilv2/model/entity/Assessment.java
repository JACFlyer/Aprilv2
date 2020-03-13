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


@Entity(
    foreignKeys = @ForeignKey(
        entity = ClientProfile.class,
        parentColumns = "client_id",
        childColumns = "client_id",
        onDelete = ForeignKey.CASCADE
    ),

    indices = @Index(value = "assessment_id", unique = true)

)

public class Assessment {

  public static long getAssessmentId;
  @ColumnInfo(name = "assessment_id")
  @PrimaryKey(autoGenerate = true)
  private long id;


  @ColumnInfo(name = "client_id")
  private long clientId;


  @ColumnInfo(name = "assessment_type")
  public AssessmentType assessmentType;



  @NonNull
  private Date timestamp = new Date();




  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getClientId() {
    return clientId;
  }

  public void setClientId(long clientId) {
    this.clientId = clientId;
  }

  public AssessmentType getAssessmentType() {
    return assessmentType;
  }

  public void setAssessmentType(
      AssessmentType assessmentType) {
    this.assessmentType = assessmentType;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public void setAssessmentId(long assessmentId) {

  }

  public enum AssessmentType {
    LABOR,
    FETAL_CONDITION;

    @TypeConverter
    public static AssessmentType fromInteger(Integer value) {
      return (value != null) ? AssessmentType.values()[value] : null;
    }

    @TypeConverter
    public static Integer toInteger (AssessmentType value) {
      return (value != null) ? value.ordinal() : null;
    }
  }

}





