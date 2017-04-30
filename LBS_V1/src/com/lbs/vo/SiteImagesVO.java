package com.lbs.vo;


public class SiteImagesVO {

    private Long siteId;

    private String siteImages;

    private Long images1Id;

    private Long images2Id;
    
    private String images1Path;
    
    private String images2Path;

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getSiteImages() {
		return siteImages;
	}

	public void setSiteImages(String siteImages) {
		this.siteImages = siteImages;
	}

	public Long getImages1Id() {
		return images1Id;
	}

	public void setImages1Id(Long images1Id) {
		this.images1Id = images1Id;
	}

	public Long getImages2Id() {
		return images2Id;
	}

	public void setImages2Id(Long images2Id) {
		this.images2Id = images2Id;
	}

	public String getImages1Path() {
		return images1Path;
	}

	public void setImages1Path(String images1Path) {
		this.images1Path = images1Path;
	}

	public String getImages2Path() {
		return images2Path;
	}

	public void setImages2Path(String images2Path) {
		this.images2Path = images2Path;
	}

   
}