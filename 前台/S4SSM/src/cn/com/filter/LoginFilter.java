package cn.com.filter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 权限过滤器
 * 
 * @author lej
 */
public class LoginFilter implements Filter {

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
		 if(session.getAttribute("userinfo")!=null){ //获取session中的用户对象并检验是否为空
			 arg2.doFilter(req, resp); //不为空则通过
		 }else{
		 
		
		
		 req.getRequestDispatcher("/CarInfo.action").forward(req, resp); //否则转向首页
		 }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
