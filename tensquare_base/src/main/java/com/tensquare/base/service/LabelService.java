package com.tensquare.base.service;

import com.tensquare.base.dao.LabelRepository;
import com.tensquare.base.po.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import java.util.List;

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

}
