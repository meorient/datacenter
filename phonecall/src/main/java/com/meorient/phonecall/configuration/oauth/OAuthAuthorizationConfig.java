//package com.meorient.phonecall.configuration.oauth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
//
///**
// * @功能:
// * @项目名:phonecall
// * @作者:chuxu
// * @日期:2019年4月9日下午4:30:46
// */
//@Configuration
//@EnableAuthorizationServer
//public class OAuthAuthorizationConfig extends AuthorizationServerConfigurerAdapter {
//    @Autowired
//    private AuthenticationManager authenticationManager;
// 
//    @Autowired
//    private UserDetailsService userDetailsService;
// 
//    @Autowired
//    private TokenStore tokenStore;
// 
//    @Bean
//    public TokenStore tokenStore() {
//    	return new InMemoryTokenStore();
////    	return new RedisTokenStore();
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("test")//客户端ID
//                .authorizedGrantTypes("password", "refresh_token","authorization_code")//设置验证方式
//                .scopes("read", "write")
//                .secret("123456")
//                .accessTokenValiditySeconds(10000) //token过期时间0
//                .refreshTokenValiditySeconds(10000); //refresh过期时间
//    }
// 
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService); //配置userService 这样每次认证的时候会去检验用户是否锁定，有效等
//    }
//}
