package com.lbs.dao;

import java.util.List;

import com.lbs.model.UserInfo;

public interface UserInfoCustMapper {

    UserInfo selectByUserName(String userName);
    List<Long> selectChildUserListByParentId(Long parentId);
}