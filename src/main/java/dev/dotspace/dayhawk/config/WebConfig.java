package dev.dotspace.dayhawk.config;

import lombok.extern.log4j.Log4j2;
import dev.dotspace.dayhawk.interceptor.WebInterceptor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
@Log4j2
public final class WebConfig implements WebMvcConfigurer {

  /**
   * {@link WebInterceptor} to hook into rest-controller processing.
   */
  @Autowired
  private WebInterceptor webInterceptor;

  /**
   * There to chain into request.
   */
  @Override
  public void addInterceptors(@NotNull final InterceptorRegistry registry) {
    registry.addInterceptor(this.webInterceptor);
  }
}
