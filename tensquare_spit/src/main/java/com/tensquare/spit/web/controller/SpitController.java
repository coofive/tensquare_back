package com.tensquare.spit.web.controller;

import com.tensquare.spit.po.Spit;
import com.tensquare.spit.service.SpitService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 吐槽表现层
 *
 * @Author: CooFive
 * @CreateDate: 18/9/2 15:30
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RestController
@RequestMapping("spit")
@CrossOrigin
public class SpitController {

    @Autowired
    private SpitService spitService;

    /**
     * 新增吐槽
     *
     * @param spit
     * @return
     */
    @PostMapping
    public ResultDTO save(@RequestBody Spit spit) {
        this.spitService.saveSpit(spit);
        return new ResultDTO(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改吐槽
     *
     * @param spit
     * @param spitId
     * @return
     */
    @PutMapping("/{spitId}")
    public ResultDTO update(@RequestBody Spit spit, @PathVariable String spitId) {
        spit.setId(spitId);
        this.spitService.updateSpit(spit);
        return new ResultDTO(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除吐槽
     *
     * @param spitId
     * @return
     */
    @DeleteMapping("/{spitId}")
    public ResultDTO delete(@PathVariable String spitId) {
        this.spitService.deleteSpitById(spitId);
        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

    /**
     * 查询全部吐槽
     *
     * @return
     */
    @GetMapping
    public ResultDTO findAll() {
        List<Spit> spitList = this.spitService.findSpitList();
        return new ResultDTO(true, StatusCode.OK, "查询成功", spitList);
    }

    /**
     * 根据id查询
     *
     * @param spitId
     * @return
     */
    @GetMapping("/{spitId}")
    public ResultDTO findById(@PathVariable String spitId) {
        Spit spitById = this.spitService.findSpitById(spitId);
        return new ResultDTO(true, StatusCode.OK, "查询成功", spitById);
    }
}
