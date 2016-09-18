package cn.com.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.ICommentDao;
import cn.com.dao.IPageDao;
/**
 * 评论操作实现类
 * @author lej
 */
@Repository
public class CommentDaoImpl extends BaseDao implements ICommentDao, IPageDao {
          /**
           * 添加评论的方法
           * @parma comment
           * @return int
           */
	@Override
	public int addComment(Comment1 comment) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
		 super.getSqlSessionTemplate().insert("cn.com.pojo.Comment1Mapper.insertSelective", comment);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 删除评论的方法
           * @parma comment
           * @return int
           */
	@Override
	public int deleteComment(Comment1 comment) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			super.getSqlSessionTemplate().delete("cn.com.pojo.Comment1Mapper.deleteComment", comment);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 获取评论的方法
           * @parma comment
           * @return Comment
           */
	@Override
	public Comment1 getComment(Comment1 comment) {
		// TODO Auto-generated method stub
		Comment1 _comment = null;
		try{
		_comment=	 (Comment1) super.getSqlSessionTemplate().selectList("cn.com.pojo.Comment1Mapper.getComment", comment).get(0);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return _comment;
	}
          /**
           * 获取两条最新的评论的方法
           * @parma comment
           * @parma min 最小行
           * @parma max 最大行
           * @return Map<Long,Comment>
           */
	@Override
	public Map<Long, Comment1> getTheTowComment(Comment1 comment, int min, int max) {
		// TODO Auto-generated method stub
		Map<Long, Comment1> comMap = new HashMap<Long, Comment1>();
   Map<String, Object> parmas=new HashMap<String, Object>();
	
	
		parmas.put("cAdmin", comment.getcAdmin());
		parmas.put("min", min);
		parmas.put("max", max);
		comMap=    super.getSqlSessionTemplate().selectMap("cn.com.pojo.Comment1Mapper.getTheTowComment", parmas, "cId");
		
		return comMap;
	}

	@Override
	public Long queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
          /**
           * 获取评论总记录条数的方法
           * @return int
           */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count = null;

	 count=(Long) super.getSqlSessionTemplate().selectList("cn.com.pojo.Comment1Mapper.queryPersonCarCount").get(0);
		return count;
	}
          /**
           * 分页获取评论信息
           * @param curPage 当前页
           * @param rowsPrePage 每页展示条数
           * @return Map<Long, Object> 
           */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub

		Map<Long, Object> trendsMap = new HashMap<Long, Object>();
      Map<String, Object> parmas=new HashMap<String, Object>();
      parmas.put("curPage", curPage);
      parmas.put("rowsPrePage", rowsPrePage);
      trendsMap=  super.getSqlSessionTemplate().selectMap("cn.com.pojo.Comment1Mapper.showPersonCarList",parmas ,"cId");
		return trendsMap;
	}

}
