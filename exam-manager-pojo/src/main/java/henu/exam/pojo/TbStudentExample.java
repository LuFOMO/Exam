package henu.exam.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbStudentExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andClazzIsNull() {
            addCriterion("clazz is null");
            return (Criteria) this;
        }

        public Criteria andClazzIsNotNull() {
            addCriterion("clazz is not null");
            return (Criteria) this;
        }

        public Criteria andClazzEqualTo(String value) {
            addCriterion("clazz =", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotEqualTo(String value) {
            addCriterion("clazz <>", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzGreaterThan(String value) {
            addCriterion("clazz >", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzGreaterThanOrEqualTo(String value) {
            addCriterion("clazz >=", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLessThan(String value) {
            addCriterion("clazz <", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLessThanOrEqualTo(String value) {
            addCriterion("clazz <=", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLike(String value) {
            addCriterion("clazz like", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotLike(String value) {
            addCriterion("clazz not like", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzIn(List<String> values) {
            addCriterion("clazz in", values, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotIn(List<String> values) {
            addCriterion("clazz not in", values, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzBetween(String value1, String value2) {
            addCriterion("clazz between", value1, value2, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotBetween(String value1, String value2) {
            addCriterion("clazz not between", value1, value2, "clazz");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIsLoginIsNull() {
            addCriterion("is_login is null");
            return (Criteria) this;
        }

        public Criteria andIsLoginIsNotNull() {
            addCriterion("is_login is not null");
            return (Criteria) this;
        }

        public Criteria andIsLoginEqualTo(String value) {
            addCriterion("is_login =", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotEqualTo(String value) {
            addCriterion("is_login <>", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginGreaterThan(String value) {
            addCriterion("is_login >", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginGreaterThanOrEqualTo(String value) {
            addCriterion("is_login >=", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginLessThan(String value) {
            addCriterion("is_login <", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginLessThanOrEqualTo(String value) {
            addCriterion("is_login <=", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginLike(String value) {
            addCriterion("is_login like", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotLike(String value) {
            addCriterion("is_login not like", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginIn(List<String> values) {
            addCriterion("is_login in", values, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotIn(List<String> values) {
            addCriterion("is_login not in", values, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginBetween(String value1, String value2) {
            addCriterion("is_login between", value1, value2, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotBetween(String value1, String value2) {
            addCriterion("is_login not between", value1, value2, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIpbindingIsNull() {
            addCriterion("ipbinding is null");
            return (Criteria) this;
        }

        public Criteria andIpbindingIsNotNull() {
            addCriterion("ipbinding is not null");
            return (Criteria) this;
        }

        public Criteria andIpbindingEqualTo(String value) {
            addCriterion("ipbinding =", value, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingNotEqualTo(String value) {
            addCriterion("ipbinding <>", value, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingGreaterThan(String value) {
            addCriterion("ipbinding >", value, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingGreaterThanOrEqualTo(String value) {
            addCriterion("ipbinding >=", value, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingLessThan(String value) {
            addCriterion("ipbinding <", value, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingLessThanOrEqualTo(String value) {
            addCriterion("ipbinding <=", value, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingLike(String value) {
            addCriterion("ipbinding like", value, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingNotLike(String value) {
            addCriterion("ipbinding not like", value, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingIn(List<String> values) {
            addCriterion("ipbinding in", values, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingNotIn(List<String> values) {
            addCriterion("ipbinding not in", values, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingBetween(String value1, String value2) {
            addCriterion("ipbinding between", value1, value2, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIpbindingNotBetween(String value1, String value2) {
            addCriterion("ipbinding not between", value1, value2, "ipbinding");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIsNull() {
            addCriterion("is_submit is null");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIsNotNull() {
            addCriterion("is_submit is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubmitEqualTo(String value) {
            addCriterion("is_submit =", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotEqualTo(String value) {
            addCriterion("is_submit <>", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitGreaterThan(String value) {
            addCriterion("is_submit >", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitGreaterThanOrEqualTo(String value) {
            addCriterion("is_submit >=", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitLessThan(String value) {
            addCriterion("is_submit <", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitLessThanOrEqualTo(String value) {
            addCriterion("is_submit <=", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitLike(String value) {
            addCriterion("is_submit like", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotLike(String value) {
            addCriterion("is_submit not like", value, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitIn(List<String> values) {
            addCriterion("is_submit in", values, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotIn(List<String> values) {
            addCriterion("is_submit not in", values, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitBetween(String value1, String value2) {
            addCriterion("is_submit between", value1, value2, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSubmitNotBetween(String value1, String value2) {
            addCriterion("is_submit not between", value1, value2, "isSubmit");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNull() {
            addCriterion("submittime is null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNotNull() {
            addCriterion("submittime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeEqualTo(Date value) {
            addCriterion("submittime =", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotEqualTo(Date value) {
            addCriterion("submittime <>", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThan(Date value) {
            addCriterion("submittime >", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submittime >=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThan(Date value) {
            addCriterion("submittime <", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThanOrEqualTo(Date value) {
            addCriterion("submittime <=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIn(List<Date> values) {
            addCriterion("submittime in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotIn(List<Date> values) {
            addCriterion("submittime not in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeBetween(Date value1, Date value2) {
            addCriterion("submittime between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotBetween(Date value1, Date value2) {
            addCriterion("submittime not between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlIsNull() {
            addCriterion("submit_url is null");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlIsNotNull() {
            addCriterion("submit_url is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlEqualTo(String value) {
            addCriterion("submit_url =", value, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlNotEqualTo(String value) {
            addCriterion("submit_url <>", value, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlGreaterThan(String value) {
            addCriterion("submit_url >", value, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("submit_url >=", value, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlLessThan(String value) {
            addCriterion("submit_url <", value, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlLessThanOrEqualTo(String value) {
            addCriterion("submit_url <=", value, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlLike(String value) {
            addCriterion("submit_url like", value, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlNotLike(String value) {
            addCriterion("submit_url not like", value, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlIn(List<String> values) {
            addCriterion("submit_url in", values, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlNotIn(List<String> values) {
            addCriterion("submit_url not in", values, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlBetween(String value1, String value2) {
            addCriterion("submit_url between", value1, value2, "submitUrl");
            return (Criteria) this;
        }

        public Criteria andSubmitUrlNotBetween(String value1, String value2) {
            addCriterion("submit_url not between", value1, value2, "submitUrl");
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