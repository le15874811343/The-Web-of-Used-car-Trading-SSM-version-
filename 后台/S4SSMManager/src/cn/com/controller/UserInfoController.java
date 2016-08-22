package cn.com.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.pojo.Userinfo3;
import cn.com.service.IUserInfoService;
import cn.com.util.DbUtil;

@Controller
public class UserInfoController {
	@Resource
	private IUserInfoService userInfoService=null;
 private String url;
	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
@RequestMapping("/UserInfo.action")
	public String execute(HttpServletRequest request,HttpSession session)  {
		// TODO Auto-generated method stub
	 deleteYzm(session);
	 bindWhere(request);
	if(session.getAttribute("userinfo")==null){	 
		long u_tel=Long.parseLong(request.getParameter("username"));
		
		String u_pwd=request.getParameter("userpwd");
		
		Userinfo3 userInfo=new Userinfo3();
		userInfo.setuTel(u_tel);
		userInfo.setuPwd(u_pwd);
		Userinfo3 _userInfo=userInfoService.login(userInfo);
		DbUtil.closeAll();
		
		if(_userInfo!=null){
			if(_userInfo.getuAdmin().equals("管理员")){
				Date date=new Date();
				 DateFormat dateFormat=new SimpleDateFormat("HH");
				session.setAttribute("time",dateFormat.format(date) );
				session.setAttribute("userinfo", _userInfo);
				return "admin/index";
			
		   }
		   else{
			  String loginmessage="没有权限";
				 String sRand= getYZM(request);
				    session.setAttribute("sRand", sRand);
				    request.setAttribute("loginmessage", loginmessage);
				    return "Login";
				
		   }
			
			 
	   
			
		
			
		}
		else{
			userInfo.setuPwd(null);
			String loginmessage=null;
			 if(userInfoService.getUserInfoByUnique(userInfo)==null){
				 DbUtil.closeAll();
				 loginmessage="该用户不存在";
				 String sRand= getYZM(request);
				    session.setAttribute("sRand", sRand);
				   
			 }
			 else{
				 loginmessage="用户名或密码错误,请重新输入";
				 String sRand= getYZM(request);
				 session.setAttribute("sRand", sRand);
				 
			 }
			 request.setAttribute("loginmessage", loginmessage);
			 return "Login";

		}
	}
	 else{
		 String	 loginmessage="你已经登陆过一个账户了";
		 String sRand= getYZM(request);
		 session.setAttribute("sRand", sRand);
		 request.setAttribute("loginmessage", loginmessage);
		 return "Login";
	 }
	
		
	}
@RequestMapping("/UserInfo_needLogin.action")
	public String needLogin(HttpServletRequest request,HttpSession session){
	 deleteYzm(session);
	 bindWhere(request);
	 String sRand= getYZM(request);
	    session.setAttribute("sRand", sRand);
	return "Login";
	}
@RequestMapping("/UserInfo_needReg.action")
	public void needReg(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		 deleteYzm(session);
		 bindWhere(request);
		 String sRand= getYZM(request);
		 session.setAttribute("sRand", sRand);
		
		 response.setContentType("text/html;charset=utf-8");
		
		 try {
			response.getWriter().println(sRand);
			 response.getWriter().flush();//清空缓存,刷新
			 response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		 
		
	}
@RequestMapping("/UserInfo_regUser.action")
	public String regUser(HttpServletRequest request,HttpSession session)  {
		deleteYzm(session);
		 bindWhere(request);
		long regname=Long.parseLong(request.getParameter("regname"));
		String realname=request.getParameter("realname");
		String sex=request.getParameter("gender");
	     String regpwd=  request.getParameter("regpwd");
	     String regmessage=null;
	     Userinfo3 userInfo=new Userinfo3();
	     userInfo.setuTel(regname);
	    
	     if(userInfoService.getUserInfoByUnique(userInfo)!=null){
	    	 DbUtil.closeAll();
	    	 regmessage="此手机号已被注册,请进入登录面板试试找回密码吧";
	    	 String sRand= getYZM(request);
	    	 session.setAttribute("sRand", sRand);
	    	 
	     }
	     else{
	    	 userInfo.setuName(realname);
		     userInfo.setuPwd(regpwd);
		     userInfo.setuSex(sex);
		  
		     userInfo.setuAdmin("普通用户");
		     if(userInfoService.addUserInfo(userInfo)){
		    	 DbUtil.closeAll();
		    String	 loginmessage="注册成功,现在就开始登录吧";
		    String sRand= getYZM(request);
	    	 session.setAttribute("sRand", sRand);
		    request.setAttribute("loginmessage", loginmessage);
		     }
		     else{
		    	 DbUtil.closeAll();
		    	 regmessage="注册失败";
		    	 String sRand= getYZM(request);
		    	 session.setAttribute("sRand", sRand);
		     }
	     }
	     request.setAttribute("regmessage", regmessage);
	    
	     return this.url;
	}
@RequestMapping("/UserInfo_update.action")
	public String update(HttpServletRequest request,HttpSession session) {
		deleteYzm(session);
		 bindWhere(request);
		 String card=request.getParameter("card");
		 String email=request.getParameter("email");
		 String qq=request.getParameter("qq");
		 String realname=request.getParameter("realname");
		 String adr=request.getParameter("adr");
		 String sex=request.getParameter("gender");
		 
	Userinfo3  userInfo=	 (Userinfo3) session.getAttribute("userinfo");
		 userInfo.setuName(realname);
		 userInfo.setuSex(sex);
		 if(card!=null&&!card.equals("")){
			 userInfo.setuCard(Long.parseLong(card));
		 }
		 if(qq!=null&&!qq.equals("")){
			 userInfo.setuQq(Long.parseLong(qq));
		 }
		 if(email!=null&&!email.equals("")){
			 userInfo.setuEmail(email);
		 }
		 if(adr!=null&&!adr.equals("")){
			 userInfo.setuAdr(adr);
		 }
		 try{
		 if(userInfoService.updateUserInfo(userInfo)){
			 session.setAttribute("userinfo", userInfo);
			return "admin/memberMyAccount";
		 }
		 else{
			 return "ERROR";
			 }
		 }
		 catch (Exception e) {
             e.printStackTrace();
			 // TODO: handle exception
		return "ERROR";
		 }
		 
	}
@RequestMapping("/UserInfo_updatePwd.action")
	public String updatePwd(HttpServletRequest request,HttpSession session) {
		deleteYzm(session);
		 bindWhere(request);
		Userinfo3 userInfo=(Userinfo3) session.getAttribute("userinfo");
		String opwd=	 request.getParameter("opwd");
		  userInfo.setuPwd(opwd);
		  if(userInfoService.login(userInfo)!=null){
			  String npwd=request.getParameter("npwd");
			  userInfo.setuPwd(npwd);
			if(userInfoService.updateUserPwd(userInfo)){
				 String updatemessage="密码修改成功";
				 request.setAttribute("updatemessage", updatemessage);
				
				 return "admin/memberMyAccount";
			}
			else{
				return "ERROR";
			}
		  }
		  else{
			  String updatemessage="当前密码错误,请重新输入";
			  request.setAttribute("updatemessage", updatemessage);
			
			  return "admin/memberMyAccount";
		  }
	}
@RequestMapping("/UserInfo_updateYzm.action")
	public void updateYzm(HttpServletRequest request,HttpSession session,HttpServletResponse response)  {
		deleteYzm(session);
		 bindWhere(request);
		 String sRand= getYZM(request);
		 response.setContentType("text/html;charset=utf-8");
		 session.setAttribute("sRand", sRand);
		 try {
			 
			response.getWriter().println(sRand);
			 response.getWriter().flush();//清空缓存,刷新
			 response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
@RequestMapping("/UserInfo_hsy.action")
	public String hsy(HttpServletRequest request,HttpSession session){
		deleteYzm(session);
		 bindWhere(request);
		 String sRand= getYZM(request);
    	 session.setAttribute("sRand", sRand);
		 String loginmessage="k";
		 request.setAttribute("loginmessage", loginmessage);
		
		return this.url;
	}
@RequestMapping("/UserInfo_zhuXiao.action")
	public String zhuXiao(HttpServletRequest request,HttpSession session) {
	
		deleteYzm(session);
		 bindWhere(request);
		 session.removeAttribute("userinfo");
		
		
		 return this.url;
	}
	private   Color getRandColor(int fc,int bc){  
        Random random = new Random();  
        if(fc > 255){  
            fc = 255;  
        }  
        if(bc < 255){  
            bc = 255;  
        }  
        int r = fc +random.nextInt(bc-fc);  
        int g = fc +random.nextInt(bc-fc);  
        int b = fc +random.nextInt(bc-fc);  
        return new Color(r,g,b);  
    }  
   
private String getYZM(HttpServletRequest request){
	 int width = 60;  
	    int height = 40;  
	    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
	    //创建图象  
	    Graphics g = image.getGraphics();  
	    //生成随机对象  
	    Random random = new Random();  
	    //设置背景色  
	    g.setColor(getRandColor(200,250));  
	    g.fillRect(0,0,width,height);  
	    //设置字体  
	    g.setFont(new Font("Tines Nev Roman",Font.PLAIN,18));  
	    //随机产生干扰线  
	    g.setColor(getRandColor(160,200));  
	    for(int i = 0; i < 255; i++){  
	        int x = random.nextInt(width);  
	        int y = random.nextInt(height);  
	        int x1 = random.nextInt(12);  
	        int y1 = random.nextInt(12); 
	        g.drawLine(x,y,x-x1,y-y1);
	    }  
	    //随机产生认证码,4位数字  
	    String sRand = "";  
	    for(int i = 0; i < 4; i++){  
	        String rand = String.valueOf(random.nextInt(10));  
	        sRand  += rand;  
	        //将认证码显示到图象中  
	        g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));  
	        g.drawString(rand,13*i+6,16);  
	    }  
	    //图像生效  
	    g.dispose();  
	    //输出图像到页面  
	    String url=request.getServletContext().getRealPath("/images")+"/"+sRand+".jpg";
	   FileOutputStream fileOutputStream;
	try {
		fileOutputStream = new FileOutputStream(url, false);
		  ImageIO.write(image, "jpg", fileOutputStream);
		    fileOutputStream.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	    return sRand;
}
private void deleteYzm(HttpSession session){
String	sRand=(String) session.getAttribute("sRand");
    String url=session.getServletContext().getRealPath("/images")+"/"+sRand+".jpg";
File file=new File(url);

if(file.exists()){
	file.delete();
	
}
}
	private void bindWhere(HttpServletRequest request){
		url=request.getParameter("url");
		if(request.getParameter("bname")!=null){
			request.setAttribute("bname", request.getParameter("bname"));
			System.out.println(request.getParameter("bname"));
		}
		if(request.getParameter("tname")!=null){
			request.setAttribute("tname", request.getParameter("tname"));
			System.out.println(request.getParameter("tname"));
		}
		if(request.getParameter("cesr")!=null){
			request.setAttribute("cesr", request.getParameter("cesr"));
			System.out.println(request.getParameter("cesr"));
		}
		if(request.getParameter("price")!=null){
			request.setAttribute("price", request.getParameter("price"));
			System.out.println(request.getParameter("price"));
		}
		if(request.getParameter("distance")!=null){
			request.setAttribute("distance", request.getParameter("distance"));
			System.out.println(request.getParameter("distance"));
		}
		if(request.getParameter("age")!=null){
			request.setAttribute("age", request.getParameter("age"));
			System.out.println(request.getParameter("age"));
		}
		if(request.getParameter("emsi")!=null){
			request.setAttribute("emsi", request.getParameter("emsi"));
			System.out.println(request.getParameter("emsi"));
		}
		if(request.getParameter("bid")!=null){
			request.setAttribute("bid", request.getParameter("bid"));
			System.out.println(request.getParameter("bid"));
		}
		if(request.getParameter("cid")!=null){
			request.setAttribute("cid", request.getParameter("cid"));
			System.out.println(request.getParameter("cid"));
		}
	}
}
