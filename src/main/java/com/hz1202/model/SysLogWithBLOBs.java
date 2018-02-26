package com.hz1202.model;

import java.io.Serializable;

public class SysLogWithBLOBs extends SysLog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.old_value
     *
     * @mbg.generated
     */
    private String oldValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_log.new_value
     *
     * @mbg.generated
     */
    private String newValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_log
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.old_value
     *
     * @return the value of sys_log.old_value
     *
     * @mbg.generated
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.old_value
     *
     * @param oldValue the value for sys_log.old_value
     *
     * @mbg.generated
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue == null ? null : oldValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_log.new_value
     *
     * @return the value of sys_log.new_value
     *
     * @mbg.generated
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_log.new_value
     *
     * @param newValue the value for sys_log.new_value
     *
     * @mbg.generated
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue == null ? null : newValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oldValue=").append(oldValue);
        sb.append(", newValue=").append(newValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}