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
		Object object=  session.getAttribute("userinfo");
	if(object!=null){
		Userinfo3 userInfo=(Userinfo3) object;
		if(userInfo.getuAdmin().equals("π‹¿Ì‘±")){
			arg2.doFilter(arg0, arg1);
		}
		else{
         resp.sendRedirect("/S4SSMManager/UserInfo_needLogin.action");
		}
	}
	else{
		resp.sendRedirect("/S4SSMManager/UserInfo_needLogin.action");
	}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
