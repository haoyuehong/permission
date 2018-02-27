package com.hz1202.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.hz1202.dao.SysDeptMapper;
import com.hz1202.dto.DeptLevelDto;
import com.hz1202.model.SysDept;
import com.hz1202.utils.LevelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysTreeService {
    @Autowired
    private SysDeptMapper deptMapper;

    public List<DeptLevelDto> deptTree(){
        List<SysDept> deptList = deptMapper.getAll();
        List<DeptLevelDto> deptLevelDtos = new ArrayList<>();
        for(SysDept dept : deptList){
            DeptLevelDto dto = DeptLevelDto.adapt(dept);
            deptLevelDtos.add(dto);
        }
        return deptListTree(deptLevelDtos);
    }


    public List<DeptLevelDto> deptListTree(List<DeptLevelDto> deptLevelList){
        if(CollectionUtils.isEmpty(deptLevelList)){
            return Lists.newArrayList();//等价于new ArrayList();
        }
        Multimap<String,DeptLevelDto> levelDeptMap = ArrayListMultimap.create();
        //以上代码等价于
        //Map<String,List<DeptLevelDto>> levelDeptMap = new HashMap<>();
        List<DeptLevelDto> rootList =  Lists.newArrayList();
        //List<DeptLevelDto> levelDtos = new ArrayList<>();
        for(DeptLevelDto dto : deptLevelList){
            levelDeptMap.put(dto.getLevle(),dto);
            //以上代码等价于
            //levelDtos.add(dto);
            //levelDeptMap.put(dto.getLevle(),levelDtos);
            if(LevelUtil.ROOT.equals(dto.getLevle())){
                rootList.add(dto);
            }
        }
        //排序 按照seq从小到大排序
        Collections.sort(rootList, new Comparator<DeptLevelDto>() {
            @Override
            public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });
        //递归生成树
        transformDeptTree(deptLevelList,LevelUtil.ROOT,levelDeptMap);
        return rootList;
    }

    public void transformDeptTree(List<DeptLevelDto> deptLevelList,String level, Multimap<String,DeptLevelDto> levelDeptMap){
        for(int i = 0; i < deptLevelList.size(); i++){
            //遍历该层元素
            DeptLevelDto dto = deptLevelList.get(i);
            //处理当前层级
            String nextLevel = LevelUtil.calculateLevel(level,dto.getId());
            //处理下一层
            List<DeptLevelDto> tempDeptDtoList = (List<DeptLevelDto>)levelDeptMap.get(nextLevel);
            if(CollectionUtils.isNotEmpty(tempDeptDtoList)){
                //排序
                Collections.sort(tempDeptDtoList, new Comparator<DeptLevelDto>() {
                    @Override
                    public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                        return o1.getSeq() - o2.getSeq();
                    }
                });
                //设置下一层部门
                dto.setDeptList(tempDeptDtoList);

                //进入到下一层处理
                transformDeptTree(tempDeptDtoList,nextLevel,levelDeptMap);
            }
        }
    }
}
