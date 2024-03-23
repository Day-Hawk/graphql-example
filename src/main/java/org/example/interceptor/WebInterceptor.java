package org.example.interceptor;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;


/**
 * Class to hook in front and between operation.
 */
@Component
@Log4j2
public final class WebInterceptor implements HandlerInterceptor {
  private final static @NotNull String TIMER_FIEL = "process-begin";

  @PostConstruct
  private void init() {
    log.info("Created WebInterceptor instance to monitor and coordinate rest requests.");
  }

  /**
   * Before controller handle.
   */
  @Override
  public boolean preHandle(@NotNull final HttpServletRequest request,
                           @NotNull final HttpServletResponse response,
                           @NotNull final Object handler) {
    //Set current timestamp as start
    request.setAttribute(TIMER_FIEL, System.currentTimeMillis());

    return true;
  }

  /**
   * After complete process.
   */
  @Override
  public void afterCompletion(@NotNull final HttpServletRequest request,
                              @NotNull final HttpServletResponse response,
                              @NotNull final Object handler,
                              @Nullable final Exception exception) {
    final long duration = System.currentTimeMillis()-(long) request.getAttribute(TIMER_FIEL);

    //Log
    log.info("[{}]('{}') took {} ms. (status={})",
        request.getMethod(),
        request.getRequestURI(),
        duration,
        response.getStatus());
  }
}
