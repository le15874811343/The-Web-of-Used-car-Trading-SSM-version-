package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.Comment1;
import cn.com.dao.ICommentDao;
import cn.com.dao.IPageDao;

import cn.com.service.ICommentService;
/**
 * 评论服务实现类
 * @author lej
 */
@Service
public class CommentServiceImpl implements ICommentService,IPageDao {
	@Resource
  private ICommentDao commentDao=null; //评论操作接口的引用
	@Resource(name="commentDaoImpl")
  private IPageDao commentPage=null; //分页处理操作接口的引用
  
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
          /**
           * 添加评论的服务
           * @parma comment
           * @return boolean
           */
	@Override
	public boolean addComment(Comment1 comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.addComment(comment)>0){
			flag=true;
		}
		return flag;
	}
          /**
           * 删除评论的服务
           * @parma comment
           * @return boolean
           */
	@Override
	public boolean deleteComment(Comment1 comment) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(commentDao.deleteComment(comment)>0){
			flag=true;
		}
		return flag;
	}
          /**
           * 获取评论的服务
           * @parma comment
           * @return Comment
           */
	@Override
	public Comment1 getComment(Comment1 comment) {
		// TODO Auto-generated method stub
		return commentDao.getComment(comment);
	}
          /**
           * 获取两条最新的评论的服务
           * @parma comment
           * @parma min 最小行
           * @parma max 最大行
           * @return Map<Long,Comment>
           */
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
    /**
     * 获取评价信息的记录总条数的服务
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return commentPage.queryPersonCarCount(object);
	}
/**
 * 分页获取评论信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return commentPage.showPersonCarList(curPage, rowsPrePage, object);
	}
          /**
           * 修改评论的服务
           * @parma comment
           * @return boolean
           */
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
