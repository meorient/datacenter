package com.meorient.phonecall.controller.map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meorient.phonecall.pojo.amap.Amap;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年5月7日上午11:08:18
 */
@RestController
public class amapController {
	
	private String key = "9695d122e73e10b3bda678ddb930fca8";
	
	@GetMapping
	@RequestMapping("v1/amap/:address")
	public void getLocaition(HttpServletRequest request, String key , Amap amap) {
		
	}
}
