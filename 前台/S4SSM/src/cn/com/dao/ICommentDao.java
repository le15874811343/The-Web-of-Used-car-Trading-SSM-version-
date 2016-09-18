package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 评论操作接口
 * @author lej
 */
@Repository
public interface ICommentDao {
            /**
           * 添加评论的方法
           * @parma comment
           * @return int
           */
          public int addComment(Comment1 comment);
           /**
           * 删除评论的方法
           * @parma comment
           * @return int
           */
          public int deleteComment(Comment1 comment);
            /**
           * 获取评论的方法
           * @parma comment
           * @return Comment1
           */
          public Comment1 getComment(Comment1 comment);
            /**
           * 获取两条最新的评论的方法
           * @parma comment
           * @parma min 最小行
           * @parma max 最大行
           * @return Map<Long,Comment1>
           */
          public Map<Long, Comment1> getTheTowComment(Comment1  comment,int min,int max);
        
}
