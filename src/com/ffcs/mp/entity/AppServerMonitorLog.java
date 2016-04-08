package com.ffcs.mp.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AppServerMonitorLog {
    private Long logId;

    private Integer severId;

    private Integer idxItemId;

    private BigDecimal idxItemValue;

    private Date ctime;

    private String isAlarm;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Integer getSeverId() {
        return severId;
    }

    public void setSeverId(Integer severId) {
        this.severId = severId;
    }

    public Integer getIdxItemId() {
        return idxItemId;
    }

    public void setIdxItemId(Integer idxItemId) {
        this.idxItemId = idxItemId;
    }

    public BigDecimal getIdxItemValue() {
        return idxItemValue;
    }

    public void setIdxItemValue(BigDecimal idxItemValue) {
        this.idxItemValue = idxItemValue;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getIsAlarm() {
        return isAlarm;
    }

    public void setIsAlarm(String isAlarm) {
        this.isAlarm = isAlarm;
    }
}