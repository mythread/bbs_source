package com.bbs.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbs.core.Pagination;

public class BasenodesExample implements Serializable {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public BasenodesExample() {
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

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Pagination getPagination() {
		return pagination;
	}

	protected abstract static class GeneratedCriteria implements Serializable {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andCreatedAtIsNull() {
			addCriterion("created_at is null");
			return (Criteria) this;
		}

		public Criteria andCreatedAtIsNotNull() {
			addCriterion("created_at is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedAtEqualTo(Date value) {
			addCriterion("created_at =", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtNotEqualTo(Date value) {
			addCriterion("created_at <>", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtGreaterThan(Date value) {
			addCriterion("created_at >", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
			addCriterion("created_at >=", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtLessThan(Date value) {
			addCriterion("created_at <", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
			addCriterion("created_at <=", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtIn(List<Date> values) {
			addCriterion("created_at in", values, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtNotIn(List<Date> values) {
			addCriterion("created_at not in", values, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtBetween(Date value1, Date value2) {
			addCriterion("created_at between", value1, value2, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
			addCriterion("created_at not between", value1, value2, "createdAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtIsNull() {
			addCriterion("updated_at is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtIsNotNull() {
			addCriterion("updated_at is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtEqualTo(Date value) {
			addCriterion("updated_at =", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtNotEqualTo(Date value) {
			addCriterion("updated_at <>", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtGreaterThan(Date value) {
			addCriterion("updated_at >", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
			addCriterion("updated_at >=", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtLessThan(Date value) {
			addCriterion("updated_at <", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
			addCriterion("updated_at <=", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtIn(List<Date> values) {
			addCriterion("updated_at in", values, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtNotIn(List<Date> values) {
			addCriterion("updated_at not in", values, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtBetween(Date value1, Date value2) {
			addCriterion("updated_at between", value1, value2, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
			addCriterion("updated_at not between", value1, value2, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andTopicsCountIsNull() {
			addCriterion("topics_count is null");
			return (Criteria) this;
		}

		public Criteria andTopicsCountIsNotNull() {
			addCriterion("topics_count is not null");
			return (Criteria) this;
		}

		public Criteria andTopicsCountEqualTo(Integer value) {
			addCriterion("topics_count =", value, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountNotEqualTo(Integer value) {
			addCriterion("topics_count <>", value, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountGreaterThan(Integer value) {
			addCriterion("topics_count >", value, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("topics_count >=", value, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountLessThan(Integer value) {
			addCriterion("topics_count <", value, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountLessThanOrEqualTo(Integer value) {
			addCriterion("topics_count <=", value, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountIn(List<Integer> values) {
			addCriterion("topics_count in", values, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountNotIn(List<Integer> values) {
			addCriterion("topics_count not in", values, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountBetween(Integer value1, Integer value2) {
			addCriterion("topics_count between", value1, value2, "topicsCount");
			return (Criteria) this;
		}

		public Criteria andTopicsCountNotBetween(Integer value1, Integer value2) {
			addCriterion("topics_count not between", value1, value2,
					"topicsCount");
			return (Criteria) this;
		}

		public Criteria andIntroductionIsNull() {
			addCriterion("introduction is null");
			return (Criteria) this;
		}

		public Criteria andIntroductionIsNotNull() {
			addCriterion("introduction is not null");
			return (Criteria) this;
		}

		public Criteria andIntroductionEqualTo(String value) {
			addCriterion("introduction =", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionNotEqualTo(String value) {
			addCriterion("introduction <>", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionGreaterThan(String value) {
			addCriterion("introduction >", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
			addCriterion("introduction >=", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionLessThan(String value) {
			addCriterion("introduction <", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionLessThanOrEqualTo(String value) {
			addCriterion("introduction <=", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionLike(String value) {
			addCriterion("introduction like", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionNotLike(String value) {
			addCriterion("introduction not like", value, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionIn(List<String> values) {
			addCriterion("introduction in", values, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionNotIn(List<String> values) {
			addCriterion("introduction not in", values, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionBetween(String value1, String value2) {
			addCriterion("introduction between", value1, value2, "introduction");
			return (Criteria) this;
		}

		public Criteria andIntroductionNotBetween(String value1, String value2) {
			addCriterion("introduction not between", value1, value2,
					"introduction");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlIsNull() {
			addCriterion("custom_html is null");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlIsNotNull() {
			addCriterion("custom_html is not null");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlEqualTo(String value) {
			addCriterion("custom_html =", value, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlNotEqualTo(String value) {
			addCriterion("custom_html <>", value, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlGreaterThan(String value) {
			addCriterion("custom_html >", value, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlGreaterThanOrEqualTo(String value) {
			addCriterion("custom_html >=", value, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlLessThan(String value) {
			addCriterion("custom_html <", value, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlLessThanOrEqualTo(String value) {
			addCriterion("custom_html <=", value, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlLike(String value) {
			addCriterion("custom_html like", value, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlNotLike(String value) {
			addCriterion("custom_html not like", value, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlIn(List<String> values) {
			addCriterion("custom_html in", values, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlNotIn(List<String> values) {
			addCriterion("custom_html not in", values, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlBetween(String value1, String value2) {
			addCriterion("custom_html between", value1, value2, "customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlNotBetween(String value1, String value2) {
			addCriterion("custom_html not between", value1, value2,
					"customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomCssIsNull() {
			addCriterion("custom_css is null");
			return (Criteria) this;
		}

		public Criteria andCustomCssIsNotNull() {
			addCriterion("custom_css is not null");
			return (Criteria) this;
		}

		public Criteria andCustomCssEqualTo(String value) {
			addCriterion("custom_css =", value, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssNotEqualTo(String value) {
			addCriterion("custom_css <>", value, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssGreaterThan(String value) {
			addCriterion("custom_css >", value, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssGreaterThanOrEqualTo(String value) {
			addCriterion("custom_css >=", value, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssLessThan(String value) {
			addCriterion("custom_css <", value, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssLessThanOrEqualTo(String value) {
			addCriterion("custom_css <=", value, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssLike(String value) {
			addCriterion("custom_css like", value, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssNotLike(String value) {
			addCriterion("custom_css not like", value, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssIn(List<String> values) {
			addCriterion("custom_css in", values, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssNotIn(List<String> values) {
			addCriterion("custom_css not in", values, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssBetween(String value1, String value2) {
			addCriterion("custom_css between", value1, value2, "customCss");
			return (Criteria) this;
		}

		public Criteria andCustomCssNotBetween(String value1, String value2) {
			addCriterion("custom_css not between", value1, value2, "customCss");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNull() {
			addCriterion("parent_id is null");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNotNull() {
			addCriterion("parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andParentIdEqualTo(Integer value) {
			addCriterion("parent_id =", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotEqualTo(Integer value) {
			addCriterion("parent_id <>", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThan(Integer value) {
			addCriterion("parent_id >", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("parent_id >=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThan(Integer value) {
			addCriterion("parent_id <", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThanOrEqualTo(Integer value) {
			addCriterion("parent_id <=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdIn(List<Integer> values) {
			addCriterion("parent_id in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotIn(List<Integer> values) {
			addCriterion("parent_id not in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdBetween(Integer value1, Integer value2) {
			addCriterion("parent_id between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
			addCriterion("parent_id not between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andNameLikeInsensitive(String value) {
			addCriterion("upper(name) like", value.toUpperCase(), "name");
			return (Criteria) this;
		}

		public Criteria andIntroductionLikeInsensitive(String value) {
			addCriterion("upper(introduction) like", value.toUpperCase(),
					"introduction");
			return (Criteria) this;
		}

		public Criteria andCustomHtmlLikeInsensitive(String value) {
			addCriterion("upper(custom_html) like", value.toUpperCase(),
					"customHtml");
			return (Criteria) this;
		}

		public Criteria andCustomCssLikeInsensitive(String value) {
			addCriterion("upper(custom_css) like", value.toUpperCase(),
					"customCss");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion implements Serializable {
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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