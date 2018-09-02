package com.tensquare.spit.dao;

import com.tensquare.spit.po.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 吐槽数据访问层
 *
 * @Author: CooFive
 * @CreateDate: 18/9/2 15:22
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface SpitRepository extends MongoRepository<Spit, String> {
}
