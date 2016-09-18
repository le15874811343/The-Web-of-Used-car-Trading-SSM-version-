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
/**
 * 编码过滤器类
 * @author  lej
 */
public class EncodingFilter implements Filter{
   private String encoding="";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		      HttpServletRequest request=(HttpServletRequest) arg0;
		      HttpServletResponse response=(HttpServletResponse) arg1;
		      request.setCharacterEncoding(encoding); //设置请求编码
		      response.setCharacterEncoding(encoding); //设置响应编码
		      arg2.doFilter(request, response); //通过
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	encoding=	arg0.getInitParameter("Encoding"); //获取配置文件中的编码参数
	}

}
