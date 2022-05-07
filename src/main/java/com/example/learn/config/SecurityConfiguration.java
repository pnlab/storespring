//package com.example.learn.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.RememberMeServices;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.web.filter.CorsFilter;
//import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@Import(SecurityProblemSupport.class)
//public class SecurityConfiguration {
//
//
//    private final RememberMeServices rememberMeServices;
//
//    private final CorsFilter corsFilter;
//    private final SecurityProblemSupport problemSupport;
//
//    public SecurityConfiguration(
//            RememberMeServices rememberMeServices,
//            CorsFilter corsFilter,
//
//            SecurityProblemSupport problemSupport
//    ) {
//        this.rememberMeServices = rememberMeServices;
//        this.corsFilter = corsFilter;
//        this.problemSupport = problemSupport;
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**").antMatchers("/swagger-ui/**").antMatchers("/test/**");
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http
//                .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
//                .addFilterBefore(corsFilter, CsrfFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(problemSupport)
//                .accessDeniedHandler(problemSupport)
//                .and()
//                .rememberMe()
//                .rememberMeServices(rememberMeServices)
//                .rememberMeParameter("remember-me")
//                .key("KEY")
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/api/authentication")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/api/logout")
//                .permitAll()
//                .and()
//                .headers()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/authenticate").permitAll()
//                .antMatchers("/api/register").permitAll()
//                .antMatchers("/api/activate").permitAll()
//                .antMatchers("/api/account/reset-password/init").permitAll()
//                .antMatchers("/api/account/reset-password/finish").permitAll()
//                .antMatchers("/api/admin/**").hasAuthority(AuthoritiesConstants.ADMIN)
//                .antMatchers("/api/**").authenticated()
//                .antMatchers("/management/health").permitAll()
//                .antMatchers("/management/health/**").permitAll()
//                .antMatchers("/management/info").permitAll()
//                .antMatchers("/management/prometheus").permitAll()
//                .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN);
//        return http.build();
//        // @formatter:on
//    }
//}
