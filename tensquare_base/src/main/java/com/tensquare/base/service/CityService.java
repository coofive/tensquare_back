package com.tensquare.base.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import utils.IdWorker;

import com.tensquare.base.dao.CityRepository;
import com.tensquare.base.po.City;

/**
 * 城市服务层
 *
 * @author Administrator
 */
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private IdWorker idWorker;

    /**
     * 增加
     *
     * @param city
     */
    public void saveCity(City city) {
        city.setId(idWorker.nextId() + "");
        cityRepository.save(city);
    }

    /**
     * 修改
     *
     * @param city
     */
    public void updateCity(City city) {
        cityRepository.save(city);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteCityById(String id) {
        cityRepository.deleteById(id);
    }

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<City> findCityList() {
        return cityRepository.findAll();
    }

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public City findCityById(String id) {
        return cityRepository.findById(id).get();
    }

    /**
     * 根据条件查询列表
     *
     * @param whereMap
     * @return
     */
    public List<City> findCityList(Map whereMap) {
        //构建Spec查询条件
        Specification<City> specification = getCitySpecification(whereMap);
        //Specification条件查询
        return cityRepository.findAll(specification);
    }

    /**
     * 组合条件分页查询
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<City> findCityListPage(Map whereMap, int page, int size) {
        //构建Spec查询条件
        Specification<City> specification = getCitySpecification(whereMap);
        //构建请求的分页对象
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return cityRepository.findAll(specification, pageRequest);
    }

    /**
     * 根据参数Map获取Spec条件对象
     *
     * @param searchMap
     * @return
     */
    private Specification<City> getCitySpecification(Map searchMap) {

        return (Specification<City>) (root, query, cb) -> {
            //临时存放条件结果的集合
            List<Predicate> predicateList = new ArrayList<Predicate>();
            //属性条件
            // ID
            if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
                predicateList.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
            }
            // 城市名称
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                predicateList.add(cb.like(root.get("name").as(String.class), "%" + (String) searchMap.get("name") + "%"));
            }
            // 是否热门
            if (searchMap.get("ishot") != null && !"".equals(searchMap.get("ishot"))) {
                predicateList.add(cb.like(root.get("ishot").as(String.class), "%" + (String) searchMap.get("ishot") + "%"));
            }

            //最后组合为and关系并返回
            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };

    }

}
