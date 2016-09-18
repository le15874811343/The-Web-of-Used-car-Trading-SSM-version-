package cn.com.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 权限拦截器
 * @author lej
 */
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
	
		// TODO Auto-generated method stub
		boolean  flag=false;
		HttpSession  session=arg0.getSession();
		Object obj=session.getAttribute("userinfo");
		if(obj!=null)  //验证session中用户对象是否为空
		{
			flag=true;  //不为空则返回为真
		}
		
		return flag;
	}

}
