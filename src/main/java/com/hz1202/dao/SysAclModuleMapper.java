package com.hz1202.dao;

import com.hz1202.model.SysAclModule;

public interface SysAclModuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl_module
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl_module
     *
     * @mbg.generated
     */
    int insert(SysAclModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl_module
     *
     * @mbg.generated
     */
    int insertSelective(SysAclModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl_module
     *
     * @mbg.generated
     */
    SysAclModule selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl_module
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysAclModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl_module
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysAclModule record);
}