package com.hz1202.service;

import com.hz1202.dao.SysDeptMapper;
import com.hz1202.exception.ParamException;
import com.hz1202.model.SysDept;
import com.hz1202.param.DeptParam;
import com.hz1202.utils.BeanValidator;
import com.hz1202.utils.LevelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysDeptService {
    @Autowired
    private SysDeptMapper deptMapper;

    /**
     * 新增部门
     * @param param
     */
    public void save(DeptParam param){
        BeanValidator.check(param);
        if(checkExit(param.getName(),param.getParentId(),param.getId())){
            throw new ParamException("当前同一层级下从在相同名称的部门");
        }
        SysDept dept =  new SysDept();
        BeanUtils.copyProperties(param,dept);
        dept.setLevle(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()));
        dept.setOperator("SYSTEM");
        dept.setOperatorIp("127.0.0.1");
        dept.setOperatorTime(new Date());
        deptMapper.insertSelective(dept);
    }

    /**
     * 校验部门是否存在
     * @param name 部门名称
     * @param parentId 上机部门id
     * @param deptId 部门id
     * @return true or false
     */
    private boolean checkExit(String name, Integer parentId, Integer deptId){
        //TODO:
        return true;
    }
    private String getLevel(Integer deptId){
        SysDept dept = deptMapper.selectByPrimaryKey(deptId);
        if(dept == null){
            return null;
        }
        return dept.getLevle();
    }

}
