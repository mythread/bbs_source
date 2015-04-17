package com.bbs.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbs.core.Pagination;

public class BasetopicsExample implements Serializable {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public BasetopicsExample() {
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

		public Criteria andNodeIdIsNull() {
			addCriterion("node_id is null");
			return (Criteria) this;
		}

		public Criteria andNodeIdIsNotNull() {
			addCriterion("node_id is not null");
			return (Criteria) this;
		}

		public Criteria andNodeIdEqualTo(Integer value) {
			addCriterion("node_id =", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotEqualTo(Integer value) {
			addCriterion("node_id <>", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdGreaterThan(Integer value) {
			addCriterion("node_id >", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("node_id >=", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdLessThan(Integer value) {
			addCriterion("node_id <", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
			addCriterion("node_id <=", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdIn(List<Integer> values) {
			addCriterion("node_id in", values, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotIn(List<Integer> values) {
			addCriterion("node_id not in", values, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdBetween(Integer value1, Integer value2) {
			addCriterion("node_id between", value1, value2, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("node_id not between", value1, value2, "nodeId");
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andCommentsCountIsNull() {
			addCriterion("comments_count is null");
			return (Criteria) this;
		}

		public Criteria andCommentsCountIsNotNull() {
			addCriterion("comments_count is not null");
			return (Criteria) this;
		}

		public Criteria andCommentsCountEqualTo(Integer value) {
			addCriterion("comments_count =", value, "commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountNotEqualTo(Integer value) {
			addCriterion("comments_count <>", value, "commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountGreaterThan(Integer value) {
			addCriterion("comments_count >", value, "commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("comments_count >=", value, "commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountLessThan(Integer value) {
			addCriterion("comments_count <", value, "commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountLessThanOrEqualTo(Integer value) {
			addCriterion("comments_count <=", value, "commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountIn(List<Integer> values) {
			addCriterion("comments_count in", values, "commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountNotIn(List<Integer> values) {
			addCriterion("comments_count not in", values, "commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountBetween(Integer value1, Integer value2) {
			addCriterion("comments_count between", value1, value2,
					"commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsCountNotBetween(Integer value1,
				Integer value2) {
			addCriterion("comments_count not between", value1, value2,
					"commentsCount");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedIsNull() {
			addCriterion("is_comments_closed is null");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedIsNotNull() {
			addCriterion("is_comments_closed is not null");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedEqualTo(Byte value) {
			addCriterion("is_comments_closed =", value, "commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedNotEqualTo(Byte value) {
			addCriterion("is_comments_closed <>", value, "commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedGreaterThan(Byte value) {
			addCriterion("is_comments_closed >", value, "commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_comments_closed >=", value, "commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedLessThan(Byte value) {
			addCriterion("is_comments_closed <", value, "commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedLessThanOrEqualTo(Byte value) {
			addCriterion("is_comments_closed <=", value, "commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedIn(List<Byte> values) {
			addCriterion("is_comments_closed in", values, "commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedNotIn(List<Byte> values) {
			addCriterion("is_comments_closed not in", values, "commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedBetween(Byte value1, Byte value2) {
			addCriterion("is_comments_closed between", value1, value2,
					"commentsClosed");
			return (Criteria) this;
		}

		public Criteria andCommentsClosedNotBetween(Byte value1, Byte value2) {
			addCriterion("is_comments_closed not between", value1, value2,
					"commentsClosed");
			return (Criteria) this;
		}

		public Criteria andBrowseNumIsNull() {
			addCriterion("browse_num is null");
			return (Criteria) this;
		}

		public Criteria andBrowseNumIsNotNull() {
			addCriterion("browse_num is not null");
			return (Criteria) this;
		}

		public Criteria andBrowseNumEqualTo(Integer value) {
			addCriterion("browse_num =", value, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumNotEqualTo(Integer value) {
			addCriterion("browse_num <>", value, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumGreaterThan(Integer value) {
			addCriterion("browse_num >", value, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("browse_num >=", value, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumLessThan(Integer value) {
			addCriterion("browse_num <", value, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumLessThanOrEqualTo(Integer value) {
			addCriterion("browse_num <=", value, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumIn(List<Integer> values) {
			addCriterion("browse_num in", values, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumNotIn(List<Integer> values) {
			addCriterion("browse_num not in", values, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumBetween(Integer value1, Integer value2) {
			addCriterion("browse_num between", value1, value2, "browseNum");
			return (Criteria) this;
		}

		public Criteria andBrowseNumNotBetween(Integer value1, Integer value2) {
			addCriterion("browse_num not between", value1, value2, "browseNum");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByIsNull() {
			addCriterion("last_replied_by is null");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByIsNotNull() {
			addCriterion("last_replied_by is not null");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByEqualTo(String value) {
			addCriterion("last_replied_by =", value, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByNotEqualTo(String value) {
			addCriterion("last_replied_by <>", value, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByGreaterThan(String value) {
			addCriterion("last_replied_by >", value, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByGreaterThanOrEqualTo(String value) {
			addCriterion("last_replied_by >=", value, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByLessThan(String value) {
			addCriterion("last_replied_by <", value, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByLessThanOrEqualTo(String value) {
			addCriterion("last_replied_by <=", value, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByLike(String value) {
			addCriterion("last_replied_by like", value, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByNotLike(String value) {
			addCriterion("last_replied_by not like", value, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByIn(List<String> values) {
			addCriterion("last_replied_by in", values, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByNotIn(List<String> values) {
			addCriterion("last_replied_by not in", values, "lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByBetween(String value1, String value2) {
			addCriterion("last_replied_by between", value1, value2,
					"lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByNotBetween(String value1, String value2) {
			addCriterion("last_replied_by not between", value1, value2,
					"lastRepliedBy");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtIsNull() {
			addCriterion("last_replied_at is null");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtIsNotNull() {
			addCriterion("last_replied_at is not null");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtEqualTo(Date value) {
			addCriterion("last_replied_at =", value, "lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtNotEqualTo(Date value) {
			addCriterion("last_replied_at <>", value, "lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtGreaterThan(Date value) {
			addCriterion("last_replied_at >", value, "lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtGreaterThanOrEqualTo(Date value) {
			addCriterion("last_replied_at >=", value, "lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtLessThan(Date value) {
			addCriterion("last_replied_at <", value, "lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtLessThanOrEqualTo(Date value) {
			addCriterion("last_replied_at <=", value, "lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtIn(List<Date> values) {
			addCriterion("last_replied_at in", values, "lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtNotIn(List<Date> values) {
			addCriterion("last_replied_at not in", values, "lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtBetween(Date value1, Date value2) {
			addCriterion("last_replied_at between", value1, value2,
					"lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andLastRepliedAtNotBetween(Date value1, Date value2) {
			addCriterion("last_replied_at not between", value1, value2,
					"lastRepliedAt");
			return (Criteria) this;
		}

		public Criteria andTitleLikeInsensitive(String value) {
			addCriterion("upper(title) like", value.toUpperCase(), "title");
			return (Criteria) this;
		}

		public Criteria andLastRepliedByLikeInsensitive(String value) {
			addCriterion("upper(last_replied_by) like", value.toUpperCase(),
					"lastRepliedBy");
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