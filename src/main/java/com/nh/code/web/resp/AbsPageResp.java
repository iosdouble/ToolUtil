package com.nh.code.web.resp;

import java.util.List;

/**
 * @Classname AbsPageResp
 * @Description TODO
 * @Date 2019/8/20 12:18 PM
 * @Created by nihui
 */
public class AbsPageResp<T> extends AbsJsonResp {
    private static final long serialVersionUID = 6790362688028070728L;
    private long count;
    private int offset;
    private int limit;
    private List<T> data;

    public AbsPageResp() {
    }

    public long getCount() {
        return this.count;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getLimit() {
        return this.limit;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
