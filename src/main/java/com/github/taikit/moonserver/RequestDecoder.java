package com.github.taikit.moonserver;

import java.io.StringReader;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class RequestDecoder implements Decoder.Text<Request> {
  private Logger logger;

  @Override
  public void init(EndpointConfig config) {
    logger = Logger.getLogger(RequestDecoder.class.getName());
  }

  @Override
  public void destroy() {
  }

  @Override
  public Request decode(String requestText) {
    try {
      JsonReader reader = Json.createReader(new StringReader(requestText));
      JsonObject requestJson = reader.readObject();
      return new Request(requestJson.getString("action"));
    } catch (Exception e) {
      logger.severe(e.toString());
      return new Request("unknown");
    }
  }

  @Override
  public boolean willDecode(String requestText) {
    return true;
  }
}
