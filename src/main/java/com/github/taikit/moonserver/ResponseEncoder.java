package com.github.taikit.moonserver;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ResponseEncoder implements Encoder.Text<Response> {
  @Override
  public void init(EndpointConfig config) {
  }

  @Override
  public void destroy() {
  }

  @Override
  public String encode(Response response) {
    JsonObjectBuilder responseJsonBuider
        = Json.createObjectBuilder().add("status", response.getStatus());
    if (response.getMessage() != null) {
      responseJsonBuider = responseJsonBuider.add("message", response.getMessage());
    }
    return responseJsonBuider.build().toString();
  }
}
