package com.lbs.dao;

import com.lbs.model.FuncInfo;
import com.lbs.model.FuncInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FuncInfoMapper {
    int countByExample(FuncInfoExample example);

    int deleteByExample(FuncInfoExample example);

    int deleteByPrimaryKey(Long funcId);

    int insert(FuncInfo record);

    int insertSelective(FuncInfo record);

    List<FuncInfo> selectByExample(FuncInfoExample example);

    FuncInfo selectByPrimaryKey(Long funcId);

    int updateByExampleSelective(@Param("record") FuncInfo record, @Param("example") FuncInfoExample example);

    int updateByExample(@Param("record") FuncInfo record, @Param("example") FuncInfoExample example);

    int updateByPrimaryKeySelective(FuncInfo record);

    int updateByPrimaryKey(FuncInfo record);
}