package com.tensquare.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.base.po.City;

/**
 * 城市数据访问接口
 *
 * @author Administrator
 */
public interface CityRepository extends JpaRepository<City, String>, JpaSpecificationExecutor<City> {

}
