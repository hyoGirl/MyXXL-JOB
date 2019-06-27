package com.xxl.jobTest.Job;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;

/**
 * @Auther: xulei
 * @Date: 2019/6/25 0025 15:51
 * @Description:
 */
public class JobInfoList {

    private List<MyJobInfo> list;


    private int recordsFiltered;
    private int recordsTotal;

    public List<MyJobInfo> getList() {
        return list;
    }

    public void setList(List<MyJobInfo> list) {
        this.list = list;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}
