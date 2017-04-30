package com.lbs.dao;

import com.lbs.model.UserSiteMap;
import com.lbs.model.UserSiteMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSiteMapMapper {
    int countByExample(UserSiteMapExample example);

    int deleteByExample(UserSiteMapExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserSiteMap record);

    int insertSelective(UserSiteMap record);

    List<UserSiteMap> selectByExample(UserSiteMapExample example);

    UserSiteMap selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserSiteMap record, @Param("example") UserSiteMapExample example);

    int updateByExample(@Param("record") UserSiteMap record, @Param("example") UserSiteMapExample example);

    int updateByPrimaryKeySelective(UserSiteMap record);

    int updateByPrimaryKey(UserSiteMap record);
}