package com.tensquare.base.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.tensquare.base.po.City;
import com.tensquare.base.service.CityService;

import dto.PageResultDTO;
import dto.ResultDTO;
import constants.StatusCode;

/**
 * 城市控制器层
 *
 * @author BoBoLaoShi
 */
@RestController
@CrossOrigin
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;


    /**
     * 增加
     *
     * @param city
     */
    @PostMapping
    public ResultDTO add(@RequestBody City city) {
        cityService.saveCity(city);
        return new ResultDTO(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param city
     */
    @PutMapping("/{id}")
    public ResultDTO edit(@RequestBody City city, @PathVariable String id) {
        city.setId(id);
        cityService.updateCity(city);
        return new ResultDTO(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResultDTO remove(@PathVariable String id) {
        cityService.deleteCityById(id);
        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @GetMapping
    public ResultDTO list() {
        return new ResultDTO(true, StatusCode.OK, "查询成功", cityService.findCityList());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public ResultDTO getById(@PathVariable String id) {
        return new ResultDTO(true, StatusCode.OK, "查询成功", cityService.findCityById(id));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @PostMapping("/search")
    public ResultDTO list(@RequestBody Map searchMap) {
        return new ResultDTO(true, StatusCode.OK, "查询成功", cityService.findCityList(searchMap));
    }

    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @PostMapping("/search/{page}/{size}")
    public ResultDTO listPage(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<City> pageResponse = cityService.findCityListPage(searchMap, page, size);
        return new ResultDTO(true, StatusCode.OK, "查询成功", new PageResultDTO<City>(pageResponse.getTotalElements(), pageResponse.getContent()));
    }

}
