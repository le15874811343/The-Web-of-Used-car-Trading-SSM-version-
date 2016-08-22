package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.Comment1;
import cn.com.dao.ICommentDao;
import cn.com.dao.IPageDao;

import cn.com.service.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService,IPageDao {
	@Resource
  private ICommentDao commentDao=null;
	@Resource(name="commentDaoImpl")
  private IPageDao commentPage=null;
  
	public ICommentDao getCommentDao() {
	return commentDao;
}

public void setCommentDao(ICommentDao commentDao) {
	this.commentDao = commentDao;
}

public IPageDao getCommentPage() {
	return commentPage;
}

public void setCommentPage(IPageDao commentPage) {
	this.commentPage = commentPage;
}

	@Override
	public boolean addComment(Comment1 comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.addComment(comment)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteComment(Comment1 comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.deleteComment(comment)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public Comment1 getComment(Comment1 comment) {
		// TODO Auto-generated method stub
		return commentDao.getComment(comment);
	}

	@Override
	public Map<Long, Comment1> getTheTowComment(Comment1 comment, int min, int max) {
		// TODO Auto-generated method stub
		return commentDao.getTheTowComment(comment, min, max);
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

	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return commentPage.queryPersonCarCount(object);
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return commentPage.showPersonCarList(curPage, rowsPrePage, object);
	}

	@Override
	public boolean updateComment(Comment1 comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.updateComment(comment)>0){
			flag=true;
		}
		return flag;
	}

}
