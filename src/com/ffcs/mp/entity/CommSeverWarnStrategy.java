package com.ffcs.mp.entity;

public class CommSeverWarnStrategy {
    private Long strategyId;

    private Long servId;

    private Integer idxItemId;

    private String logicOperator;

    private Long strategyValue;

    private Short isEnable;

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Long getServId() {
        return servId;
    }

    public void setServId(Long servId) {
        this.servId = servId;
    }

    public Integer getIdxItemId() {
        return idxItemId;
    }

    public void setIdxItemId(Integer idxItemId) {
        this.idxItemId = idxItemId;
    }

    public String getLogicOperator() {
        return logicOperator;
    }

    public void setLogicOperator(String logicOperator) {
        this.logicOperator = logicOperator;
    }

    public Long getStrategyValue() {
        return strategyValue;
    }

    public void setStrategyValue(Long strategyValue) {
        this.strategyValue = strategyValue;
    }

    public Short getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Short isEnable) {
        this.isEnable = isEnable;
    }
}