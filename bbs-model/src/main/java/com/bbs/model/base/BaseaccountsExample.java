package com.bbs.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbs.core.Pagination;

public class BaseaccountsExample implements Serializable {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public BaseaccountsExample() {
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

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteIsNull() {
			addCriterion("personal_website is null");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteIsNotNull() {
			addCriterion("personal_website is not null");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteEqualTo(String value) {
			addCriterion("personal_website =", value, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteNotEqualTo(String value) {
			addCriterion("personal_website <>", value, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteGreaterThan(String value) {
			addCriterion("personal_website >", value, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteGreaterThanOrEqualTo(String value) {
			addCriterion("personal_website >=", value, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteLessThan(String value) {
			addCriterion("personal_website <", value, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteLessThanOrEqualTo(String value) {
			addCriterion("personal_website <=", value, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteLike(String value) {
			addCriterion("personal_website like", value, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteNotLike(String value) {
			addCriterion("personal_website not like", value, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteIn(List<String> values) {
			addCriterion("personal_website in", values, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteNotIn(List<String> values) {
			addCriterion("personal_website not in", values, "personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteBetween(String value1, String value2) {
			addCriterion("personal_website between", value1, value2,
					"personalWebsite");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteNotBetween(String value1,
				String value2) {
			addCriterion("personal_website not between", value1, value2,
					"personalWebsite");
			return (Criteria) this;
		}

		public Criteria andLocationIsNull() {
			addCriterion("location is null");
			return (Criteria) this;
		}

		public Criteria andLocationIsNotNull() {
			addCriterion("location is not null");
			return (Criteria) this;
		}

		public Criteria andLocationEqualTo(String value) {
			addCriterion("location =", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotEqualTo(String value) {
			addCriterion("location <>", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThan(String value) {
			addCriterion("location >", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThanOrEqualTo(String value) {
			addCriterion("location >=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThan(String value) {
			addCriterion("location <", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThanOrEqualTo(String value) {
			addCriterion("location <=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLike(String value) {
			addCriterion("location like", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotLike(String value) {
			addCriterion("location not like", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationIn(List<String> values) {
			addCriterion("location in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotIn(List<String> values) {
			addCriterion("location not in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationBetween(String value1, String value2) {
			addCriterion("location between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotBetween(String value1, String value2) {
			addCriterion("location not between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andSignatureIsNull() {
			addCriterion("signature is null");
			return (Criteria) this;
		}

		public Criteria andSignatureIsNotNull() {
			addCriterion("signature is not null");
			return (Criteria) this;
		}

		public Criteria andSignatureEqualTo(String value) {
			addCriterion("signature =", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureNotEqualTo(String value) {
			addCriterion("signature <>", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureGreaterThan(String value) {
			addCriterion("signature >", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureGreaterThanOrEqualTo(String value) {
			addCriterion("signature >=", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureLessThan(String value) {
			addCriterion("signature <", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureLessThanOrEqualTo(String value) {
			addCriterion("signature <=", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureLike(String value) {
			addCriterion("signature like", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureNotLike(String value) {
			addCriterion("signature not like", value, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureIn(List<String> values) {
			addCriterion("signature in", values, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureNotIn(List<String> values) {
			addCriterion("signature not in", values, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureBetween(String value1, String value2) {
			addCriterion("signature between", value1, value2, "signature");
			return (Criteria) this;
		}

		public Criteria andSignatureNotBetween(String value1, String value2) {
			addCriterion("signature not between", value1, value2, "signature");
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

		public Criteria andWeiboLinkIsNull() {
			addCriterion("weibo_link is null");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkIsNotNull() {
			addCriterion("weibo_link is not null");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkEqualTo(String value) {
			addCriterion("weibo_link =", value, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkNotEqualTo(String value) {
			addCriterion("weibo_link <>", value, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkGreaterThan(String value) {
			addCriterion("weibo_link >", value, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkGreaterThanOrEqualTo(String value) {
			addCriterion("weibo_link >=", value, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkLessThan(String value) {
			addCriterion("weibo_link <", value, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkLessThanOrEqualTo(String value) {
			addCriterion("weibo_link <=", value, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkLike(String value) {
			addCriterion("weibo_link like", value, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkNotLike(String value) {
			addCriterion("weibo_link not like", value, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkIn(List<String> values) {
			addCriterion("weibo_link in", values, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkNotIn(List<String> values) {
			addCriterion("weibo_link not in", values, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkBetween(String value1, String value2) {
			addCriterion("weibo_link between", value1, value2, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkNotBetween(String value1, String value2) {
			addCriterion("weibo_link not between", value1, value2, "weiboLink");
			return (Criteria) this;
		}

		public Criteria andPersonalWebsiteLikeInsensitive(String value) {
			addCriterion("upper(personal_website) like", value.toUpperCase(),
					"personalWebsite");
			return (Criteria) this;
		}

		public Criteria andLocationLikeInsensitive(String value) {
			addCriterion("upper(location) like", value.toUpperCase(),
					"location");
			return (Criteria) this;
		}

		public Criteria andSignatureLikeInsensitive(String value) {
			addCriterion("upper(signature) like", value.toUpperCase(),
					"signature");
			return (Criteria) this;
		}

		public Criteria andIntroductionLikeInsensitive(String value) {
			addCriterion("upper(introduction) like", value.toUpperCase(),
					"introduction");
			return (Criteria) this;
		}

		public Criteria andWeiboLinkLikeInsensitive(String value) {
			addCriterion("upper(weibo_link) like", value.toUpperCase(),
					"weiboLink");
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