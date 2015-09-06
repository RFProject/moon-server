package com.github.taikit.moonserver;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(
    value = "/flush",
    decoders = RequestDecoder.class,
    encoders = ResponseEncoder.class)
public class MoonService {
  @OnMessage
  public Response flushLights(Request request, Session session) {
    if (request.getAction() == "unknown") {
      return Response.error("invalid request");
    }
    return Response.ok();
  }
}
