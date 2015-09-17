package com.zsq.watch.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public Result systemLogin(@ModelAttribute SimpleLoginForm loginForm){
		 Result r = new Result();
		 r.setStatus("200");
		 r.setMessage("success");
		 return r;
	}
}
