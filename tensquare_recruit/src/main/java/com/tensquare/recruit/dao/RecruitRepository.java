package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.po.Recruit;

import java.util.List;

/**
 * 招聘数据访问接口
 *
 * @author Administrator
 */
public interface RecruitRepository extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
    /**
     * 根据状态，查询最新职位列表，按创建日期降序排序，只查询4条
     *
     * @param state
     * @return
     */
    List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 不是关闭状态，查询最新职位列表的前12条记录
     *
     * @param state
     * @return
     */
    List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
