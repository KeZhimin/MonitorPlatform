package com.ffcs.mp.entity;

public class CommSeverIdxItem {
    private Integer idxItemId;

    private String idxItemName;

    private String idxItmeUnit;

    private Long idxDefaultValue;

    private Short idxItmeType;

    public Integer getIdxItemId() {
        return idxItemId;
    }

    public void setIdxItemId(Integer idxItemId) {
        this.idxItemId = idxItemId;
    }

    public String getIdxItemName() {
        return idxItemName;
    }

    public void setIdxItemName(String idxItemName) {
        this.idxItemName = idxItemName;
    }

    public String getIdxItmeUnit() {
        return idxItmeUnit;
    }

    public void setIdxItmeUnit(String idxItmeUnit) {
        this.idxItmeUnit = idxItmeUnit;
    }

    public Long getIdxDefaultValue() {
        return idxDefaultValue;
    }

    public void setIdxDefaultValue(Long idxDefaultValue) {
        this.idxDefaultValue = idxDefaultValue;
    }

    public Short getIdxItmeType() {
        return idxItmeType;
    }

    public void setIdxItmeType(Short idxItmeType) {
        this.idxItmeType = idxItmeType;
    }
}