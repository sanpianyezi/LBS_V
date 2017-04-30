package com.lbs.dao;

import com.lbs.model.SiteInfo;
import com.lbs.model.SiteInfoExample;
import com.lbs.vo.SiteInfoVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SiteInfoCustMapper {
    
	/**
	 * 绑定的
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
    List<SiteInfoVO> selectListByUserId(@Param("id")Long userId,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
   /**
    * 所有的
    * @param siteInfoVO
    * @return
    */
    List<SiteInfoVO> selectALLSiteList(SiteInfoVO siteInfoVO);

    /**
     * 区域列表
     * @return
     */
    List<String> selectSiteAreaList();
    
}