package com.lbs.vo;

import java.util.List;

import com.lbs.model.FuncInfo;

public class FuncInfoVO {
	private Long funcId;

    private String funcName;

    private String funcType;

    private String funcStat;

    private Long funcParentId;

    private String funcDesc;

    private String hasChild;

    private String createTime;

    private String updateTime;
    
    private List<FuncInfo> funcInfoList;

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
		this.funcName = funcName;
	}

	public String getFuncType() {
		return funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getFuncStat() {
		return funcStat;
	}

	public void setFuncStat(String funcStat) {
		this.funcStat = funcStat;
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
		this.funcDesc = funcDesc;
	}

	public String getHasChild() {
		return hasChild;
	}

	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public List<FuncInfo> getFuncInfoList() {
		return funcInfoList;
	}

	public void setFuncInfoList(List<FuncInfo> funcInfoList) {
		this.funcInfoList = funcInfoList;
	}
    
    
    
    

}
