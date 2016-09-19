package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 评论服务接口
 * @author lej
 */
@Repository
public interface ICommentService {
	  /**
           * 添加评论的服务
           * @parma comment
           * @return boolean
           */
	public boolean addComment(Comment1 comment) ;
	 /**
           * 删除评论的服务
           * @parma comment
           * @return boolean
           */
	public boolean deleteComment(Comment1 comment);
	 /**
           * 获取评论的服务
           * @parma comment
           * @return Comment
           */
	public Comment1 getComment(Comment1 comment);
	 /**
           * 获取两条最新的评论的服务
           * @parma comment
           * @parma min 最小行
           * @parma max 最大行
           * @return Map<Long,Comment>
           */
	public Map<Long, Comment1> getTheTowComment(Comment1 comment,int min,int max);
	 /**
           * 修改评论的服务
           * @parma comment
           * @return boolean
           */
	public boolean updateComment(Comment1 comment);
}
