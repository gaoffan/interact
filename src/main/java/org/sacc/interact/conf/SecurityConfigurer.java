package org.sacc.interact.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sacc.interact.pojo.Result;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaofan
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    private static final String[] NO_AUTH_LIST = {
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/register"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors()
                .and().formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("email")
                .failureHandler(new failureHandler()).successHandler(new successHandler()).permitAll()
                .and().exceptionHandling().authenticationEntryPoint(new authEntryPoint()).accessDeniedHandler(new deniedHandler())
                .and().logout().logoutUrl("/logout").permitAll()
                .and().authorizeRequests().antMatchers(NO_AUTH_LIST).permitAll()
                .and().authorizeRequests().anyRequest().authenticated();



    }
    class authEntryPoint implements AuthenticationEntryPoint{
        @Override
        public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
            Result result = new Result();
            result.setCode(403);
            result.setMessage("未登录");
            httpServletResponse.getOutputStream().write(new ObjectMapper().writeValueAsBytes(result));
        }
    }
    class deniedHandler implements AccessDeniedHandler{
        @Override
        public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
            Result result = new Result();
            result.setCode(403);
            result.setMessage("抱歉，你当前的身份无权访问");
            httpServletResponse.getOutputStream().write(new ObjectMapper().writeValueAsBytes(result));
        }
    }
    class successHandler implements AuthenticationSuccessHandler{
        @Override
        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            Result result = new Result();
            result.setCode(200);
            result.setMessage("登录成功");
            httpServletResponse.getOutputStream().write(new ObjectMapper().writeValueAsBytes(result));
        }
    }
    class failureHandler implements AuthenticationFailureHandler {
        @Override
        public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
            Result result = new Result();
            result.setCode(400);
            result.setMessage(e.getMessage());
            httpServletResponse.getOutputStream().write(new ObjectMapper().writeValueAsBytes(result));
        }
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
