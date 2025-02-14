package com.xinshi.provider.controller;

import com.xinshi.common.dto.DeptDTO;
import com.xinshi.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: xbronze
 * @date: 2025-02-14 11:39
 * @description: TODO
 */
@RestController
@RequestMapping("/provider/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;
    @GetMapping("get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.deptService.get(id);
    }
    @PostMapping("add")
    public Object add(@RequestBody DeptDTO deptDTO) {    // 后面会修改参数模式为JSON
        return this.deptService.add(deptDTO);
    }
    @GetMapping("list")
    public Object list() {
        return this.deptService.list();
    }
    @GetMapping("split")
    public Object split(int cp, int ls, String col, String kw) {
        return this.deptService.split(cp, ls, col, kw);
    }

}
