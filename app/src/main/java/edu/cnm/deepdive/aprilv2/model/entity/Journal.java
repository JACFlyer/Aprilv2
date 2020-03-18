package edu.cnm.deepdive.aprilv2.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(inheritSuperIndices = true)
public class Journal extends Assessment {

  @ColumnInfo(name = "journal_id")
  @PrimaryKey(autoGenerate = true)
  private long id;
  private String notes;

  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
