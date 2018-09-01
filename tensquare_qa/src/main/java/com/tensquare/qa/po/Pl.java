package com.tensquare.qa.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 问题和标签的关系表
 *
 * @Author: CooFive
 * @CreateDate: 18/9/1 16:44
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {
    /**
     * 问题id
     */
    @Id
    private String problemid;

    /**
     * 标签id
     */
    @Id
    private String labelid;

    public Pl() {
    }

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }
}
