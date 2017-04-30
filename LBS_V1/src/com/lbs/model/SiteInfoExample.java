package com.lbs.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SiteInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SiteInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSiteCodeIsNull() {
            addCriterion("site_code is null");
            return (Criteria) this;
        }

        public Criteria andSiteCodeIsNotNull() {
            addCriterion("site_code is not null");
            return (Criteria) this;
        }

        public Criteria andSiteCodeEqualTo(Long value) {
            addCriterion("site_code =", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeNotEqualTo(Long value) {
            addCriterion("site_code <>", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeGreaterThan(Long value) {
            addCriterion("site_code >", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("site_code >=", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeLessThan(Long value) {
            addCriterion("site_code <", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeLessThanOrEqualTo(Long value) {
            addCriterion("site_code <=", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeIn(List<Long> values) {
            addCriterion("site_code in", values, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeNotIn(List<Long> values) {
            addCriterion("site_code not in", values, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeBetween(Long value1, Long value2) {
            addCriterion("site_code between", value1, value2, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeNotBetween(Long value1, Long value2) {
            addCriterion("site_code not between", value1, value2, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteTypeIsNull() {
            addCriterion("site_type is null");
            return (Criteria) this;
        }

        public Criteria andSiteTypeIsNotNull() {
            addCriterion("site_type is not null");
            return (Criteria) this;
        }

        public Criteria andSiteTypeEqualTo(String value) {
            addCriterion("site_type =", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeNotEqualTo(String value) {
            addCriterion("site_type <>", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeGreaterThan(String value) {
            addCriterion("site_type >", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("site_type >=", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeLessThan(String value) {
            addCriterion("site_type <", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeLessThanOrEqualTo(String value) {
            addCriterion("site_type <=", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeLike(String value) {
            addCriterion("site_type like", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeNotLike(String value) {
            addCriterion("site_type not like", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeIn(List<String> values) {
            addCriterion("site_type in", values, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeNotIn(List<String> values) {
            addCriterion("site_type not in", values, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeBetween(String value1, String value2) {
            addCriterion("site_type between", value1, value2, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeNotBetween(String value1, String value2) {
            addCriterion("site_type not between", value1, value2, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNull() {
            addCriterion("site_name is null");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNotNull() {
            addCriterion("site_name is not null");
            return (Criteria) this;
        }

        public Criteria andSiteNameEqualTo(String value) {
            addCriterion("site_name =", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotEqualTo(String value) {
            addCriterion("site_name <>", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThan(String value) {
            addCriterion("site_name >", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("site_name >=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThan(String value) {
            addCriterion("site_name <", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("site_name <=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLike(String value) {
            addCriterion("site_name like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotLike(String value) {
            addCriterion("site_name not like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameIn(List<String> values) {
            addCriterion("site_name in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotIn(List<String> values) {
            addCriterion("site_name not in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameBetween(String value1, String value2) {
            addCriterion("site_name between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("site_name not between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIsNull() {
            addCriterion("service_group is null");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIsNotNull() {
            addCriterion("service_group is not null");
            return (Criteria) this;
        }

        public Criteria andServiceGroupEqualTo(String value) {
            addCriterion("service_group =", value, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupNotEqualTo(String value) {
            addCriterion("service_group <>", value, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupGreaterThan(String value) {
            addCriterion("service_group >", value, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupGreaterThanOrEqualTo(String value) {
            addCriterion("service_group >=", value, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupLessThan(String value) {
            addCriterion("service_group <", value, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupLessThanOrEqualTo(String value) {
            addCriterion("service_group <=", value, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupLike(String value) {
            addCriterion("service_group like", value, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupNotLike(String value) {
            addCriterion("service_group not like", value, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIn(List<String> values) {
            addCriterion("service_group in", values, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupNotIn(List<String> values) {
            addCriterion("service_group not in", values, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupBetween(String value1, String value2) {
            addCriterion("service_group between", value1, value2, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andServiceGroupNotBetween(String value1, String value2) {
            addCriterion("service_group not between", value1, value2, "serviceGroup");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeIsNull() {
            addCriterion("voltage_grade is null");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeIsNotNull() {
            addCriterion("voltage_grade is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeEqualTo(String value) {
            addCriterion("voltage_grade =", value, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeNotEqualTo(String value) {
            addCriterion("voltage_grade <>", value, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeGreaterThan(String value) {
            addCriterion("voltage_grade >", value, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeGreaterThanOrEqualTo(String value) {
            addCriterion("voltage_grade >=", value, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeLessThan(String value) {
            addCriterion("voltage_grade <", value, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeLessThanOrEqualTo(String value) {
            addCriterion("voltage_grade <=", value, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeLike(String value) {
            addCriterion("voltage_grade like", value, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeNotLike(String value) {
            addCriterion("voltage_grade not like", value, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeIn(List<String> values) {
            addCriterion("voltage_grade in", values, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeNotIn(List<String> values) {
            addCriterion("voltage_grade not in", values, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeBetween(String value1, String value2) {
            addCriterion("voltage_grade between", value1, value2, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andVoltageGradeNotBetween(String value1, String value2) {
            addCriterion("voltage_grade not between", value1, value2, "voltageGrade");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNull() {
            addCriterion("work_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNotNull() {
            addCriterion("work_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEqualTo(String value) {
            addCriterion("work_time =", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotEqualTo(String value) {
            addCriterion("work_time <>", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThan(String value) {
            addCriterion("work_time >", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("work_time >=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThan(String value) {
            addCriterion("work_time <", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThanOrEqualTo(String value) {
            addCriterion("work_time <=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLike(String value) {
            addCriterion("work_time like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotLike(String value) {
            addCriterion("work_time not like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIn(List<String> values) {
            addCriterion("work_time in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotIn(List<String> values) {
            addCriterion("work_time not in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeBetween(String value1, String value2) {
            addCriterion("work_time between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotBetween(String value1, String value2) {
            addCriterion("work_time not between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentIsNull() {
            addCriterion("is_intelligent is null");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentIsNotNull() {
            addCriterion("is_intelligent is not null");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentEqualTo(String value) {
            addCriterion("is_intelligent =", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentNotEqualTo(String value) {
            addCriterion("is_intelligent <>", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentGreaterThan(String value) {
            addCriterion("is_intelligent >", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentGreaterThanOrEqualTo(String value) {
            addCriterion("is_intelligent >=", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentLessThan(String value) {
            addCriterion("is_intelligent <", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentLessThanOrEqualTo(String value) {
            addCriterion("is_intelligent <=", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentLike(String value) {
            addCriterion("is_intelligent like", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentNotLike(String value) {
            addCriterion("is_intelligent not like", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentIn(List<String> values) {
            addCriterion("is_intelligent in", values, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentNotIn(List<String> values) {
            addCriterion("is_intelligent not in", values, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentBetween(String value1, String value2) {
            addCriterion("is_intelligent between", value1, value2, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentNotBetween(String value1, String value2) {
            addCriterion("is_intelligent not between", value1, value2, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsHubIsNull() {
            addCriterion("is_hub is null");
            return (Criteria) this;
        }

        public Criteria andIsHubIsNotNull() {
            addCriterion("is_hub is not null");
            return (Criteria) this;
        }

        public Criteria andIsHubEqualTo(String value) {
            addCriterion("is_hub =", value, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubNotEqualTo(String value) {
            addCriterion("is_hub <>", value, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubGreaterThan(String value) {
            addCriterion("is_hub >", value, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubGreaterThanOrEqualTo(String value) {
            addCriterion("is_hub >=", value, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubLessThan(String value) {
            addCriterion("is_hub <", value, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubLessThanOrEqualTo(String value) {
            addCriterion("is_hub <=", value, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubLike(String value) {
            addCriterion("is_hub like", value, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubNotLike(String value) {
            addCriterion("is_hub not like", value, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubIn(List<String> values) {
            addCriterion("is_hub in", values, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubNotIn(List<String> values) {
            addCriterion("is_hub not in", values, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubBetween(String value1, String value2) {
            addCriterion("is_hub between", value1, value2, "isHub");
            return (Criteria) this;
        }

        public Criteria andIsHubNotBetween(String value1, String value2) {
            addCriterion("is_hub not between", value1, value2, "isHub");
            return (Criteria) this;
        }

        public Criteria andSiteLevelIsNull() {
            addCriterion("site_level is null");
            return (Criteria) this;
        }

        public Criteria andSiteLevelIsNotNull() {
            addCriterion("site_level is not null");
            return (Criteria) this;
        }

        public Criteria andSiteLevelEqualTo(String value) {
            addCriterion("site_level =", value, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelNotEqualTo(String value) {
            addCriterion("site_level <>", value, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelGreaterThan(String value) {
            addCriterion("site_level >", value, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelGreaterThanOrEqualTo(String value) {
            addCriterion("site_level >=", value, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelLessThan(String value) {
            addCriterion("site_level <", value, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelLessThanOrEqualTo(String value) {
            addCriterion("site_level <=", value, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelLike(String value) {
            addCriterion("site_level like", value, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelNotLike(String value) {
            addCriterion("site_level not like", value, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelIn(List<String> values) {
            addCriterion("site_level in", values, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelNotIn(List<String> values) {
            addCriterion("site_level not in", values, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelBetween(String value1, String value2) {
            addCriterion("site_level between", value1, value2, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andSiteLevelNotBetween(String value1, String value2) {
            addCriterion("site_level not between", value1, value2, "siteLevel");
            return (Criteria) this;
        }

        public Criteria andDutyTypeIsNull() {
            addCriterion("duty_type is null");
            return (Criteria) this;
        }

        public Criteria andDutyTypeIsNotNull() {
            addCriterion("duty_type is not null");
            return (Criteria) this;
        }

        public Criteria andDutyTypeEqualTo(String value) {
            addCriterion("duty_type =", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeNotEqualTo(String value) {
            addCriterion("duty_type <>", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeGreaterThan(String value) {
            addCriterion("duty_type >", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("duty_type >=", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeLessThan(String value) {
            addCriterion("duty_type <", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeLessThanOrEqualTo(String value) {
            addCriterion("duty_type <=", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeLike(String value) {
            addCriterion("duty_type like", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeNotLike(String value) {
            addCriterion("duty_type not like", value, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeIn(List<String> values) {
            addCriterion("duty_type in", values, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeNotIn(List<String> values) {
            addCriterion("duty_type not in", values, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeBetween(String value1, String value2) {
            addCriterion("duty_type between", value1, value2, "dutyType");
            return (Criteria) this;
        }

        public Criteria andDutyTypeNotBetween(String value1, String value2) {
            addCriterion("duty_type not between", value1, value2, "dutyType");
            return (Criteria) this;
        }

        public Criteria andAgentServiceIsNull() {
            addCriterion("agent_service is null");
            return (Criteria) this;
        }

        public Criteria andAgentServiceIsNotNull() {
            addCriterion("agent_service is not null");
            return (Criteria) this;
        }

        public Criteria andAgentServiceEqualTo(String value) {
            addCriterion("agent_service =", value, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceNotEqualTo(String value) {
            addCriterion("agent_service <>", value, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceGreaterThan(String value) {
            addCriterion("agent_service >", value, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceGreaterThanOrEqualTo(String value) {
            addCriterion("agent_service >=", value, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceLessThan(String value) {
            addCriterion("agent_service <", value, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceLessThanOrEqualTo(String value) {
            addCriterion("agent_service <=", value, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceLike(String value) {
            addCriterion("agent_service like", value, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceNotLike(String value) {
            addCriterion("agent_service not like", value, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceIn(List<String> values) {
            addCriterion("agent_service in", values, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceNotIn(List<String> values) {
            addCriterion("agent_service not in", values, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceBetween(String value1, String value2) {
            addCriterion("agent_service between", value1, value2, "agentService");
            return (Criteria) this;
        }

        public Criteria andAgentServiceNotBetween(String value1, String value2) {
            addCriterion("agent_service not between", value1, value2, "agentService");
            return (Criteria) this;
        }

        public Criteria andCablingTypeIsNull() {
            addCriterion("cabling_type is null");
            return (Criteria) this;
        }

        public Criteria andCablingTypeIsNotNull() {
            addCriterion("cabling_type is not null");
            return (Criteria) this;
        }

        public Criteria andCablingTypeEqualTo(String value) {
            addCriterion("cabling_type =", value, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeNotEqualTo(String value) {
            addCriterion("cabling_type <>", value, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeGreaterThan(String value) {
            addCriterion("cabling_type >", value, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cabling_type >=", value, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeLessThan(String value) {
            addCriterion("cabling_type <", value, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeLessThanOrEqualTo(String value) {
            addCriterion("cabling_type <=", value, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeLike(String value) {
            addCriterion("cabling_type like", value, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeNotLike(String value) {
            addCriterion("cabling_type not like", value, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeIn(List<String> values) {
            addCriterion("cabling_type in", values, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeNotIn(List<String> values) {
            addCriterion("cabling_type not in", values, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeBetween(String value1, String value2) {
            addCriterion("cabling_type between", value1, value2, "cablingType");
            return (Criteria) this;
        }

        public Criteria andCablingTypeNotBetween(String value1, String value2) {
            addCriterion("cabling_type not between", value1, value2, "cablingType");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelIsNull() {
            addCriterion("contamination_level is null");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelIsNotNull() {
            addCriterion("contamination_level is not null");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelEqualTo(String value) {
            addCriterion("contamination_level =", value, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelNotEqualTo(String value) {
            addCriterion("contamination_level <>", value, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelGreaterThan(String value) {
            addCriterion("contamination_level >", value, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelGreaterThanOrEqualTo(String value) {
            addCriterion("contamination_level >=", value, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelLessThan(String value) {
            addCriterion("contamination_level <", value, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelLessThanOrEqualTo(String value) {
            addCriterion("contamination_level <=", value, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelLike(String value) {
            addCriterion("contamination_level like", value, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelNotLike(String value) {
            addCriterion("contamination_level not like", value, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelIn(List<String> values) {
            addCriterion("contamination_level in", values, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelNotIn(List<String> values) {
            addCriterion("contamination_level not in", values, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelBetween(String value1, String value2) {
            addCriterion("contamination_level between", value1, value2, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andContaminationLevelNotBetween(String value1, String value2) {
            addCriterion("contamination_level not between", value1, value2, "contaminationLevel");
            return (Criteria) this;
        }

        public Criteria andSiteAddrIsNull() {
            addCriterion("site_addr is null");
            return (Criteria) this;
        }

        public Criteria andSiteAddrIsNotNull() {
            addCriterion("site_addr is not null");
            return (Criteria) this;
        }

        public Criteria andSiteAddrEqualTo(String value) {
            addCriterion("site_addr =", value, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrNotEqualTo(String value) {
            addCriterion("site_addr <>", value, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrGreaterThan(String value) {
            addCriterion("site_addr >", value, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrGreaterThanOrEqualTo(String value) {
            addCriterion("site_addr >=", value, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrLessThan(String value) {
            addCriterion("site_addr <", value, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrLessThanOrEqualTo(String value) {
            addCriterion("site_addr <=", value, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrLike(String value) {
            addCriterion("site_addr like", value, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrNotLike(String value) {
            addCriterion("site_addr not like", value, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrIn(List<String> values) {
            addCriterion("site_addr in", values, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrNotIn(List<String> values) {
            addCriterion("site_addr not in", values, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrBetween(String value1, String value2) {
            addCriterion("site_addr between", value1, value2, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andSiteAddrNotBetween(String value1, String value2) {
            addCriterion("site_addr not between", value1, value2, "siteAddr");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredIsNull() {
            addCriterion("area_covered is null");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredIsNotNull() {
            addCriterion("area_covered is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredEqualTo(BigDecimal value) {
            addCriterion("area_covered =", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredNotEqualTo(BigDecimal value) {
            addCriterion("area_covered <>", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredGreaterThan(BigDecimal value) {
            addCriterion("area_covered >", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("area_covered >=", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredLessThan(BigDecimal value) {
            addCriterion("area_covered <", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredLessThanOrEqualTo(BigDecimal value) {
            addCriterion("area_covered <=", value, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredIn(List<BigDecimal> values) {
            addCriterion("area_covered in", values, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredNotIn(List<BigDecimal> values) {
            addCriterion("area_covered not in", values, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area_covered between", value1, value2, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andAreaCoveredNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area_covered not between", value1, value2, "areaCovered");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaIsNull() {
            addCriterion("building_area is null");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaIsNotNull() {
            addCriterion("building_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaEqualTo(BigDecimal value) {
            addCriterion("building_area =", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaNotEqualTo(BigDecimal value) {
            addCriterion("building_area <>", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaGreaterThan(BigDecimal value) {
            addCriterion("building_area >", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("building_area >=", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaLessThan(BigDecimal value) {
            addCriterion("building_area <", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("building_area <=", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaIn(List<BigDecimal> values) {
            addCriterion("building_area in", values, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaNotIn(List<BigDecimal> values) {
            addCriterion("building_area not in", values, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("building_area between", value1, value2, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("building_area not between", value1, value2, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesIsNull() {
            addCriterion("region_features is null");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesIsNotNull() {
            addCriterion("region_features is not null");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesEqualTo(String value) {
            addCriterion("region_features =", value, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesNotEqualTo(String value) {
            addCriterion("region_features <>", value, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesGreaterThan(String value) {
            addCriterion("region_features >", value, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesGreaterThanOrEqualTo(String value) {
            addCriterion("region_features >=", value, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesLessThan(String value) {
            addCriterion("region_features <", value, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesLessThanOrEqualTo(String value) {
            addCriterion("region_features <=", value, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesLike(String value) {
            addCriterion("region_features like", value, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesNotLike(String value) {
            addCriterion("region_features not like", value, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesIn(List<String> values) {
            addCriterion("region_features in", values, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesNotIn(List<String> values) {
            addCriterion("region_features not in", values, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesBetween(String value1, String value2) {
            addCriterion("region_features between", value1, value2, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andRegionFeaturesNotBetween(String value1, String value2) {
            addCriterion("region_features not between", value1, value2, "regionFeatures");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNull() {
            addCriterion("contact_tel is null");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNotNull() {
            addCriterion("contact_tel is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelEqualTo(String value) {
            addCriterion("contact_tel =", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotEqualTo(String value) {
            addCriterion("contact_tel <>", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThan(String value) {
            addCriterion("contact_tel >", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("contact_tel >=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThan(String value) {
            addCriterion("contact_tel <", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThanOrEqualTo(String value) {
            addCriterion("contact_tel <=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLike(String value) {
            addCriterion("contact_tel like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotLike(String value) {
            addCriterion("contact_tel not like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelIn(List<String> values) {
            addCriterion("contact_tel in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotIn(List<String> values) {
            addCriterion("contact_tel not in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelBetween(String value1, String value2) {
            addCriterion("contact_tel between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotBetween(String value1, String value2) {
            addCriterion("contact_tel not between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerIsNull() {
            addCriterion("equipment_owner is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerIsNotNull() {
            addCriterion("equipment_owner is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerEqualTo(String value) {
            addCriterion("equipment_owner =", value, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerNotEqualTo(String value) {
            addCriterion("equipment_owner <>", value, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerGreaterThan(String value) {
            addCriterion("equipment_owner >", value, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_owner >=", value, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerLessThan(String value) {
            addCriterion("equipment_owner <", value, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerLessThanOrEqualTo(String value) {
            addCriterion("equipment_owner <=", value, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerLike(String value) {
            addCriterion("equipment_owner like", value, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerNotLike(String value) {
            addCriterion("equipment_owner not like", value, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerIn(List<String> values) {
            addCriterion("equipment_owner in", values, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerNotIn(List<String> values) {
            addCriterion("equipment_owner not in", values, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerBetween(String value1, String value2) {
            addCriterion("equipment_owner between", value1, value2, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andEquipmentOwnerNotBetween(String value1, String value2) {
            addCriterion("equipment_owner not between", value1, value2, "equipmentOwner");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityIsNull() {
            addCriterion("total_capacity is null");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityIsNotNull() {
            addCriterion("total_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityEqualTo(BigDecimal value) {
            addCriterion("total_capacity =", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityNotEqualTo(BigDecimal value) {
            addCriterion("total_capacity <>", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityGreaterThan(BigDecimal value) {
            addCriterion("total_capacity >", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_capacity >=", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityLessThan(BigDecimal value) {
            addCriterion("total_capacity <", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_capacity <=", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityIn(List<BigDecimal> values) {
            addCriterion("total_capacity in", values, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityNotIn(List<BigDecimal> values) {
            addCriterion("total_capacity not in", values, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_capacity between", value1, value2, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_capacity not between", value1, value2, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumIsNull() {
            addCriterion("equipment_num is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumIsNotNull() {
            addCriterion("equipment_num is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumEqualTo(Short value) {
            addCriterion("equipment_num =", value, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumNotEqualTo(Short value) {
            addCriterion("equipment_num <>", value, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumGreaterThan(Short value) {
            addCriterion("equipment_num >", value, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumGreaterThanOrEqualTo(Short value) {
            addCriterion("equipment_num >=", value, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumLessThan(Short value) {
            addCriterion("equipment_num <", value, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumLessThanOrEqualTo(Short value) {
            addCriterion("equipment_num <=", value, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumIn(List<Short> values) {
            addCriterion("equipment_num in", values, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumNotIn(List<Short> values) {
            addCriterion("equipment_num not in", values, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumBetween(Short value1, Short value2) {
            addCriterion("equipment_num between", value1, value2, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumNotBetween(Short value1, Short value2) {
            addCriterion("equipment_num not between", value1, value2, "equipmentNum");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeIsNull() {
            addCriterion("important_degree is null");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeIsNotNull() {
            addCriterion("important_degree is not null");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeEqualTo(String value) {
            addCriterion("important_degree =", value, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeNotEqualTo(String value) {
            addCriterion("important_degree <>", value, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeGreaterThan(String value) {
            addCriterion("important_degree >", value, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("important_degree >=", value, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeLessThan(String value) {
            addCriterion("important_degree <", value, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeLessThanOrEqualTo(String value) {
            addCriterion("important_degree <=", value, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeLike(String value) {
            addCriterion("important_degree like", value, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeNotLike(String value) {
            addCriterion("important_degree not like", value, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeIn(List<String> values) {
            addCriterion("important_degree in", values, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeNotIn(List<String> values) {
            addCriterion("important_degree not in", values, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeBetween(String value1, String value2) {
            addCriterion("important_degree between", value1, value2, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andImportantDegreeNotBetween(String value1, String value2) {
            addCriterion("important_degree not between", value1, value2, "importantDegree");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundIsNull() {
            addCriterion("is_underground is null");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundIsNotNull() {
            addCriterion("is_underground is not null");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundEqualTo(String value) {
            addCriterion("is_underground =", value, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundNotEqualTo(String value) {
            addCriterion("is_underground <>", value, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundGreaterThan(String value) {
            addCriterion("is_underground >", value, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundGreaterThanOrEqualTo(String value) {
            addCriterion("is_underground >=", value, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundLessThan(String value) {
            addCriterion("is_underground <", value, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundLessThanOrEqualTo(String value) {
            addCriterion("is_underground <=", value, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundLike(String value) {
            addCriterion("is_underground like", value, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundNotLike(String value) {
            addCriterion("is_underground not like", value, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundIn(List<String> values) {
            addCriterion("is_underground in", values, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundNotIn(List<String> values) {
            addCriterion("is_underground not in", values, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundBetween(String value1, String value2) {
            addCriterion("is_underground between", value1, value2, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsUndergroundNotBetween(String value1, String value2) {
            addCriterion("is_underground not between", value1, value2, "isUnderground");
            return (Criteria) this;
        }

        public Criteria andIsIndependentIsNull() {
            addCriterion("is_independent is null");
            return (Criteria) this;
        }

        public Criteria andIsIndependentIsNotNull() {
            addCriterion("is_independent is not null");
            return (Criteria) this;
        }

        public Criteria andIsIndependentEqualTo(String value) {
            addCriterion("is_independent =", value, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentNotEqualTo(String value) {
            addCriterion("is_independent <>", value, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentGreaterThan(String value) {
            addCriterion("is_independent >", value, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentGreaterThanOrEqualTo(String value) {
            addCriterion("is_independent >=", value, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentLessThan(String value) {
            addCriterion("is_independent <", value, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentLessThanOrEqualTo(String value) {
            addCriterion("is_independent <=", value, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentLike(String value) {
            addCriterion("is_independent like", value, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentNotLike(String value) {
            addCriterion("is_independent not like", value, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentIn(List<String> values) {
            addCriterion("is_independent in", values, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentNotIn(List<String> values) {
            addCriterion("is_independent not in", values, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentBetween(String value1, String value2) {
            addCriterion("is_independent between", value1, value2, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andIsIndependentNotBetween(String value1, String value2) {
            addCriterion("is_independent not between", value1, value2, "isIndependent");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeIsNull() {
            addCriterion("prevention_type is null");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeIsNotNull() {
            addCriterion("prevention_type is not null");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeEqualTo(String value) {
            addCriterion("prevention_type =", value, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeNotEqualTo(String value) {
            addCriterion("prevention_type <>", value, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeGreaterThan(String value) {
            addCriterion("prevention_type >", value, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("prevention_type >=", value, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeLessThan(String value) {
            addCriterion("prevention_type <", value, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeLessThanOrEqualTo(String value) {
            addCriterion("prevention_type <=", value, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeLike(String value) {
            addCriterion("prevention_type like", value, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeNotLike(String value) {
            addCriterion("prevention_type not like", value, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeIn(List<String> values) {
            addCriterion("prevention_type in", values, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeNotIn(List<String> values) {
            addCriterion("prevention_type not in", values, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeBetween(String value1, String value2) {
            addCriterion("prevention_type between", value1, value2, "preventionType");
            return (Criteria) this;
        }

        public Criteria andPreventionTypeNotBetween(String value1, String value2) {
            addCriterion("prevention_type not between", value1, value2, "preventionType");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkIsNull() {
            addCriterion("has_ring_network is null");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkIsNotNull() {
            addCriterion("has_ring_network is not null");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkEqualTo(String value) {
            addCriterion("has_ring_network =", value, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkNotEqualTo(String value) {
            addCriterion("has_ring_network <>", value, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkGreaterThan(String value) {
            addCriterion("has_ring_network >", value, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkGreaterThanOrEqualTo(String value) {
            addCriterion("has_ring_network >=", value, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkLessThan(String value) {
            addCriterion("has_ring_network <", value, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkLessThanOrEqualTo(String value) {
            addCriterion("has_ring_network <=", value, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkLike(String value) {
            addCriterion("has_ring_network like", value, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkNotLike(String value) {
            addCriterion("has_ring_network not like", value, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkIn(List<String> values) {
            addCriterion("has_ring_network in", values, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkNotIn(List<String> values) {
            addCriterion("has_ring_network not in", values, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkBetween(String value1, String value2) {
            addCriterion("has_ring_network between", value1, value2, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andHasRingNetworkNotBetween(String value1, String value2) {
            addCriterion("has_ring_network not between", value1, value2, "hasRingNetwork");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityIsNull() {
            addCriterion("compensate_capacity is null");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityIsNotNull() {
            addCriterion("compensate_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityEqualTo(Long value) {
            addCriterion("compensate_capacity =", value, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityNotEqualTo(Long value) {
            addCriterion("compensate_capacity <>", value, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityGreaterThan(Long value) {
            addCriterion("compensate_capacity >", value, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityGreaterThanOrEqualTo(Long value) {
            addCriterion("compensate_capacity >=", value, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityLessThan(Long value) {
            addCriterion("compensate_capacity <", value, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityLessThanOrEqualTo(Long value) {
            addCriterion("compensate_capacity <=", value, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityIn(List<Long> values) {
            addCriterion("compensate_capacity in", values, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityNotIn(List<Long> values) {
            addCriterion("compensate_capacity not in", values, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityBetween(Long value1, Long value2) {
            addCriterion("compensate_capacity between", value1, value2, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andCompensateCapacityNotBetween(Long value1, Long value2) {
            addCriterion("compensate_capacity not between", value1, value2, "compensateCapacity");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIsNull() {
            addCriterion("equipment_code is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIsNotNull() {
            addCriterion("equipment_code is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeEqualTo(String value) {
            addCriterion("equipment_code =", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotEqualTo(String value) {
            addCriterion("equipment_code <>", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThan(String value) {
            addCriterion("equipment_code >", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_code >=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThan(String value) {
            addCriterion("equipment_code <", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThanOrEqualTo(String value) {
            addCriterion("equipment_code <=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLike(String value) {
            addCriterion("equipment_code like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotLike(String value) {
            addCriterion("equipment_code not like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIn(List<String> values) {
            addCriterion("equipment_code in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotIn(List<String> values) {
            addCriterion("equipment_code not in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeBetween(String value1, String value2) {
            addCriterion("equipment_code between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotBetween(String value1, String value2) {
            addCriterion("equipment_code not between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andLongitudePointIsNull() {
            addCriterion("longitude_point is null");
            return (Criteria) this;
        }

        public Criteria andLongitudePointIsNotNull() {
            addCriterion("longitude_point is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudePointEqualTo(BigDecimal value) {
            addCriterion("longitude_point =", value, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointNotEqualTo(BigDecimal value) {
            addCriterion("longitude_point <>", value, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointGreaterThan(BigDecimal value) {
            addCriterion("longitude_point >", value, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude_point >=", value, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointLessThan(BigDecimal value) {
            addCriterion("longitude_point <", value, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude_point <=", value, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointIn(List<BigDecimal> values) {
            addCriterion("longitude_point in", values, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointNotIn(List<BigDecimal> values) {
            addCriterion("longitude_point not in", values, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude_point between", value1, value2, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLongitudePointNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude_point not between", value1, value2, "longitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointIsNull() {
            addCriterion("latitude_point is null");
            return (Criteria) this;
        }

        public Criteria andLatitudePointIsNotNull() {
            addCriterion("latitude_point is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudePointEqualTo(BigDecimal value) {
            addCriterion("latitude_point =", value, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointNotEqualTo(BigDecimal value) {
            addCriterion("latitude_point <>", value, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointGreaterThan(BigDecimal value) {
            addCriterion("latitude_point >", value, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude_point >=", value, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointLessThan(BigDecimal value) {
            addCriterion("latitude_point <", value, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude_point <=", value, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointIn(List<BigDecimal> values) {
            addCriterion("latitude_point in", values, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointNotIn(List<BigDecimal> values) {
            addCriterion("latitude_point not in", values, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude_point between", value1, value2, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andLatitudePointNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude_point not between", value1, value2, "latitudePoint");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImagePathEqualTo(String value) {
            addCriterion("image_path =", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThan(String value) {
            addCriterion("image_path >", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThan(String value) {
            addCriterion("image_path <", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLike(String value) {
            addCriterion("image_path like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotLike(String value) {
            addCriterion("image_path not like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathIn(List<String> values) {
            addCriterion("image_path in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andBelongAreaIsNull() {
            addCriterion("belong_area is null");
            return (Criteria) this;
        }

        public Criteria andBelongAreaIsNotNull() {
            addCriterion("belong_area is not null");
            return (Criteria) this;
        }

        public Criteria andBelongAreaEqualTo(String value) {
            addCriterion("belong_area =", value, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaNotEqualTo(String value) {
            addCriterion("belong_area <>", value, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaGreaterThan(String value) {
            addCriterion("belong_area >", value, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaGreaterThanOrEqualTo(String value) {
            addCriterion("belong_area >=", value, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaLessThan(String value) {
            addCriterion("belong_area <", value, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaLessThanOrEqualTo(String value) {
            addCriterion("belong_area <=", value, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaLike(String value) {
            addCriterion("belong_area like", value, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaNotLike(String value) {
            addCriterion("belong_area not like", value, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaIn(List<String> values) {
            addCriterion("belong_area in", values, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaNotIn(List<String> values) {
            addCriterion("belong_area not in", values, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaBetween(String value1, String value2) {
            addCriterion("belong_area between", value1, value2, "belongArea");
            return (Criteria) this;
        }

        public Criteria andBelongAreaNotBetween(String value1, String value2) {
            addCriterion("belong_area not between", value1, value2, "belongArea");
            return (Criteria) this;
        }

        public Criteria andComeFromIsNull() {
            addCriterion("come_from is null");
            return (Criteria) this;
        }

        public Criteria andComeFromIsNotNull() {
            addCriterion("come_from is not null");
            return (Criteria) this;
        }

        public Criteria andComeFromEqualTo(String value) {
            addCriterion("come_from =", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromNotEqualTo(String value) {
            addCriterion("come_from <>", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromGreaterThan(String value) {
            addCriterion("come_from >", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromGreaterThanOrEqualTo(String value) {
            addCriterion("come_from >=", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromLessThan(String value) {
            addCriterion("come_from <", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromLessThanOrEqualTo(String value) {
            addCriterion("come_from <=", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromLike(String value) {
            addCriterion("come_from like", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromNotLike(String value) {
            addCriterion("come_from not like", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromIn(List<String> values) {
            addCriterion("come_from in", values, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromNotIn(List<String> values) {
            addCriterion("come_from not in", values, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromBetween(String value1, String value2) {
            addCriterion("come_from between", value1, value2, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromNotBetween(String value1, String value2) {
            addCriterion("come_from not between", value1, value2, "comeFrom");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}