package com.ctrip.framework.apollo.portal.spi.configuration;

import com.ctrip.framework.apollo.portal.spi.LogoutHandler;
import com.ctrip.framework.apollo.portal.spi.SsoHeartbeatHandler;
import com.ctrip.framework.apollo.portal.spi.UserInfoHolder;
import com.ctrip.framework.apollo.portal.spi.UserService;
import com.ctrip.framework.apollo.portal.spi.defaultimpl.DefaultLogoutHandler;
import com.ctrip.framework.apollo.portal.spi.defaultimpl.DefaultSsoHeartbeatHandler;
import com.ctrip.framework.apollo.portal.spi.springsecurity.SpringSecurityUserInfoHolder;
import com.ctrip.framework.apollo.portal.spi.springsecurity.SpringSecurityUserService;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;


@Configuration
public class AuthConfiguration {

  @Bean
  public SsoHeartbeatHandler defaultSsoHeartbeatHandler() {
    return new DefaultSsoHeartbeatHandler();
  }

  @Bean
  public UserInfoHolder springSecurityUserInfoHolder() {
    return new SpringSecurityUserInfoHolder();
  }

  @Bean
  public LogoutHandler logoutHandler() {
    return new DefaultLogoutHandler();
  }

  @Bean
  public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource datasource) {
    JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
    userDetailsService.setDataSource(datasource);

    return userDetailsService;
  }

  @Bean
  public UserService springSecurityUserService() {
    return new SpringSecurityUserService();
  }

}
