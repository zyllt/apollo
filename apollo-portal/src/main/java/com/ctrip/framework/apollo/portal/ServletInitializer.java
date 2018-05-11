package com.ctrip.framework.apollo.portal;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * 功能：web
 *
 * @author zengyuan on 2018/5/11.
 * @see
 */
public class ServletInitializer extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(PortalApplication.class);
  }

}
