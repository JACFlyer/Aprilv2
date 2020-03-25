package edu.cnm.deepdive.aprilv2.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This is the journal entity class.
 */
@Entity(inheritSuperIndices = true)
public class Journal extends Assessment {

  /**
   * Class fields there is no foreign key.
   */
  @ColumnInfo(name = "journal_id")
  @PrimaryKey(autoGenerate = true)
  private long id;
  private String note;

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

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
