package com.lbs.model;

import java.util.ArrayList;
import java.util.List;

public class FuncInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FuncInfoExample() {
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

        public Criteria andFuncIdIsNull() {
            addCriterion("func_id is null");
            return (Criteria) this;
        }

        public Criteria andFuncIdIsNotNull() {
            addCriterion("func_id is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIdEqualTo(Long value) {
            addCriterion("func_id =", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotEqualTo(Long value) {
            addCriterion("func_id <>", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThan(Long value) {
            addCriterion("func_id >", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThanOrEqualTo(Long value) {
            addCriterion("func_id >=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThan(Long value) {
            addCriterion("func_id <", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThanOrEqualTo(Long value) {
            addCriterion("func_id <=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdIn(List<Long> values) {
            addCriterion("func_id in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotIn(List<Long> values) {
            addCriterion("func_id not in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdBetween(Long value1, Long value2) {
            addCriterion("func_id between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotBetween(Long value1, Long value2) {
            addCriterion("func_id not between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNull() {
            addCriterion("func_name is null");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNotNull() {
            addCriterion("func_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuncNameEqualTo(String value) {
            addCriterion("func_name =", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotEqualTo(String value) {
            addCriterion("func_name <>", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThan(String value) {
            addCriterion("func_name >", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("func_name >=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThan(String value) {
            addCriterion("func_name <", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThanOrEqualTo(String value) {
            addCriterion("func_name <=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLike(String value) {
            addCriterion("func_name like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotLike(String value) {
            addCriterion("func_name not like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameIn(List<String> values) {
            addCriterion("func_name in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotIn(List<String> values) {
            addCriterion("func_name not in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameBetween(String value1, String value2) {
            addCriterion("func_name between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotBetween(String value1, String value2) {
            addCriterion("func_name not between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIsNull() {
            addCriterion("func_type is null");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIsNotNull() {
            addCriterion("func_type is not null");
            return (Criteria) this;
        }

        public Criteria andFuncTypeEqualTo(String value) {
            addCriterion("func_type =", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotEqualTo(String value) {
            addCriterion("func_type <>", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeGreaterThan(String value) {
            addCriterion("func_type >", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeGreaterThanOrEqualTo(String value) {
            addCriterion("func_type >=", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLessThan(String value) {
            addCriterion("func_type <", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLessThanOrEqualTo(String value) {
            addCriterion("func_type <=", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLike(String value) {
            addCriterion("func_type like", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotLike(String value) {
            addCriterion("func_type not like", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIn(List<String> values) {
            addCriterion("func_type in", values, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotIn(List<String> values) {
            addCriterion("func_type not in", values, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeBetween(String value1, String value2) {
            addCriterion("func_type between", value1, value2, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotBetween(String value1, String value2) {
            addCriterion("func_type not between", value1, value2, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncStatIsNull() {
            addCriterion("func_stat is null");
            return (Criteria) this;
        }

        public Criteria andFuncStatIsNotNull() {
            addCriterion("func_stat is not null");
            return (Criteria) this;
        }

        public Criteria andFuncStatEqualTo(String value) {
            addCriterion("func_stat =", value, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatNotEqualTo(String value) {
            addCriterion("func_stat <>", value, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatGreaterThan(String value) {
            addCriterion("func_stat >", value, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatGreaterThanOrEqualTo(String value) {
            addCriterion("func_stat >=", value, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatLessThan(String value) {
            addCriterion("func_stat <", value, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatLessThanOrEqualTo(String value) {
            addCriterion("func_stat <=", value, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatLike(String value) {
            addCriterion("func_stat like", value, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatNotLike(String value) {
            addCriterion("func_stat not like", value, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatIn(List<String> values) {
            addCriterion("func_stat in", values, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatNotIn(List<String> values) {
            addCriterion("func_stat not in", values, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatBetween(String value1, String value2) {
            addCriterion("func_stat between", value1, value2, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncStatNotBetween(String value1, String value2) {
            addCriterion("func_stat not between", value1, value2, "funcStat");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdIsNull() {
            addCriterion("func_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdIsNotNull() {
            addCriterion("func_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdEqualTo(Long value) {
            addCriterion("func_parent_id =", value, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdNotEqualTo(Long value) {
            addCriterion("func_parent_id <>", value, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdGreaterThan(Long value) {
            addCriterion("func_parent_id >", value, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("func_parent_id >=", value, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdLessThan(Long value) {
            addCriterion("func_parent_id <", value, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdLessThanOrEqualTo(Long value) {
            addCriterion("func_parent_id <=", value, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdIn(List<Long> values) {
            addCriterion("func_parent_id in", values, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdNotIn(List<Long> values) {
            addCriterion("func_parent_id not in", values, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdBetween(Long value1, Long value2) {
            addCriterion("func_parent_id between", value1, value2, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncParentIdNotBetween(Long value1, Long value2) {
            addCriterion("func_parent_id not between", value1, value2, "funcParentId");
            return (Criteria) this;
        }

        public Criteria andFuncDescIsNull() {
            addCriterion("func_desc is null");
            return (Criteria) this;
        }

        public Criteria andFuncDescIsNotNull() {
            addCriterion("func_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFuncDescEqualTo(String value) {
            addCriterion("func_desc =", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotEqualTo(String value) {
            addCriterion("func_desc <>", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescGreaterThan(String value) {
            addCriterion("func_desc >", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescGreaterThanOrEqualTo(String value) {
            addCriterion("func_desc >=", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLessThan(String value) {
            addCriterion("func_desc <", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLessThanOrEqualTo(String value) {
            addCriterion("func_desc <=", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLike(String value) {
            addCriterion("func_desc like", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotLike(String value) {
            addCriterion("func_desc not like", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescIn(List<String> values) {
            addCriterion("func_desc in", values, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotIn(List<String> values) {
            addCriterion("func_desc not in", values, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescBetween(String value1, String value2) {
            addCriterion("func_desc between", value1, value2, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotBetween(String value1, String value2) {
            addCriterion("func_desc not between", value1, value2, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andHasChildIsNull() {
            addCriterion("has_child is null");
            return (Criteria) this;
        }

        public Criteria andHasChildIsNotNull() {
            addCriterion("has_child is not null");
            return (Criteria) this;
        }

        public Criteria andHasChildEqualTo(String value) {
            addCriterion("has_child =", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotEqualTo(String value) {
            addCriterion("has_child <>", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildGreaterThan(String value) {
            addCriterion("has_child >", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildGreaterThanOrEqualTo(String value) {
            addCriterion("has_child >=", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildLessThan(String value) {
            addCriterion("has_child <", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildLessThanOrEqualTo(String value) {
            addCriterion("has_child <=", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildLike(String value) {
            addCriterion("has_child like", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotLike(String value) {
            addCriterion("has_child not like", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildIn(List<String> values) {
            addCriterion("has_child in", values, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotIn(List<String> values) {
            addCriterion("has_child not in", values, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildBetween(String value1, String value2) {
            addCriterion("has_child between", value1, value2, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotBetween(String value1, String value2) {
            addCriterion("has_child not between", value1, value2, "hasChild");
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