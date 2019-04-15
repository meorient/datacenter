//package com.meorient.phonecall.configuration.oauth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.meorient.phonecall.service.iservice.IUserService;
//
///**
// * @功能:
// * @项目名:phonecall
// * @作者:chuxu
// * @日期:2019年4月10日上午9:28:40
// */
//@Service
//public class OAuthUserDetailsService implements UserDetailsService{
//	
//	@Autowired
//	private IUserService userService;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		com.meorient.phonecall.pojo.user.User user = new com.meorient.phonecall.pojo.user.User();
//		user.setName(username);
//		user = userService.selectUnique(user);
//		UserDetail d = new UserDetail(user);
//		return d;
//	}
//}
