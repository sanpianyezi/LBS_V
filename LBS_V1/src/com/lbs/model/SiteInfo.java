package com.lbs.model;

import java.math.BigDecimal;

public class SiteInfo {
    private Long id;

    private Long siteCode;

    private String siteType;

    private String siteName;

    private String serviceGroup;

    private String voltageGrade;

    private String workTime;

    private String isIntelligent;

    private String isHub;

    private String siteLevel;

    private String dutyType;

    private String agentService;

    private String cablingType;

    private String contaminationLevel;

    private String siteAddr;

    private BigDecimal areaCovered;

    private BigDecimal buildingArea;

    private String regionFeatures;

    private String contactTel;

    private String shortName;

    private String equipmentOwner;

    private String remark;

    private BigDecimal totalCapacity;

    private Short equipmentNum;

    private String importantDegree;

    private String isUnderground;

    private String isIndependent;

    private String preventionType;

    private String hasRingNetwork;

    private Long compensateCapacity;

    private String equipmentCode;

    private String state;

    private BigDecimal longitudePoint;

    private BigDecimal latitudePoint;

    private String createTime;

    private String updateTime;

    private Long userId;

    private String imagePath;

    private String belongArea;

    private String comeFrom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(Long siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType == null ? null : siteType.trim();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup == null ? null : serviceGroup.trim();
    }

    public String getVoltageGrade() {
        return voltageGrade;
    }

    public void setVoltageGrade(String voltageGrade) {
        this.voltageGrade = voltageGrade == null ? null : voltageGrade.trim();
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }

    public String getIsIntelligent() {
        return isIntelligent;
    }

    public void setIsIntelligent(String isIntelligent) {
        this.isIntelligent = isIntelligent == null ? null : isIntelligent.trim();
    }

    public String getIsHub() {
        return isHub;
    }

    public void setIsHub(String isHub) {
        this.isHub = isHub == null ? null : isHub.trim();
    }

    public String getSiteLevel() {
        return siteLevel;
    }

    public void setSiteLevel(String siteLevel) {
        this.siteLevel = siteLevel == null ? null : siteLevel.trim();
    }

    public String getDutyType() {
        return dutyType;
    }

    public void setDutyType(String dutyType) {
        this.dutyType = dutyType == null ? null : dutyType.trim();
    }

    public String getAgentService() {
        return agentService;
    }

    public void setAgentService(String agentService) {
        this.agentService = agentService == null ? null : agentService.trim();
    }

    public String getCablingType() {
        return cablingType;
    }

    public void setCablingType(String cablingType) {
        this.cablingType = cablingType == null ? null : cablingType.trim();
    }

    public String getContaminationLevel() {
        return contaminationLevel;
    }

    public void setContaminationLevel(String contaminationLevel) {
        this.contaminationLevel = contaminationLevel == null ? null : contaminationLevel.trim();
    }

    public String getSiteAddr() {
        return siteAddr;
    }

    public void setSiteAddr(String siteAddr) {
        this.siteAddr = siteAddr == null ? null : siteAddr.trim();
    }

    public BigDecimal getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(BigDecimal areaCovered) {
        this.areaCovered = areaCovered;
    }

    public BigDecimal getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(BigDecimal buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getRegionFeatures() {
        return regionFeatures;
    }

    public void setRegionFeatures(String regionFeatures) {
        this.regionFeatures = regionFeatures == null ? null : regionFeatures.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getEquipmentOwner() {
        return equipmentOwner;
    }

    public void setEquipmentOwner(String equipmentOwner) {
        this.equipmentOwner = equipmentOwner == null ? null : equipmentOwner.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(BigDecimal totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Short getEquipmentNum() {
        return equipmentNum;
    }

    public void setEquipmentNum(Short equipmentNum) {
        this.equipmentNum = equipmentNum;
    }

    public String getImportantDegree() {
        return importantDegree;
    }

    public void setImportantDegree(String importantDegree) {
        this.importantDegree = importantDegree == null ? null : importantDegree.trim();
    }

    public String getIsUnderground() {
        return isUnderground;
    }

    public void setIsUnderground(String isUnderground) {
        this.isUnderground = isUnderground == null ? null : isUnderground.trim();
    }

    public String getIsIndependent() {
        return isIndependent;
    }

    public void setIsIndependent(String isIndependent) {
        this.isIndependent = isIndependent == null ? null : isIndependent.trim();
    }

    public String getPreventionType() {
        return preventionType;
    }

    public void setPreventionType(String preventionType) {
        this.preventionType = preventionType == null ? null : preventionType.trim();
    }

    public String getHasRingNetwork() {
        return hasRingNetwork;
    }

    public void setHasRingNetwork(String hasRingNetwork) {
        this.hasRingNetwork = hasRingNetwork == null ? null : hasRingNetwork.trim();
    }

    public Long getCompensateCapacity() {
        return compensateCapacity;
    }

    public void setCompensateCapacity(Long compensateCapacity) {
        this.compensateCapacity = compensateCapacity;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public BigDecimal getLongitudePoint() {
        return longitudePoint;
    }

    public void setLongitudePoint(BigDecimal longitudePoint) {
        this.longitudePoint = longitudePoint;
    }

    public BigDecimal getLatitudePoint() {
        return latitudePoint;
    }

    public void setLatitudePoint(BigDecimal latitudePoint) {
        this.latitudePoint = latitudePoint;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public String getBelongArea() {
        return belongArea;
    }

    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea == null ? null : belongArea.trim();
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom == null ? null : comeFrom.trim();
    }
}