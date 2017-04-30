package com.lbs.dao;

import com.lbs.model.UserTrajectory;
import com.lbs.model.UserTrajectoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTrajectoryMapper {
    int countByExample(UserTrajectoryExample example);

    int deleteByExample(UserTrajectoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTrajectory record);

    int insertSelective(UserTrajectory record);

    List<UserTrajectory> selectByExample(UserTrajectoryExample example);

    UserTrajectory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTrajectory record, @Param("example") UserTrajectoryExample example);

    int updateByExample(@Param("record") UserTrajectory record, @Param("example") UserTrajectoryExample example);

    int updateByPrimaryKeySelective(UserTrajectory record);

    int updateByPrimaryKey(UserTrajectory record);
}