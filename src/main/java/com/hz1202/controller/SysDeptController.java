package com.hz1202.controller;

import com.hz1202.common.JsonData;
import com.hz1202.dto.DeptLevelDto;
import com.hz1202.param.DeptParam;
import com.hz1202.service.SysDeptService;
import com.hz1202.service.SysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门控制器
 */
@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {
    @Autowired
    private SysDeptService deptService;
    @Autowired
    private SysTreeService treeService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveDept(DeptParam deptParam){
        deptService.save(deptParam);
        return JsonData.createSuccess("添加成功");
    }

    @RequestMapping("/deptTree.json")
    @ResponseBody
    public JsonData deptTree(){
        List<DeptLevelDto> deptLevelDtos = treeService.deptTree();
        return JsonData.createSuccess(deptLevelDtos);
    }


    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateDept(DeptParam deptParam){
        deptService.update(deptParam);
        return JsonData.createError("更新成功");
    }


}
