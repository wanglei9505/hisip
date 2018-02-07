package com.shine.hisip.common.response;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Hyun on 2017.3.10.
 *
 */
public class Page<T> {

    private List<T> rows = Lists.newArrayList();
    private long total = 0;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows.addAll(rows);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
