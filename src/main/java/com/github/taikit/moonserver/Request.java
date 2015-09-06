package com.github.taikit.moonserver;

public class Request {
  private String action;

  public Request(String action) {
    this.action = action;
  }

  public String getAction() {
    return action;
  }
}
