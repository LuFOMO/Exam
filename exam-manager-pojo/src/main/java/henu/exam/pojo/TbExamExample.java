package henu.exam.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbExamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbExamExample() {
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

        public Criteria andTeachnameIsNull() {
            addCriterion("teachname is null");
            return (Criteria) this;
        }

        public Criteria andTeachnameIsNotNull() {
            addCriterion("teachname is not null");
            return (Criteria) this;
        }

        public Criteria andTeachnameEqualTo(String value) {
            addCriterion("teachname =", value, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameNotEqualTo(String value) {
            addCriterion("teachname <>", value, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameGreaterThan(String value) {
            addCriterion("teachname >", value, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameGreaterThanOrEqualTo(String value) {
            addCriterion("teachname >=", value, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameLessThan(String value) {
            addCriterion("teachname <", value, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameLessThanOrEqualTo(String value) {
            addCriterion("teachname <=", value, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameLike(String value) {
            addCriterion("teachname like", value, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameNotLike(String value) {
            addCriterion("teachname not like", value, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameIn(List<String> values) {
            addCriterion("teachname in", values, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameNotIn(List<String> values) {
            addCriterion("teachname not in", values, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameBetween(String value1, String value2) {
            addCriterion("teachname between", value1, value2, "teachname");
            return (Criteria) this;
        }

        public Criteria andTeachnameNotBetween(String value1, String value2) {
            addCriterion("teachname not between", value1, value2, "teachname");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("starttime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("starttime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("endtime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("endtime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andAutostartIsNull() {
            addCriterion("autostart is null");
            return (Criteria) this;
        }

        public Criteria andAutostartIsNotNull() {
            addCriterion("autostart is not null");
            return (Criteria) this;
        }

        public Criteria andAutostartEqualTo(String value) {
            addCriterion("autostart =", value, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartNotEqualTo(String value) {
            addCriterion("autostart <>", value, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartGreaterThan(String value) {
            addCriterion("autostart >", value, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartGreaterThanOrEqualTo(String value) {
            addCriterion("autostart >=", value, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartLessThan(String value) {
            addCriterion("autostart <", value, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartLessThanOrEqualTo(String value) {
            addCriterion("autostart <=", value, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartLike(String value) {
            addCriterion("autostart like", value, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartNotLike(String value) {
            addCriterion("autostart not like", value, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartIn(List<String> values) {
            addCriterion("autostart in", values, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartNotIn(List<String> values) {
            addCriterion("autostart not in", values, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartBetween(String value1, String value2) {
            addCriterion("autostart between", value1, value2, "autostart");
            return (Criteria) this;
        }

        public Criteria andAutostartNotBetween(String value1, String value2) {
            addCriterion("autostart not between", value1, value2, "autostart");
            return (Criteria) this;
        }

        public Criteria andStartedIsNull() {
            addCriterion("started is null");
            return (Criteria) this;
        }

        public Criteria andStartedIsNotNull() {
            addCriterion("started is not null");
            return (Criteria) this;
        }

        public Criteria andStartedEqualTo(String value) {
            addCriterion("started =", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedNotEqualTo(String value) {
            addCriterion("started <>", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedGreaterThan(String value) {
            addCriterion("started >", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedGreaterThanOrEqualTo(String value) {
            addCriterion("started >=", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedLessThan(String value) {
            addCriterion("started <", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedLessThanOrEqualTo(String value) {
            addCriterion("started <=", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedLike(String value) {
            addCriterion("started like", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedNotLike(String value) {
            addCriterion("started not like", value, "started");
            return (Criteria) this;
        }

        public Criteria andStartedIn(List<String> values) {
            addCriterion("started in", values, "started");
            return (Criteria) this;
        }

        public Criteria andStartedNotIn(List<String> values) {
            addCriterion("started not in", values, "started");
            return (Criteria) this;
        }

        public Criteria andStartedBetween(String value1, String value2) {
            addCriterion("started between", value1, value2, "started");
            return (Criteria) this;
        }

        public Criteria andStartedNotBetween(String value1, String value2) {
            addCriterion("started not between", value1, value2, "started");
            return (Criteria) this;
        }

        public Criteria andFinishedIsNull() {
            addCriterion("finished is null");
            return (Criteria) this;
        }

        public Criteria andFinishedIsNotNull() {
            addCriterion("finished is not null");
            return (Criteria) this;
        }

        public Criteria andFinishedEqualTo(String value) {
            addCriterion("finished =", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedNotEqualTo(String value) {
            addCriterion("finished <>", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedGreaterThan(String value) {
            addCriterion("finished >", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedGreaterThanOrEqualTo(String value) {
            addCriterion("finished >=", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedLessThan(String value) {
            addCriterion("finished <", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedLessThanOrEqualTo(String value) {
            addCriterion("finished <=", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedLike(String value) {
            addCriterion("finished like", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedNotLike(String value) {
            addCriterion("finished not like", value, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedIn(List<String> values) {
            addCriterion("finished in", values, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedNotIn(List<String> values) {
            addCriterion("finished not in", values, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedBetween(String value1, String value2) {
            addCriterion("finished between", value1, value2, "finished");
            return (Criteria) this;
        }

        public Criteria andFinishedNotBetween(String value1, String value2) {
            addCriterion("finished not between", value1, value2, "finished");
            return (Criteria) this;
        }

        public Criteria andArchivedIsNull() {
            addCriterion("archived is null");
            return (Criteria) this;
        }

        public Criteria andArchivedIsNotNull() {
            addCriterion("archived is not null");
            return (Criteria) this;
        }

        public Criteria andArchivedEqualTo(String value) {
            addCriterion("archived =", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotEqualTo(String value) {
            addCriterion("archived <>", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedGreaterThan(String value) {
            addCriterion("archived >", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedGreaterThanOrEqualTo(String value) {
            addCriterion("archived >=", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedLessThan(String value) {
            addCriterion("archived <", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedLessThanOrEqualTo(String value) {
            addCriterion("archived <=", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedLike(String value) {
            addCriterion("archived like", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotLike(String value) {
            addCriterion("archived not like", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedIn(List<String> values) {
            addCriterion("archived in", values, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotIn(List<String> values) {
            addCriterion("archived not in", values, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedBetween(String value1, String value2) {
            addCriterion("archived between", value1, value2, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotBetween(String value1, String value2) {
            addCriterion("archived not between", value1, value2, "archived");
            return (Criteria) this;
        }

        public Criteria andCleanedIsNull() {
            addCriterion("cleaned is null");
            return (Criteria) this;
        }

        public Criteria andCleanedIsNotNull() {
            addCriterion("cleaned is not null");
            return (Criteria) this;
        }

        public Criteria andCleanedEqualTo(String value) {
            addCriterion("cleaned =", value, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedNotEqualTo(String value) {
            addCriterion("cleaned <>", value, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedGreaterThan(String value) {
            addCriterion("cleaned >", value, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedGreaterThanOrEqualTo(String value) {
            addCriterion("cleaned >=", value, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedLessThan(String value) {
            addCriterion("cleaned <", value, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedLessThanOrEqualTo(String value) {
            addCriterion("cleaned <=", value, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedLike(String value) {
            addCriterion("cleaned like", value, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedNotLike(String value) {
            addCriterion("cleaned not like", value, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedIn(List<String> values) {
            addCriterion("cleaned in", values, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedNotIn(List<String> values) {
            addCriterion("cleaned not in", values, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedBetween(String value1, String value2) {
            addCriterion("cleaned between", value1, value2, "cleaned");
            return (Criteria) this;
        }

        public Criteria andCleanedNotBetween(String value1, String value2) {
            addCriterion("cleaned not between", value1, value2, "cleaned");
            return (Criteria) this;
        }

        public Criteria andExampaperIsNull() {
            addCriterion("exampaper is null");
            return (Criteria) this;
        }

        public Criteria andExampaperIsNotNull() {
            addCriterion("exampaper is not null");
            return (Criteria) this;
        }

        public Criteria andExampaperEqualTo(String value) {
            addCriterion("exampaper =", value, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperNotEqualTo(String value) {
            addCriterion("exampaper <>", value, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperGreaterThan(String value) {
            addCriterion("exampaper >", value, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperGreaterThanOrEqualTo(String value) {
            addCriterion("exampaper >=", value, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperLessThan(String value) {
            addCriterion("exampaper <", value, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperLessThanOrEqualTo(String value) {
            addCriterion("exampaper <=", value, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperLike(String value) {
            addCriterion("exampaper like", value, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperNotLike(String value) {
            addCriterion("exampaper not like", value, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperIn(List<String> values) {
            addCriterion("exampaper in", values, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperNotIn(List<String> values) {
            addCriterion("exampaper not in", values, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperBetween(String value1, String value2) {
            addCriterion("exampaper between", value1, value2, "exampaper");
            return (Criteria) this;
        }

        public Criteria andExampaperNotBetween(String value1, String value2) {
            addCriterion("exampaper not between", value1, value2, "exampaper");
            return (Criteria) this;
        }

        public Criteria andPaperUrlIsNull() {
            addCriterion("paper_url is null");
            return (Criteria) this;
        }

        public Criteria andPaperUrlIsNotNull() {
            addCriterion("paper_url is not null");
            return (Criteria) this;
        }

        public Criteria andPaperUrlEqualTo(String value) {
            addCriterion("paper_url =", value, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlNotEqualTo(String value) {
            addCriterion("paper_url <>", value, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlGreaterThan(String value) {
            addCriterion("paper_url >", value, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlGreaterThanOrEqualTo(String value) {
            addCriterion("paper_url >=", value, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlLessThan(String value) {
            addCriterion("paper_url <", value, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlLessThanOrEqualTo(String value) {
            addCriterion("paper_url <=", value, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlLike(String value) {
            addCriterion("paper_url like", value, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlNotLike(String value) {
            addCriterion("paper_url not like", value, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlIn(List<String> values) {
            addCriterion("paper_url in", values, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlNotIn(List<String> values) {
            addCriterion("paper_url not in", values, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlBetween(String value1, String value2) {
            addCriterion("paper_url between", value1, value2, "paperUrl");
            return (Criteria) this;
        }

        public Criteria andPaperUrlNotBetween(String value1, String value2) {
            addCriterion("paper_url not between", value1, value2, "paperUrl");
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