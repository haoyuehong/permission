package com.hz1202.model;

import java.io.Serializable;
import java.util.Date;

public class SysAclModule implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module. id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.level
     *
     * @mbg.generated
     */
    private String level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.parent_id
     *
     * @mbg.generated
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.operator
     *
     * @mbg.generated
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.operate_time
     *
     * @mbg.generated
     */
    private Date operateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.operate_ip
     *
     * @mbg.generated
     */
    private String operateIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_acl_module.sep
     *
     * @mbg.generated
     */
    private Integer sep;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_acl_module
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module. id
     *
     * @return the value of sys_acl_module. id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module. id
     *
     * @param id the value for sys_acl_module. id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.name
     *
     * @return the value of sys_acl_module.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.name
     *
     * @param name the value for sys_acl_module.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.level
     *
     * @return the value of sys_acl_module.level
     *
     * @mbg.generated
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.level
     *
     * @param level the value for sys_acl_module.level
     *
     * @mbg.generated
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.parent_id
     *
     * @return the value of sys_acl_module.parent_id
     *
     * @mbg.generated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.parent_id
     *
     * @param parentId the value for sys_acl_module.parent_id
     *
     * @mbg.generated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.status
     *
     * @return the value of sys_acl_module.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.status
     *
     * @param status the value for sys_acl_module.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.remark
     *
     * @return the value of sys_acl_module.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.remark
     *
     * @param remark the value for sys_acl_module.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.operator
     *
     * @return the value of sys_acl_module.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.operator
     *
     * @param operator the value for sys_acl_module.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.operate_time
     *
     * @return the value of sys_acl_module.operate_time
     *
     * @mbg.generated
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.operate_time
     *
     * @param operateTime the value for sys_acl_module.operate_time
     *
     * @mbg.generated
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.operate_ip
     *
     * @return the value of sys_acl_module.operate_ip
     *
     * @mbg.generated
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.operate_ip
     *
     * @param operateIp the value for sys_acl_module.operate_ip
     *
     * @mbg.generated
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_acl_module.sep
     *
     * @return the value of sys_acl_module.sep
     *
     * @mbg.generated
     */
    public Integer getSep() {
        return sep;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_acl_module.sep
     *
     * @param sep the value for sys_acl_module.sep
     *
     * @mbg.generated
     */
    public void setSep(Integer sep) {
        this.sep = sep;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_acl_module
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", parentId=").append(parentId);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", operator=").append(operator);
        sb.append(", operateTime=").append(operateTime);
        sb.append(", operateIp=").append(operateIp);
        sb.append(", sep=").append(sep);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}