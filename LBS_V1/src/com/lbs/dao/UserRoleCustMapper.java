package com.lbs.dao;

import com.lbs.model.FuncInfo;
import com.lbs.model.UserRoleMap;
import com.lbs.model.UserRoleMapExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserRoleCustMapper {
    

    List<FuncInfo> selectFuncByUserId(Long userId);

  
}