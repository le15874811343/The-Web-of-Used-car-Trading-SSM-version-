package cn.com.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.pojo.Model;
import cn.com.service.IModelService;
import cn.com.util.DbUtil;
/**
 * 车系操作控制器类
 * 
 */
@Controller
public class ModelController {
	@Resource
	  private IModelService modelService=null; //车系信息服务接口的引用

	public IModelService getModelService() {
		return modelService;
	}

	public void setModelService(IModelService modelService) {
		this.modelService = modelService;
	}
/**
 * 获取某品牌下的车系的action
 * 
 */
	@RequestMapping("/Model.action")
	public void execute(HttpServletRequest request,HttpServletResponse response)  {
		// TODO Auto-generated method stub
		
		int b_id=Integer.parseInt(request.getParameter("brand"));
		Model model=new Model();
		model.setbId(b_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	  
	 
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	  response.setContentType("text/html;charset=utf-8");
	  try {
		response.getWriter().println(jsonArray);
		 response.getWriter().flush();//Çå¿Õ»º´æ,Ë¢ÐÂ
		  response.getWriter().close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	  
	}
}
