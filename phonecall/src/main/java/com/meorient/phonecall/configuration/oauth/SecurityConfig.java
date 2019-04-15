//package com.meorient.phonecall.configuration.oauth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
///**
// * @功能:
// * @项目名:phonecall
// * @作者:chuxu
// * @日期:2019年3月22日下午3:56:36
// */
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired 
//	private UserDetailsService userDetailService;
//	
//	@Override
//	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 // enable in memory based authentication with a user named
////	 	auth.inMemoryAuthentication()
////	 	.withUser("user").password("password").roles("USER")
////	 	.and()
////	 	.withUser("admin").password("password").roles("USER", "ADMIN");
//	 	auth.userDetailsService(userDetailService);
//	 }
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		 http.authorizeRequests().antMatchers("/**").authenticated()
//         .anyRequest().authenticated();
//	}
//	 
//	 @Bean
//	 @Override
//	 public UserDetailsService userDetailsServiceBean() throws Exception {
//	 	return super.userDetailsServiceBean();
//	 }
//	 
//	 @Bean(name="myAuthenticationManager")
//	 public AuthenticationManager authenticationManagerBean() throws Exception {
//	     return super.authenticationManagerBean();
//	 }
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/**");
//	}
//}
