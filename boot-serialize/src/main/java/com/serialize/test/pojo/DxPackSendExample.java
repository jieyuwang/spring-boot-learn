package com.serialize.test.pojo;

import java.util.ArrayList;
import java.util.List;

public class DxPackSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DxPackSendExample() {
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

        public Criteria andPackIdIsNull() {
            addCriterion("PACK_ID is null");
            return (Criteria) this;
        }

        public Criteria andPackIdIsNotNull() {
            addCriterion("PACK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPackIdEqualTo(String value) {
            addCriterion("PACK_ID =", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdNotEqualTo(String value) {
            addCriterion("PACK_ID <>", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdGreaterThan(String value) {
            addCriterion("PACK_ID >", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdGreaterThanOrEqualTo(String value) {
            addCriterion("PACK_ID >=", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdLessThan(String value) {
            addCriterion("PACK_ID <", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdLessThanOrEqualTo(String value) {
            addCriterion("PACK_ID <=", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdLike(String value) {
            addCriterion("PACK_ID like", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdNotLike(String value) {
            addCriterion("PACK_ID not like", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdIn(List<String> values) {
            addCriterion("PACK_ID in", values, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdNotIn(List<String> values) {
            addCriterion("PACK_ID not in", values, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdBetween(String value1, String value2) {
            addCriterion("PACK_ID between", value1, value2, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdNotBetween(String value1, String value2) {
            addCriterion("PACK_ID not between", value1, value2, "packId");
            return (Criteria) this;
        }

        public Criteria andPackTypeIsNull() {
            addCriterion("PACK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPackTypeIsNotNull() {
            addCriterion("PACK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPackTypeEqualTo(String value) {
            addCriterion("PACK_TYPE =", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeNotEqualTo(String value) {
            addCriterion("PACK_TYPE <>", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeGreaterThan(String value) {
            addCriterion("PACK_TYPE >", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PACK_TYPE >=", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeLessThan(String value) {
            addCriterion("PACK_TYPE <", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeLessThanOrEqualTo(String value) {
            addCriterion("PACK_TYPE <=", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeLike(String value) {
            addCriterion("PACK_TYPE like", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeNotLike(String value) {
            addCriterion("PACK_TYPE not like", value, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeIn(List<String> values) {
            addCriterion("PACK_TYPE in", values, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeNotIn(List<String> values) {
            addCriterion("PACK_TYPE not in", values, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeBetween(String value1, String value2) {
            addCriterion("PACK_TYPE between", value1, value2, "packType");
            return (Criteria) this;
        }

        public Criteria andPackTypeNotBetween(String value1, String value2) {
            addCriterion("PACK_TYPE not between", value1, value2, "packType");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("CHANNEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("CHANNEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("CHANNEL_ID =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("CHANNEL_ID <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("CHANNEL_ID >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_ID >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("CHANNEL_ID <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_ID <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("CHANNEL_ID like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("CHANNEL_ID not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("CHANNEL_ID in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("CHANNEL_ID not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("CHANNEL_ID between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_ID not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andRouteHistIsNull() {
            addCriterion("ROUTE_HIST is null");
            return (Criteria) this;
        }

        public Criteria andRouteHistIsNotNull() {
            addCriterion("ROUTE_HIST is not null");
            return (Criteria) this;
        }

        public Criteria andRouteHistEqualTo(String value) {
            addCriterion("ROUTE_HIST =", value, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistNotEqualTo(String value) {
            addCriterion("ROUTE_HIST <>", value, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistGreaterThan(String value) {
            addCriterion("ROUTE_HIST >", value, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTE_HIST >=", value, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistLessThan(String value) {
            addCriterion("ROUTE_HIST <", value, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistLessThanOrEqualTo(String value) {
            addCriterion("ROUTE_HIST <=", value, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistLike(String value) {
            addCriterion("ROUTE_HIST like", value, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistNotLike(String value) {
            addCriterion("ROUTE_HIST not like", value, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistIn(List<String> values) {
            addCriterion("ROUTE_HIST in", values, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistNotIn(List<String> values) {
            addCriterion("ROUTE_HIST not in", values, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistBetween(String value1, String value2) {
            addCriterion("ROUTE_HIST between", value1, value2, "routeHist");
            return (Criteria) this;
        }

        public Criteria andRouteHistNotBetween(String value1, String value2) {
            addCriterion("ROUTE_HIST not between", value1, value2, "routeHist");
            return (Criteria) this;
        }

        public Criteria andPackSendStatIsNull() {
            addCriterion("PACK_SEND_STAT is null");
            return (Criteria) this;
        }

        public Criteria andPackSendStatIsNotNull() {
            addCriterion("PACK_SEND_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andPackSendStatEqualTo(String value) {
            addCriterion("PACK_SEND_STAT =", value, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatNotEqualTo(String value) {
            addCriterion("PACK_SEND_STAT <>", value, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatGreaterThan(String value) {
            addCriterion("PACK_SEND_STAT >", value, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatGreaterThanOrEqualTo(String value) {
            addCriterion("PACK_SEND_STAT >=", value, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatLessThan(String value) {
            addCriterion("PACK_SEND_STAT <", value, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatLessThanOrEqualTo(String value) {
            addCriterion("PACK_SEND_STAT <=", value, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatLike(String value) {
            addCriterion("PACK_SEND_STAT like", value, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatNotLike(String value) {
            addCriterion("PACK_SEND_STAT not like", value, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatIn(List<String> values) {
            addCriterion("PACK_SEND_STAT in", values, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatNotIn(List<String> values) {
            addCriterion("PACK_SEND_STAT not in", values, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatBetween(String value1, String value2) {
            addCriterion("PACK_SEND_STAT between", value1, value2, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andPackSendStatNotBetween(String value1, String value2) {
            addCriterion("PACK_SEND_STAT not between", value1, value2, "packSendStat");
            return (Criteria) this;
        }

        public Criteria andStateTimeIsNull() {
            addCriterion("STATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStateTimeIsNotNull() {
            addCriterion("STATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStateTimeEqualTo(String value) {
            addCriterion("STATE_TIME =", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotEqualTo(String value) {
            addCriterion("STATE_TIME <>", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeGreaterThan(String value) {
            addCriterion("STATE_TIME >", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("STATE_TIME >=", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeLessThan(String value) {
            addCriterion("STATE_TIME <", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeLessThanOrEqualTo(String value) {
            addCriterion("STATE_TIME <=", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeLike(String value) {
            addCriterion("STATE_TIME like", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotLike(String value) {
            addCriterion("STATE_TIME not like", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeIn(List<String> values) {
            addCriterion("STATE_TIME in", values, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotIn(List<String> values) {
            addCriterion("STATE_TIME not in", values, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeBetween(String value1, String value2) {
            addCriterion("STATE_TIME between", value1, value2, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotBetween(String value1, String value2) {
            addCriterion("STATE_TIME not between", value1, value2, "stateTime");
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