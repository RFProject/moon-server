package com.github.taikit.moonserver;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class RequestEncoder implements Encoder.Text<Request> {
  @Override
  public void init(EndpointConfig config) {
  }

  @Override
  public void destroy() {
  }

  @Override
  public String encode(Request request) {
    JsonObjectBuilder requestJsonBuider
        = Json.createObjectBuilder().add("action", request.getAction());
    return requestJsonBuider.build().toString();
  }
}
