package com.github.taikit.moonserver;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/flush")
public class MoonService {
  @OnMessage
  public void flushLights(String message, Session session, boolean last) {
    try {
      session.getBasicRemote().sendText(message, last);
    } catch (IOException e) {
      // FIXME
    }
  }
}
