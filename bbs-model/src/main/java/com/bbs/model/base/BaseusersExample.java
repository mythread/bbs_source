package com.bbs.model.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbs.core.Pagination;

public class BaseusersExample implements Serializable {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public BaseusersExample() {
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

		public Criteria andNicknameIsNull() {
			addCriterion("nickname is null");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNotNull() {
			addCriterion("nickname is not null");
			return (Criteria) this;
		}

		public Criteria andNicknameEqualTo(String value) {
			addCriterion("nickname =", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotEqualTo(String value) {
			addCriterion("nickname <>", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThan(String value) {
			addCriterion("nickname >", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThanOrEqualTo(String value) {
			addCriterion("nickname >=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThan(String value) {
			addCriterion("nickname <", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThanOrEqualTo(String value) {
			addCriterion("nickname <=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLike(String value) {
			addCriterion("nickname like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotLike(String value) {
			addCriterion("nickname not like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameIn(List<String> values) {
			addCriterion("nickname in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotIn(List<String> values) {
			addCriterion("nickname not in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameBetween(String value1, String value2) {
			addCriterion("nickname between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotBetween(String value1, String value2) {
			addCriterion("nickname not between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andSignInCountIsNull() {
			addCriterion("sign_in_count is null");
			return (Criteria) this;
		}

		public Criteria andSignInCountIsNotNull() {
			addCriterion("sign_in_count is not null");
			return (Criteria) this;
		}

		public Criteria andSignInCountEqualTo(Integer value) {
			addCriterion("sign_in_count =", value, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountNotEqualTo(Integer value) {
			addCriterion("sign_in_count <>", value, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountGreaterThan(Integer value) {
			addCriterion("sign_in_count >", value, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("sign_in_count >=", value, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountLessThan(Integer value) {
			addCriterion("sign_in_count <", value, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountLessThanOrEqualTo(Integer value) {
			addCriterion("sign_in_count <=", value, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountIn(List<Integer> values) {
			addCriterion("sign_in_count in", values, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountNotIn(List<Integer> values) {
			addCriterion("sign_in_count not in", values, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountBetween(Integer value1, Integer value2) {
			addCriterion("sign_in_count between", value1, value2, "signInCount");
			return (Criteria) this;
		}

		public Criteria andSignInCountNotBetween(Integer value1, Integer value2) {
			addCriterion("sign_in_count not between", value1, value2,
					"signInCount");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtIsNull() {
			addCriterion("current_sign_in_at is null");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtIsNotNull() {
			addCriterion("current_sign_in_at is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtEqualTo(Date value) {
			addCriterion("current_sign_in_at =", value, "currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtNotEqualTo(Date value) {
			addCriterion("current_sign_in_at <>", value, "currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtGreaterThan(Date value) {
			addCriterion("current_sign_in_at >", value, "currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtGreaterThanOrEqualTo(Date value) {
			addCriterion("current_sign_in_at >=", value, "currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtLessThan(Date value) {
			addCriterion("current_sign_in_at <", value, "currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtLessThanOrEqualTo(Date value) {
			addCriterion("current_sign_in_at <=", value, "currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtIn(List<Date> values) {
			addCriterion("current_sign_in_at in", values, "currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtNotIn(List<Date> values) {
			addCriterion("current_sign_in_at not in", values, "currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtBetween(Date value1, Date value2) {
			addCriterion("current_sign_in_at between", value1, value2,
					"currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInAtNotBetween(Date value1, Date value2) {
			addCriterion("current_sign_in_at not between", value1, value2,
					"currentSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtIsNull() {
			addCriterion("last_sign_in_at is null");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtIsNotNull() {
			addCriterion("last_sign_in_at is not null");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtEqualTo(Date value) {
			addCriterion("last_sign_in_at =", value, "lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtNotEqualTo(Date value) {
			addCriterion("last_sign_in_at <>", value, "lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtGreaterThan(Date value) {
			addCriterion("last_sign_in_at >", value, "lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtGreaterThanOrEqualTo(Date value) {
			addCriterion("last_sign_in_at >=", value, "lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtLessThan(Date value) {
			addCriterion("last_sign_in_at <", value, "lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtLessThanOrEqualTo(Date value) {
			addCriterion("last_sign_in_at <=", value, "lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtIn(List<Date> values) {
			addCriterion("last_sign_in_at in", values, "lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtNotIn(List<Date> values) {
			addCriterion("last_sign_in_at not in", values, "lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtBetween(Date value1, Date value2) {
			addCriterion("last_sign_in_at between", value1, value2,
					"lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andLastSignInAtNotBetween(Date value1, Date value2) {
			addCriterion("last_sign_in_at not between", value1, value2,
					"lastSignInAt");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpIsNull() {
			addCriterion("current_sign_in_ip is null");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpIsNotNull() {
			addCriterion("current_sign_in_ip is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpEqualTo(String value) {
			addCriterion("current_sign_in_ip =", value, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpNotEqualTo(String value) {
			addCriterion("current_sign_in_ip <>", value, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpGreaterThan(String value) {
			addCriterion("current_sign_in_ip >", value, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpGreaterThanOrEqualTo(String value) {
			addCriterion("current_sign_in_ip >=", value, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpLessThan(String value) {
			addCriterion("current_sign_in_ip <", value, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpLessThanOrEqualTo(String value) {
			addCriterion("current_sign_in_ip <=", value, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpLike(String value) {
			addCriterion("current_sign_in_ip like", value, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpNotLike(String value) {
			addCriterion("current_sign_in_ip not like", value,
					"currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpIn(List<String> values) {
			addCriterion("current_sign_in_ip in", values, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpNotIn(List<String> values) {
			addCriterion("current_sign_in_ip not in", values, "currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpBetween(String value1, String value2) {
			addCriterion("current_sign_in_ip between", value1, value2,
					"currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpNotBetween(String value1,
				String value2) {
			addCriterion("current_sign_in_ip not between", value1, value2,
					"currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpIsNull() {
			addCriterion("last_sign_in_ip is null");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpIsNotNull() {
			addCriterion("last_sign_in_ip is not null");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpEqualTo(String value) {
			addCriterion("last_sign_in_ip =", value, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpNotEqualTo(String value) {
			addCriterion("last_sign_in_ip <>", value, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpGreaterThan(String value) {
			addCriterion("last_sign_in_ip >", value, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpGreaterThanOrEqualTo(String value) {
			addCriterion("last_sign_in_ip >=", value, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpLessThan(String value) {
			addCriterion("last_sign_in_ip <", value, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpLessThanOrEqualTo(String value) {
			addCriterion("last_sign_in_ip <=", value, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpLike(String value) {
			addCriterion("last_sign_in_ip like", value, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpNotLike(String value) {
			addCriterion("last_sign_in_ip not like", value, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpIn(List<String> values) {
			addCriterion("last_sign_in_ip in", values, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpNotIn(List<String> values) {
			addCriterion("last_sign_in_ip not in", values, "lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpBetween(String value1, String value2) {
			addCriterion("last_sign_in_ip between", value1, value2,
					"lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpNotBetween(String value1, String value2) {
			addCriterion("last_sign_in_ip not between", value1, value2,
					"lastSignInIp");
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

		public Criteria andAvatarIsNull() {
			addCriterion("avatar is null");
			return (Criteria) this;
		}

		public Criteria andAvatarIsNotNull() {
			addCriterion("avatar is not null");
			return (Criteria) this;
		}

		public Criteria andAvatarEqualTo(String value) {
			addCriterion("avatar =", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotEqualTo(String value) {
			addCriterion("avatar <>", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarGreaterThan(String value) {
			addCriterion("avatar >", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarGreaterThanOrEqualTo(String value) {
			addCriterion("avatar >=", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLessThan(String value) {
			addCriterion("avatar <", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLessThanOrEqualTo(String value) {
			addCriterion("avatar <=", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLike(String value) {
			addCriterion("avatar like", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotLike(String value) {
			addCriterion("avatar not like", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarIn(List<String> values) {
			addCriterion("avatar in", values, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotIn(List<String> values) {
			addCriterion("avatar not in", values, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarBetween(String value1, String value2) {
			addCriterion("avatar between", value1, value2, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotBetween(String value1, String value2) {
			addCriterion("avatar not between", value1, value2, "avatar");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andNicknameLikeInsensitive(String value) {
			addCriterion("upper(nickname) like", value.toUpperCase(),
					"nickname");
			return (Criteria) this;
		}

		public Criteria andEmailLikeInsensitive(String value) {
			addCriterion("upper(email) like", value.toUpperCase(), "email");
			return (Criteria) this;
		}

		public Criteria andPasswordLikeInsensitive(String value) {
			addCriterion("upper(password) like", value.toUpperCase(),
					"password");
			return (Criteria) this;
		}

		public Criteria andCurrentSignInIpLikeInsensitive(String value) {
			addCriterion("upper(current_sign_in_ip) like", value.toUpperCase(),
					"currentSignInIp");
			return (Criteria) this;
		}

		public Criteria andLastSignInIpLikeInsensitive(String value) {
			addCriterion("upper(last_sign_in_ip) like", value.toUpperCase(),
					"lastSignInIp");
			return (Criteria) this;
		}

		public Criteria andAvatarLikeInsensitive(String value) {
			addCriterion("upper(avatar) like", value.toUpperCase(), "avatar");
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