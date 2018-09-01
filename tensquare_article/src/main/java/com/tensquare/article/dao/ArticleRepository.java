package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.po.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ArticleRepository extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    /**
     * 根据id修改状态
     *
     * @param id
     * @param state
     */
    @Query("update Article set state = ?2 where  id = ?1")
    @Modifying
    void updateStateById(String id, String state);

    /**
     * 根据id点赞加一或点赞减一
     *
     * @param id
     * @param number
     */
    @Query("update Article set thumbup = thumbup + ?2 where id = ?1")
    @Modifying
    void updateThumbupToIncrementingOrDiminishing(String id, int number);
}
