//package com.meorient.phonecall.configuration.oauth;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.meorient.phonecall.pojo.user.User;
//
///**
// * @功能:
// * @项目名:phonecall
// * @作者:chuxu
// * @日期:2019年4月10日上午9:55:19
// */
//public class UserDetail implements UserDetails{
//	/** UID */
//	private static final long serialVersionUID = 3774546984718528233L;
//	
//	/** pc项目User*/
//	private User user;
//	
//	public UserDetail(User user) {
//		this.user = user;
//	}
//	
//	/**
//	 * 方法重写
//	 */ 
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		SimpleGrantedAuthority s = new SimpleGrantedAuthority("USER");
//		List<SimpleGrantedAuthority> l = new ArrayList<SimpleGrantedAuthority>();
//		l.add(s);
//		return l;
////		return user.getAuthoritiyList();
//	}
//
//	/**
//	 * 返回用户密码
//	 */ 
//	@Override
//	public String getPassword() {
//		// return user.getPassword();
//		return "123";
//	}
//
//	/**
//	 * 返回用户姓名
//	 */ 
//	@Override
//	public String getUsername() {
//		return user.getName();
//	}
//
//	/**
//	 * 用户是否过期
//	 */ 
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	/**
//	 * 是否没有被锁住
//	 */ 
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	/**
//	 * 凭证是否过期
//	 */ 
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	/**
//	 * 是否可用
//	 */ 
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//}
