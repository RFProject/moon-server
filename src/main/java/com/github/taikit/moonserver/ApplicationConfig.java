package com.github.taikit.moonserver;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class ApplicationConfig implements ServerApplicationConfig {
  @Override
  public Set<ServerEndpointConfig> getEndpointConfigs(
      Set<Class<? extends Endpoint>> endpointClasses) {
    return new HashSet<ServerEndpointConfig>();
  }

  @Override
  public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
    Set<Class<?>> clazzs = new HashSet<>();
    clazzs.add(MoonService.class);
    return clazzs;
  }
}
