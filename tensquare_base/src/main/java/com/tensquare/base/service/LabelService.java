package com.tensquare.base.service;

import com.tensquare.base.dao.LabelRepository;
import com.tensquare.base.po.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import utils.IdWorker;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 标签业务逻辑类
 *
 * @Author: CooFive
 * @CreateDate: 18/8/30 15:18
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class LabelService {
    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存一个标签
     *
     * @param label
     */
    public void saveLabel(Label label) {
        // 设置ID
        label.setId(idWorker.nextId() + "");
        labelRepository.save(label);
    }

    /**
     * 更新一个标签
     *
     * @param label
     */
    public void updateLabel(Label label) {
        labelRepository.save(label);
    }

    /**
     * 删除一个标签
     *
     * @param id
     */
    public void deleteLabelById(String id) {
        labelRepository.deleteById(id);
    }

    /**
     * 查询全部标签
     *
     * @return
     */
    public List<Label> findLabelList() {
        return labelRepository.findAll();
    }

    /**
     * 根据id查询标签
     *
     * @param id
     * @return
     */
    public Label findLabelById(String id) {
        return labelRepository.findById(id).get();
    }

    /**
     * 根据条件查询标签
     *
     * @param searchMap
     * @return
     */
    public List<Label> findLabelList(Map<String, Object> searchMap) {
        // 构建查询条件
        Specification<Label> spec = getLabelSpecification(searchMap);
        return this.labelRepository.findAll(spec);
    }

    /**
     * 根据条件分页查询标签
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page<Label> findLabelList(Map<String, Object> searchMap, int page, int size) {
        // 构建查询条件
        Specification<Label> spec = getLabelSpecification(searchMap);

        // 构建请求的分页对象
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        return this.labelRepository.findAll(spec, pageRequest);
    }

    /**
     * 根据map参数获取spec条件对象
     *
     * @param searchMap
     * @return
     */
    private Specification<Label> getLabelSpecification(Map<String, Object> searchMap) {
        return (Specification<Label>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            // 标签名称
            if (!StringUtils.isEmpty(searchMap.get("labelname"))) {
                predicateList.add(
                        criteriaBuilder.like(root.get("labelname").as(String.class), "%" + searchMap.get("labelname") + "%")
                );
            }

            // 状态
            if (!StringUtils.isEmpty(searchMap.get("state"))) {
                predicateList.add(
                        criteriaBuilder.equal(root.get("state"), searchMap.get("state"))
                );
            }

            // 是否推荐
            if (!StringUtils.isEmpty(searchMap.get("recommend"))) {
                predicateList.add(
                        criteriaBuilder.equal(root.get("recommend"), searchMap.get("recommend"))
                );
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));

        };
    }

}
