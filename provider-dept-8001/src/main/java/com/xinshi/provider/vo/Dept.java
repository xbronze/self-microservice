package com.xinshi.provider.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * @author: xbronze
 * @date: 2025-02-14 11:32
 * @description: TODO
 */
@TableName("dept")
public class Dept { // 这个类所需要追加MBP所需要的注解
    @TableId(type = IdType.AUTO) // 采用自动增长列配置
    private Long deptno; // 与deptno字段映射
    private String dname;
    private String loc;

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