package com.hz1202.service;

import com.google.common.base.Preconditions;
import com.hz1202.dao.SysDeptMapper;
import com.hz1202.exception.ParamException;
import com.hz1202.model.SysDept;
import com.hz1202.param.DeptParam;
import com.hz1202.utils.BeanValidator;
import com.hz1202.utils.LevelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
     * 更新部门
     * @param param
     */
    public void update(DeptParam param){
        //参数校验
        BeanValidator.check(param);
        if(checkExit(param.getName(),param.getParentId(),param.getId())){
            throw new ParamException("当前同一层级下从在相同名称的部门");
        }
        SysDept before = deptMapper.selectByPrimaryKey(param.getId());
        //判断before是否为空
        Preconditions.checkNotNull(before,"待更新部门不存在");
        //以上语句等价于
        //if(before == null){
        //    throw new ParamException("待更新部门不存在");
        //}
        //判断修改后同一层级下是否有名称相同的部门
        if(checkExit(param.getName(),param.getParentId(),param.getId())){
            throw new ParamException("同一层级下具有相同名称的部门");
        }
        SysDept after = new SysDept();
        BeanUtils.copyProperties(param,after);
        after.setLevle(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()));
        after.setOperatorTime(new Date());
        after.setOperator("SYSTEM");
        after.setOperatorIp("127.0.0.1");
        updateWithChild(before,after);
    }

    @Transactional
    public void updateWithChild(SysDept before,SysDept after){
        //子部门新前缀
        String newLevelPrefix = after.getLevle();
        //子部门旧前缀
        String oldLevelLevelPrefix = before.getLevle();
        if(!after.getLevle().equals(before.getLevle())){
            List<SysDept> deptList = deptMapper.getChildDeptListByLevel(before.getLevle());
            if(CollectionUtils.isNotEmpty(deptList)){
                for(SysDept sysDept: deptList){
                    String level = sysDept.getLevle();
                    if(level.indexOf(oldLevelLevelPrefix) == 0){
                        level = newLevelPrefix + level.substring(oldLevelLevelPrefix.length());
                        sysDept.setLevle(level);
                    }
                }
                //批量更新子部门列表
                deptMapper.bachUpdateDept(deptList);
            }
        }
        //更新当前部门
        deptMapper.updateByPrimaryKey(after);
    }

    /**
     * 校验部门是否存在
     * @param name 部门名称
     * @param parentId 上机部门id
     * @param deptId 部门id
     * @return true or false
     */
    private boolean checkExit(String name, Integer parentId, Integer deptId){
        return deptMapper.countByNameAndParentId(parentId,name,deptId) >  0;
    }


    private String getLevel(Integer deptId){
        SysDept dept = deptMapper.selectByPrimaryKey(deptId);
        if(dept == null){
            return null;
        }
        return dept.getLevle();
    }

}
