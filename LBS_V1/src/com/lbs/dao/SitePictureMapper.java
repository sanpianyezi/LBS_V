package com.lbs.dao;

import com.lbs.model.SitePicture;
import com.lbs.model.SitePictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SitePictureMapper {
    int countByExample(SitePictureExample example);

    int deleteByExample(SitePictureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SitePicture record);

    int insertSelective(SitePicture record);

    List<SitePicture> selectByExample(SitePictureExample example);

    SitePicture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SitePicture record, @Param("example") SitePictureExample example);

    int updateByExample(@Param("record") SitePicture record, @Param("example") SitePictureExample example);

    int updateByPrimaryKeySelective(SitePicture record);

    int updateByPrimaryKey(SitePicture record);
}