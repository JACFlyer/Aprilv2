package edu.cnm.deepdive.aprilv2.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.jar.Attributes.Name;

// Creating PARENT Entity

@Entity(
    indices = {
        @Index(value = "name", unique = true)
    }
)
public class ClientProfile {


  public static long getClientId;
  @ColumnInfo(name = "client_id")
  @PrimaryKey(autoGenerate = true)
  private long clientId;


  @NonNull
  @Expose
  @ColumnInfo(name = "name")
  private String name;


  @NonNull
  @ColumnInfo(name = "date_of_birth")
  private Date dateOfBirth;



  @ColumnInfo(name = "address")
  private String Address;


  @ColumnInfo(name = "phone_number")
  public long phoneNumber;



  public long getClientId() {
    return clientId;
  }

  public void setClientId(long clientId) {
    this.clientId = clientId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}