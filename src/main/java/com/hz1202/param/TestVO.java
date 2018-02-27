package com.hz1202.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Author: mol
 * @Description:
 * @Date: create in 10:26 2018/2/27
 */
@Setter
@Getter
public class TestVO {
    @NotBlank
    private String msg;
    @NotNull
    private Integer id;
}
