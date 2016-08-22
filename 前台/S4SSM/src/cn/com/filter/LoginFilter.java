package cn.com.filter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		 if(session.getAttribute("userinfo")!=null){
			 arg2.doFilter(req, resp);
		 }else{
		 
		
		
		 req.getRequestDispatcher("/CarInfo.action").forward(req, resp);
		 }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
