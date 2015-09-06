package com.github.taikit.moonserver;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(
    value = "/flush",
    decoders = RequestDecoder.class,
    encoders = {RequestEncoder.class, ResponseEncoder.class})
public class MoonService {
  private static Set<Session> activeSessions
      = Collections.synchronizedSet(new HashSet<Session>());

  @OnOpen
  public void registerSession(Session session) {
    activeSessions.add(session);
  }

  @OnClose
  public void closeSession(Session session) {
    activeSessions.remove(session);
  }

  @OnMessage
  public void flushLights(Request request, Session session) {
    try {
      if (request.getAction().equals("flush")) {
        for (Session activeSession : activeSessions) {
          activeSession.getAsyncRemote().sendObject(request);
        }
      } else {
        session.getBasicRemote().sendObject(Response.error("invalid request"));
      }
    } catch (Exception e) {
      Logger.getLogger(MoonService.class.getName()).info(e.toString());
    }
  }
}
