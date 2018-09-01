package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.po.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 问题数据访问接口
 *
 * @author Administrator
 */
public interface ProblemRepository extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {
    /**
     * 根据标签id查询最新问题分页列表
     *
     * @param labelid
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where p.id in (select problemid from Pl where labelid = ?1) order by p.replytime desc ")
    Page<Problem> findByLabelidOrderByReplytimeDesc(String labelid, Pageable pageable);

    /**
     * 根据标签id查询最热问题分页列表
     *
     * @param labelid
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where p.id in (select problemid from Pl where labelid = ?1) order by p.reply desc ")
    Page<Problem> findByLabelidOrderByIshotDesc(String labelid, Pageable pageable);

    /**
     * 根据标签id查询没有回复问题的分页列表
     *
     * @param labelid
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where p.id in (select problemid from Pl where labelid = ?1) and p.reply = 0 order by p.createtime desc ")
    Page<Problem> findByLabelidOrderByNoReplyDesc(String labelid, Pageable pageable);
}
