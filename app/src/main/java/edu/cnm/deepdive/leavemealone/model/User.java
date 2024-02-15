package edu.cnm.deepdive.leavemealone.model;

import java.util.List;

public class User {

  private String name;  // Actual name of user, not username from login
  private String password; // is password necessary with the login page already created?

  private int chirpType; // Not sure about primitive type
  private int alarmType; // Not sure about primitive type

  private List<Alert> alerts;

  private User() {
    // TODO: 2/12/2024 Add constructor
  }

  public void initUser(){
    // TODO: 2/12/2024 write user information initialization method
  }

  public void editUser(){
    // TODO: 2/12/2024 write user information edit method
  }

  public String getName() {
    // TODO: 2/12/2024 Remove if used
    return name;
  }

  public String getPassword() {
    // TODO: 2/12/2024 remove if used
    return password;
  }

  public int getChirpType() {
    // TODO: 2/12/2024 remove if used
    return chirpType;
  }

  public int getAlarmType() {
    // TODO: 2/12/2024 remove if used
    return alarmType;
  }
}
