package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitRepository;
import com.tensquare.spit.po.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import java.util.List;

/**
 * 吐槽业务层
 *
 * @Author: CooFive
 * @CreateDate: 18/9/2 15:23
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class SpitService {

    @Autowired
    private SpitRepository spitRepository;

    @Autowired
    private IdWorker idWorker;

    /**
     * 增加
     *
     * @param spit
     */
    public void saveSpit(Spit spit) {
        spit.setId(idWorker.nextId() + "");
        this.spitRepository.save(spit);
    }

    /**
     * 修改
     *
     * @param spit
     */
    public void updateSpit(Spit spit) {
        this.spitRepository.save(spit);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    public void deleteSpitById(String id) {
        this.spitRepository.deleteById(id);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<Spit> findSpitList() {
        return this.spitRepository.findAll();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public Spit findSpitById(String id) {
        return this.spitRepository.findById(id).get();
    }
}
