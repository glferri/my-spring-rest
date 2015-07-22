/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author nat
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  /**
   * This section defines the user accounts which can be used for
   * authentication as well as the roles each user has.
     * @param auth
     * @throws java.lang.Exception
   */
  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication()
      .withUser("user").password("user").roles("USER").and()
      .withUser("luca").password("luca").roles("USER", "ADMIN");
  }

  /**
   * This section defines the security policy for the app.
   * - BASIC authentication is supported (enough for this REST-based demo)
   * - /employees is secured using URL security shown below
   * - CSRF headers are disabled since we are only testing the REST interface,
   *   not a web one.
   *
   * NOTE: GET is not shown which defaults to permitted.
     * @param http
     * @throws java.lang.Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .httpBasic().and()
      .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/todos").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/todos/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/todos/**").hasRole("ADMIN").and()
      .csrf().disable();
  }
}