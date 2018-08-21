package com.pinyougou.result;

import com.pinyougou.pojo.TbBrand;

import java.io.Serializable;
import java.util.List;

public class ResultPage<T> implements Serializable {
    private Long total;
    private List<T> rows;

    public ResultPage() {
    }

    public ResultPage(Long total, List<T> rows) {
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
