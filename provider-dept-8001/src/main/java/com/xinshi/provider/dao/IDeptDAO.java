package com.xinshi.provider.dao;

import com.xinshi.common.dto.DeptDTO;
import com.xinshi.service.IDeptService;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinshi.provider.vo.Dept;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author: xbronze
 * @date: 2025-02-14 11:33
 * @description: TODO
 */
@Mapper
public interface IDeptDAO extends BaseMapper<Dept> { // DAO接口开发完成
}
