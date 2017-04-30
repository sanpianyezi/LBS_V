package com.lbs.dao;

import com.lbs.model.SitePicture;
import com.lbs.model.SitePictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SitePictureCustMapper {

    SitePicture selectBySiteIdAndType(SitePicture example);

}