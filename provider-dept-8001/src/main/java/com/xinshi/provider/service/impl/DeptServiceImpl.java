package com.xinshi.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xinshi.common.dto.DeptDTO;
import com.xinshi.common.util.DeepBeanUtils;
import com.xinshi.provider.dao.IDeptDAO;
import com.xinshi.provider.vo.Dept;
import com.xinshi.service.IDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xbronze
 * @date: 2025-02-14 11:34
 * @description: TODO
 */
@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDAO deptDAO;
    @Override
    public DeptDTO get(long id) {
        DeptDTO dto = new DeptDTO(); // 实例化传输对象
        // 在本地端通过了VO类实现了数据的加载，随后将此数据拷贝到DTO对象之中
        Dept dept = this.deptDAO.selectById(id);
        BeanUtils.copyProperties(dept, dto); // 属性拷贝
        return dto;
    }

    @Override
    public boolean add(DeptDTO dto) {
        Dept dept = new Dept(); // 数据层最终需要的是一个VO类型
        BeanUtils.copyProperties(dto, dept);
        return this.deptDAO.insert(dept) > 0; // 更新行数大于0
    }

    @Override
    public List<DeptDTO> list() {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        List<DeptDTO> allDepts = DeepBeanUtils.copyListProperties(
                this.deptDAO.selectList(wrapper), DeptDTO::new); // 集合数据拷贝
        return allDepts;
    }

    @Override
    public Map<String, Object> split(int currentPage, int lineSize, String column, String keyword) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.like(column, keyword); // 设置模糊查询操作
        int count = this.deptDAO.selectCount(wrapper).intValue(); // 统计个数
        // 实现数据的查询处理
        IPage<Dept> page = this.deptDAO.selectPage(new Page<>(currentPage, lineSize, count), wrapper);
        Map<String, Object> map = new HashMap<>(); // 包装返回结果
        map.put("allDepts", DeepBeanUtils.copyListProperties(page.getRecords(), DeptDTO::new));
        map.put("allRecorders", page.getTotal());
        map.put("allPages", page.getPages());
        return map;
    }
}
