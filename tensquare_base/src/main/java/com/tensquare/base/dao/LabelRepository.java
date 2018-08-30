package com.tensquare.base.dao;

import com.tensquare.base.po.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 标签数据访问接口
 *
 * @Author: CooFive
 * @CreateDate: 18/8/30 15:16
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface LabelRepository extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
