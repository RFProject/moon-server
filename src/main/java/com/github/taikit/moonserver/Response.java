package com.github.taikit.moonserver;

public class Response {
  private String status;
  private String message;

  public static Response ok() {
    return new Response("ok", null);
  }

  public static Response error(String message) {
    return new Response("error", message);
  }

  public Response(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
