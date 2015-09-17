package com.zsq.watch.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsq.euser.SimpleLoginForm;
import com.zsq.modelbase.Result;

@Controller
@RequestMapping("datawc")
public class UserResource {
	
	/**
	 * 人员登陆
	 * @param loginForm
	 * @return
	 */
	@RequestMapping("/login")
	public Result systemLogin(@ModelAttribute SimpleLoginForm loginForm){
		 Result r = new Result();
		 return r;
	}
}
