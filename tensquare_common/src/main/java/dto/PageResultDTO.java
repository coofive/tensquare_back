package dto;

import java.util.List;

/**
 * 分页返回结果
 *
 * @Author: CooFive
 * @CreateDate: 18/8/30 14:48
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class PageResultDTO<T> {
    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页的数据列表
     */
    private List<T> rows;

    public PageResultDTO(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
