package com.tensquare.base.web.controller;

import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import constants.StatusCode;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 标签控制层
 *
 * @CrossOrigin 支持跨域请求
 * @Author: CooFive
 * @CreateDate: 18/8/30 15:25
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 添加一个标签
     *
     * @param label
     * @return
     */
    @PostMapping
    public ResultDTO add(@RequestBody Label label) {
        labelService.saveLabel(label);
        return new ResultDTO(true, StatusCode.OK, "添加成功");
    }

    /**
     * 更新一个标签
     *
     * @param label
     * @return
     */
    @PutMapping("/{labelId}")
    public ResultDTO updateById(@RequestBody Label label, @PathVariable String labelId) {
        label.setId(labelId);
        labelService.updateLabel(label);
        return new ResultDTO(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除一个标签
     *
     * @param labelId
     * @return
     */
    @DeleteMapping("/{labelId}")
    public ResultDTO deleteById(@PathVariable String labelId) {
        labelService.deleteLabelById(labelId);
        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

    /**
     * 查询所有标签
     *
     * @return
     */
    @GetMapping
    public ResultDTO list() {
        List<Label> list = labelService.findLabelList();
        return new ResultDTO(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 根据id查询一个
     *
     * @param labelId
     * @return
     */
    @GetMapping("/{labelId}")
    public ResultDTO findById(@PathVariable String labelId) {
        int i = 1 / 0;
        Label label = labelService.findLabelById(labelId);
        return new ResultDTO(true, StatusCode.OK, "查询成功", label);
    }

    /**
     * 根据条件查询标签
     *
     * @return
     */
    @PostMapping("/search")
    public ResultDTO list(@RequestBody Map<String, Object> searchMap) {
        List<Label> list = labelService.findLabelList(searchMap);
        return new ResultDTO(true, StatusCode.OK, "查询成功", list);
    }


    /**
     * 根据条件分页查询标签
     *
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public ResultDTO list(@RequestBody Map<String, Object> searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Label> pageResponse = labelService.findLabelList(searchMap, page, size);
        // 构建返回data
        PageResultDTO<Label> labelPageResultDTO = new PageResultDTO<>(pageResponse.getTotalElements(), pageResponse.getContent());
        return new ResultDTO(true, StatusCode.OK, "查询成功", labelPageResultDTO);
    }
}
