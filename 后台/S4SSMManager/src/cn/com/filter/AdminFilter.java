package cn.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.pojo.*;

/**
 * 权限过滤器
 * 
 * @author lej
 */
public class AdminFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) arg0;
		 HttpServletResponse resp=(HttpServletResponse) arg1;
		 HttpSession session=req.getSession();
		Object object=  session.getAttribute("userinfo");  //获取session中的用户对象并检验是否为空
	if(object!=null){
		Userinfo3 userInfo=(Userinfo3) object;
		if(userInfo.getuAdmin().equals("管理员")){ //检验用户权限
			arg2.doFilter(arg0, arg1); //为管理员则通过
		}
		else{
         resp.sendRedirect("/S4SSMManager/UserInfo_needLogin.action");
		}
	}
	else{
		resp.sendRedirect("/S4SSMManager/UserInfo_needLogin.action"); //否则转向登录页面
	}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
