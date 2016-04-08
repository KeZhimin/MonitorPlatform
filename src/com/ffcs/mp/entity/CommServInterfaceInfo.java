package com.ffcs.mp.entity;

import java.util.Date;

public class CommServInterfaceInfo {
    private Integer interfaceId;

    private Integer servId;

    private String interfaceTitle;

    private String interfaceName;

    private Short isMonitor;

    private Short isEncry;

    private Short isTest;

    private Integer intervalDelay;

    private Short timeoutValue;

    private Short timeoutRetryNum;

    private String testInputData;

    private String checkData;

    private Short preciseCheck;

    private String testOutputData;

    private Date ctime;

    private Date utime;

    private Integer updateAutor;

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Integer getServId() {
        return servId;
    }

    public void setServId(Integer servId) {
        this.servId = servId;
    }

    public String getInterfaceTitle() {
        return interfaceTitle;
    }

    public void setInterfaceTitle(String interfaceTitle) {
        this.interfaceTitle = interfaceTitle;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Short getIsMonitor() {
        return isMonitor;
    }

    public void setIsMonitor(Short isMonitor) {
        this.isMonitor = isMonitor;
    }

    public Short getIsEncry() {
        return isEncry;
    }

    public void setIsEncry(Short isEncry) {
        this.isEncry = isEncry;
    }

    public Short getIsTest() {
        return isTest;
    }

    public void setIsTest(Short isTest) {
        this.isTest = isTest;
    }

    public Integer getIntervalDelay() {
        return intervalDelay;
    }

    public void setIntervalDelay(Integer intervalDelay) {
        this.intervalDelay = intervalDelay;
    }

    public Short getTimeoutValue() {
        return timeoutValue;
    }

    public void setTimeoutValue(Short timeoutValue) {
        this.timeoutValue = timeoutValue;
    }

    public Short getTimeoutRetryNum() {
        return timeoutRetryNum;
    }

    public void setTimeoutRetryNum(Short timeoutRetryNum) {
        this.timeoutRetryNum = timeoutRetryNum;
    }

    public String getTestInputData() {
        return testInputData;
    }

    public void setTestInputData(String testInputData) {
        this.testInputData = testInputData;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

    public Short getPreciseCheck() {
        return preciseCheck;
    }

    public void setPreciseCheck(Short preciseCheck) {
        this.preciseCheck = preciseCheck;
    }

    public String getTestOutputData() {
        return testOutputData;
    }

    public void setTestOutputData(String testOutputData) {
        this.testOutputData = testOutputData;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Integer getUpdateAutor() {
        return updateAutor;
    }

    public void setUpdateAutor(Integer updateAutor) {
        this.updateAutor = updateAutor;
    }
}