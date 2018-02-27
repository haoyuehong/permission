package com.hz1202.dto;

import com.hz1202.model.SysDept;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeptLevelDto extends SysDept {
    private List<DeptLevelDto> deptList = new ArrayList<>();
    public static DeptLevelDto adapt(SysDept dept){
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(dept,dto);
        return dto;
    }
}
