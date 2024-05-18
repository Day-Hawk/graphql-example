package dev.dotspace.dayhawk.info;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public final class WebInfo {

  @Value("${server.port}")
  private int serverPort;

  @PostConstruct
  public void init() {
    log.info("\n\n\nGraphiql for queries available under: \"http://localhost:{}/graphiql\" \n\n", this.serverPort);
  }
}
