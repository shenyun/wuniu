package cn.shenyun.wuniu.entity.wuniu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileInfoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBizCodeIsNull() {
            addCriterion("biz_code is null");
            return (Criteria) this;
        }

        public Criteria andBizCodeIsNotNull() {
            addCriterion("biz_code is not null");
            return (Criteria) this;
        }

        public Criteria andBizCodeEqualTo(String value) {
            addCriterion("biz_code =", value, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeNotEqualTo(String value) {
            addCriterion("biz_code <>", value, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeGreaterThan(String value) {
            addCriterion("biz_code >", value, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeGreaterThanOrEqualTo(String value) {
            addCriterion("biz_code >=", value, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeLessThan(String value) {
            addCriterion("biz_code <", value, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeLessThanOrEqualTo(String value) {
            addCriterion("biz_code <=", value, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeLike(String value) {
            addCriterion("biz_code like", value, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeNotLike(String value) {
            addCriterion("biz_code not like", value, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeIn(List<String> values) {
            addCriterion("biz_code in", values, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeNotIn(List<String> values) {
            addCriterion("biz_code not in", values, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeBetween(String value1, String value2) {
            addCriterion("biz_code between", value1, value2, "bizCode");
            return (Criteria) this;
        }

        public Criteria andBizCodeNotBetween(String value1, String value2) {
            addCriterion("biz_code not between", value1, value2, "bizCode");
            return (Criteria) this;
        }

        public Criteria andUrlHashIsNull() {
            addCriterion("url_hash is null");
            return (Criteria) this;
        }

        public Criteria andUrlHashIsNotNull() {
            addCriterion("url_hash is not null");
            return (Criteria) this;
        }

        public Criteria andUrlHashEqualTo(Integer value) {
            addCriterion("url_hash =", value, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashNotEqualTo(Integer value) {
            addCriterion("url_hash <>", value, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashGreaterThan(Integer value) {
            addCriterion("url_hash >", value, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashGreaterThanOrEqualTo(Integer value) {
            addCriterion("url_hash >=", value, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashLessThan(Integer value) {
            addCriterion("url_hash <", value, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashLessThanOrEqualTo(Integer value) {
            addCriterion("url_hash <=", value, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashIn(List<Integer> values) {
            addCriterion("url_hash in", values, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashNotIn(List<Integer> values) {
            addCriterion("url_hash not in", values, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashBetween(Integer value1, Integer value2) {
            addCriterion("url_hash between", value1, value2, "urlHash");
            return (Criteria) this;
        }

        public Criteria andUrlHashNotBetween(Integer value1, Integer value2) {
            addCriterion("url_hash not between", value1, value2, "urlHash");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupIsNull() {
            addCriterion("fastdfs_group is null");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupIsNotNull() {
            addCriterion("fastdfs_group is not null");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupEqualTo(String value) {
            addCriterion("fastdfs_group =", value, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupNotEqualTo(String value) {
            addCriterion("fastdfs_group <>", value, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupGreaterThan(String value) {
            addCriterion("fastdfs_group >", value, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupGreaterThanOrEqualTo(String value) {
            addCriterion("fastdfs_group >=", value, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupLessThan(String value) {
            addCriterion("fastdfs_group <", value, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupLessThanOrEqualTo(String value) {
            addCriterion("fastdfs_group <=", value, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupLike(String value) {
            addCriterion("fastdfs_group like", value, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupNotLike(String value) {
            addCriterion("fastdfs_group not like", value, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupIn(List<String> values) {
            addCriterion("fastdfs_group in", values, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupNotIn(List<String> values) {
            addCriterion("fastdfs_group not in", values, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupBetween(String value1, String value2) {
            addCriterion("fastdfs_group between", value1, value2, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsGroupNotBetween(String value1, String value2) {
            addCriterion("fastdfs_group not between", value1, value2, "fastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameIsNull() {
            addCriterion("fastdfs_name is null");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameIsNotNull() {
            addCriterion("fastdfs_name is not null");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameEqualTo(String value) {
            addCriterion("fastdfs_name =", value, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameNotEqualTo(String value) {
            addCriterion("fastdfs_name <>", value, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameGreaterThan(String value) {
            addCriterion("fastdfs_name >", value, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameGreaterThanOrEqualTo(String value) {
            addCriterion("fastdfs_name >=", value, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameLessThan(String value) {
            addCriterion("fastdfs_name <", value, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameLessThanOrEqualTo(String value) {
            addCriterion("fastdfs_name <=", value, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameLike(String value) {
            addCriterion("fastdfs_name like", value, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameNotLike(String value) {
            addCriterion("fastdfs_name not like", value, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameIn(List<String> values) {
            addCriterion("fastdfs_name in", values, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameNotIn(List<String> values) {
            addCriterion("fastdfs_name not in", values, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameBetween(String value1, String value2) {
            addCriterion("fastdfs_name between", value1, value2, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andFastdfsNameNotBetween(String value1, String value2) {
            addCriterion("fastdfs_name not between", value1, value2, "fastdfsName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("`size` is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("`size` is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Integer value) {
            addCriterion("`size` =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Integer value) {
            addCriterion("`size` <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Integer value) {
            addCriterion("`size` >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`size` >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Integer value) {
            addCriterion("`size` <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Integer value) {
            addCriterion("`size` <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Integer> values) {
            addCriterion("`size` in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Integer> values) {
            addCriterion("`size` not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Integer value1, Integer value2) {
            addCriterion("`size` between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("`size` not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyIsNull() {
            addCriterion("scale_strategy is null");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyIsNotNull() {
            addCriterion("scale_strategy is not null");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyEqualTo(String value) {
            addCriterion("scale_strategy =", value, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyNotEqualTo(String value) {
            addCriterion("scale_strategy <>", value, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyGreaterThan(String value) {
            addCriterion("scale_strategy >", value, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyGreaterThanOrEqualTo(String value) {
            addCriterion("scale_strategy >=", value, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyLessThan(String value) {
            addCriterion("scale_strategy <", value, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyLessThanOrEqualTo(String value) {
            addCriterion("scale_strategy <=", value, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyLike(String value) {
            addCriterion("scale_strategy like", value, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyNotLike(String value) {
            addCriterion("scale_strategy not like", value, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyIn(List<String> values) {
            addCriterion("scale_strategy in", values, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyNotIn(List<String> values) {
            addCriterion("scale_strategy not in", values, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyBetween(String value1, String value2) {
            addCriterion("scale_strategy between", value1, value2, "scaleStrategy");
            return (Criteria) this;
        }

        public Criteria andScaleStrategyNotBetween(String value1, String value2) {
            addCriterion("scale_strategy not between", value1, value2, "scaleStrategy");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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