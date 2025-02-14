package com.xinshi.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: xbronze
 * @date: 2025-02-14 10:41
 * @description: TODO
 */
// 该类主要实现部门数据结构的映射，实现数据的远程传输
public class DeptDTO implements Serializable { // 定义数据传输类
    private Long deptno; // 部门编号
    private String dname; // 部门名称
    private String loc; // 部门位置

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
