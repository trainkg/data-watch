package com.zsq.watch.resource;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsq.euser.SimpleLoginForm;
import com.zsq.modelbase.Result;
import com.zsq.watch.user.IWatchUserService;

@Controller
@RequestMapping("datawc")
public class UserResource {
	
	@Autowired
	private IWatchUserService seuser;
	/**
	 * 人员登陆
	 * @param loginForm
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Result systemLogin(@RequestBody SimpleLoginForm loginForm){
		 Result r = new Result();
		 r.setStatus("200");
		 r.setMessage("success");
		 try {
			seuser.login(loginForm.getUserName(), loginForm.getPassword());
		 } catch (AuthenticationException e) {
			r.setStatus("503");
			r.setMessage("无效的账户");
		 }
		 return r;
	}
}
