package com.lbs.dao;

import com.lbs.model.SiteInfo;
import com.lbs.model.SiteInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SiteInfoMapper {
    int countByExample(SiteInfoExample example);

    int deleteByExample(SiteInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SiteInfo record);

    int insertSelective(SiteInfo record);

    List<SiteInfo> selectByExample(SiteInfoExample example);

    SiteInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SiteInfo record, @Param("example") SiteInfoExample example);

    int updateByExample(@Param("record") SiteInfo record, @Param("example") SiteInfoExample example);

    int updateByPrimaryKeySelective(SiteInfo record);

    int updateByPrimaryKey(SiteInfo record);
}