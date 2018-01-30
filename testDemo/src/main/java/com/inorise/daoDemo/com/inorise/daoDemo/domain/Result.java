package com.inorise.daoDemo.com.inorise.daoDemo.domain;

import java.util.List;

public class Result {

    private List<?> rows;

    private Long total;

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
