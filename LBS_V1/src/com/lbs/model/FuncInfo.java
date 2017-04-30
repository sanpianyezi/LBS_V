package com.lbs.model;

public class FuncInfo {
    private Long funcId;

    private String funcName;

    private String funcType;

    private String funcStat;

    private Long funcParentId;

    private String funcDesc;

    private String hasChild;

    private String createTime;

    private String updateTime;

    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType == null ? null : funcType.trim();
    }

    public String getFuncStat() {
        return funcStat;
    }

    public void setFuncStat(String funcStat) {
        this.funcStat = funcStat == null ? null : funcStat.trim();
    }

    public Long getFuncParentId() {
        return funcParentId;
    }

    public void setFuncParentId(Long funcParentId) {
        this.funcParentId = funcParentId;
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc == null ? null : funcDesc.trim();
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild == null ? null : hasChild.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}