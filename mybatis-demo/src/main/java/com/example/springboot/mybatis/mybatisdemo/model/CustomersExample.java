package com.example.springboot.mybatis.mybatisdemo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomersExample() {
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

        public Criteria andCustomernumberIsNull() {
            addCriterion("customerNumber is null");
            return (Criteria) this;
        }

        public Criteria andCustomernumberIsNotNull() {
            addCriterion("customerNumber is not null");
            return (Criteria) this;
        }

        public Criteria andCustomernumberEqualTo(Integer value) {
            addCriterion("customerNumber =", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberNotEqualTo(Integer value) {
            addCriterion("customerNumber <>", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberGreaterThan(Integer value) {
            addCriterion("customerNumber >", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("customerNumber >=", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberLessThan(Integer value) {
            addCriterion("customerNumber <", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberLessThanOrEqualTo(Integer value) {
            addCriterion("customerNumber <=", value, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberIn(List<Integer> values) {
            addCriterion("customerNumber in", values, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberNotIn(List<Integer> values) {
            addCriterion("customerNumber not in", values, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberBetween(Integer value1, Integer value2) {
            addCriterion("customerNumber between", value1, value2, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernumberNotBetween(Integer value1, Integer value2) {
            addCriterion("customerNumber not between", value1, value2, "customernumber");
            return (Criteria) this;
        }

        public Criteria andCustomernameIsNull() {
            addCriterion("customerName is null");
            return (Criteria) this;
        }

        public Criteria andCustomernameIsNotNull() {
            addCriterion("customerName is not null");
            return (Criteria) this;
        }

        public Criteria andCustomernameEqualTo(String value) {
            addCriterion("customerName =", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotEqualTo(String value) {
            addCriterion("customerName <>", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameGreaterThan(String value) {
            addCriterion("customerName >", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameGreaterThanOrEqualTo(String value) {
            addCriterion("customerName >=", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLessThan(String value) {
            addCriterion("customerName <", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLessThanOrEqualTo(String value) {
            addCriterion("customerName <=", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLike(String value) {
            addCriterion("customerName like", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotLike(String value) {
            addCriterion("customerName not like", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameIn(List<String> values) {
            addCriterion("customerName in", values, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotIn(List<String> values) {
            addCriterion("customerName not in", values, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameBetween(String value1, String value2) {
            addCriterion("customerName between", value1, value2, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotBetween(String value1, String value2) {
            addCriterion("customerName not between", value1, value2, "customername");
            return (Criteria) this;
        }

        public Criteria andContactlastnameIsNull() {
            addCriterion("contactLastName is null");
            return (Criteria) this;
        }

        public Criteria andContactlastnameIsNotNull() {
            addCriterion("contactLastName is not null");
            return (Criteria) this;
        }

        public Criteria andContactlastnameEqualTo(String value) {
            addCriterion("contactLastName =", value, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameNotEqualTo(String value) {
            addCriterion("contactLastName <>", value, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameGreaterThan(String value) {
            addCriterion("contactLastName >", value, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameGreaterThanOrEqualTo(String value) {
            addCriterion("contactLastName >=", value, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameLessThan(String value) {
            addCriterion("contactLastName <", value, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameLessThanOrEqualTo(String value) {
            addCriterion("contactLastName <=", value, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameLike(String value) {
            addCriterion("contactLastName like", value, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameNotLike(String value) {
            addCriterion("contactLastName not like", value, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameIn(List<String> values) {
            addCriterion("contactLastName in", values, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameNotIn(List<String> values) {
            addCriterion("contactLastName not in", values, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameBetween(String value1, String value2) {
            addCriterion("contactLastName between", value1, value2, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactlastnameNotBetween(String value1, String value2) {
            addCriterion("contactLastName not between", value1, value2, "contactlastname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameIsNull() {
            addCriterion("contactFirstName is null");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameIsNotNull() {
            addCriterion("contactFirstName is not null");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameEqualTo(String value) {
            addCriterion("contactFirstName =", value, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameNotEqualTo(String value) {
            addCriterion("contactFirstName <>", value, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameGreaterThan(String value) {
            addCriterion("contactFirstName >", value, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameGreaterThanOrEqualTo(String value) {
            addCriterion("contactFirstName >=", value, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameLessThan(String value) {
            addCriterion("contactFirstName <", value, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameLessThanOrEqualTo(String value) {
            addCriterion("contactFirstName <=", value, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameLike(String value) {
            addCriterion("contactFirstName like", value, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameNotLike(String value) {
            addCriterion("contactFirstName not like", value, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameIn(List<String> values) {
            addCriterion("contactFirstName in", values, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameNotIn(List<String> values) {
            addCriterion("contactFirstName not in", values, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameBetween(String value1, String value2) {
            addCriterion("contactFirstName between", value1, value2, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andContactfirstnameNotBetween(String value1, String value2) {
            addCriterion("contactFirstName not between", value1, value2, "contactfirstname");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andAddressline1IsNull() {
            addCriterion("addressLine1 is null");
            return (Criteria) this;
        }

        public Criteria andAddressline1IsNotNull() {
            addCriterion("addressLine1 is not null");
            return (Criteria) this;
        }

        public Criteria andAddressline1EqualTo(String value) {
            addCriterion("addressLine1 =", value, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1NotEqualTo(String value) {
            addCriterion("addressLine1 <>", value, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1GreaterThan(String value) {
            addCriterion("addressLine1 >", value, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1GreaterThanOrEqualTo(String value) {
            addCriterion("addressLine1 >=", value, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1LessThan(String value) {
            addCriterion("addressLine1 <", value, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1LessThanOrEqualTo(String value) {
            addCriterion("addressLine1 <=", value, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1Like(String value) {
            addCriterion("addressLine1 like", value, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1NotLike(String value) {
            addCriterion("addressLine1 not like", value, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1In(List<String> values) {
            addCriterion("addressLine1 in", values, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1NotIn(List<String> values) {
            addCriterion("addressLine1 not in", values, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1Between(String value1, String value2) {
            addCriterion("addressLine1 between", value1, value2, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline1NotBetween(String value1, String value2) {
            addCriterion("addressLine1 not between", value1, value2, "addressline1");
            return (Criteria) this;
        }

        public Criteria andAddressline2IsNull() {
            addCriterion("addressLine2 is null");
            return (Criteria) this;
        }

        public Criteria andAddressline2IsNotNull() {
            addCriterion("addressLine2 is not null");
            return (Criteria) this;
        }

        public Criteria andAddressline2EqualTo(String value) {
            addCriterion("addressLine2 =", value, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2NotEqualTo(String value) {
            addCriterion("addressLine2 <>", value, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2GreaterThan(String value) {
            addCriterion("addressLine2 >", value, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2GreaterThanOrEqualTo(String value) {
            addCriterion("addressLine2 >=", value, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2LessThan(String value) {
            addCriterion("addressLine2 <", value, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2LessThanOrEqualTo(String value) {
            addCriterion("addressLine2 <=", value, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2Like(String value) {
            addCriterion("addressLine2 like", value, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2NotLike(String value) {
            addCriterion("addressLine2 not like", value, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2In(List<String> values) {
            addCriterion("addressLine2 in", values, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2NotIn(List<String> values) {
            addCriterion("addressLine2 not in", values, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2Between(String value1, String value2) {
            addCriterion("addressLine2 between", value1, value2, "addressline2");
            return (Criteria) this;
        }

        public Criteria andAddressline2NotBetween(String value1, String value2) {
            addCriterion("addressLine2 not between", value1, value2, "addressline2");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andPostalcodeIsNull() {
            addCriterion("postalCode is null");
            return (Criteria) this;
        }

        public Criteria andPostalcodeIsNotNull() {
            addCriterion("postalCode is not null");
            return (Criteria) this;
        }

        public Criteria andPostalcodeEqualTo(String value) {
            addCriterion("postalCode =", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotEqualTo(String value) {
            addCriterion("postalCode <>", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeGreaterThan(String value) {
            addCriterion("postalCode >", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postalCode >=", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeLessThan(String value) {
            addCriterion("postalCode <", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeLessThanOrEqualTo(String value) {
            addCriterion("postalCode <=", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeLike(String value) {
            addCriterion("postalCode like", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotLike(String value) {
            addCriterion("postalCode not like", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeIn(List<String> values) {
            addCriterion("postalCode in", values, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotIn(List<String> values) {
            addCriterion("postalCode not in", values, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeBetween(String value1, String value2) {
            addCriterion("postalCode between", value1, value2, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotBetween(String value1, String value2) {
            addCriterion("postalCode not between", value1, value2, "postalcode");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberIsNull() {
            addCriterion("salesRepEmployeeNumber is null");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberIsNotNull() {
            addCriterion("salesRepEmployeeNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberEqualTo(Integer value) {
            addCriterion("salesRepEmployeeNumber =", value, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberNotEqualTo(Integer value) {
            addCriterion("salesRepEmployeeNumber <>", value, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberGreaterThan(Integer value) {
            addCriterion("salesRepEmployeeNumber >", value, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("salesRepEmployeeNumber >=", value, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberLessThan(Integer value) {
            addCriterion("salesRepEmployeeNumber <", value, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberLessThanOrEqualTo(Integer value) {
            addCriterion("salesRepEmployeeNumber <=", value, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberIn(List<Integer> values) {
            addCriterion("salesRepEmployeeNumber in", values, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberNotIn(List<Integer> values) {
            addCriterion("salesRepEmployeeNumber not in", values, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberBetween(Integer value1, Integer value2) {
            addCriterion("salesRepEmployeeNumber between", value1, value2, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andSalesrepemployeenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("salesRepEmployeeNumber not between", value1, value2, "salesrepemployeenumber");
            return (Criteria) this;
        }

        public Criteria andCreditlimitIsNull() {
            addCriterion("creditLimit is null");
            return (Criteria) this;
        }

        public Criteria andCreditlimitIsNotNull() {
            addCriterion("creditLimit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditlimitEqualTo(BigDecimal value) {
            addCriterion("creditLimit =", value, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitNotEqualTo(BigDecimal value) {
            addCriterion("creditLimit <>", value, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitGreaterThan(BigDecimal value) {
            addCriterion("creditLimit >", value, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("creditLimit >=", value, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitLessThan(BigDecimal value) {
            addCriterion("creditLimit <", value, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("creditLimit <=", value, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitIn(List<BigDecimal> values) {
            addCriterion("creditLimit in", values, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitNotIn(List<BigDecimal> values) {
            addCriterion("creditLimit not in", values, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("creditLimit between", value1, value2, "creditlimit");
            return (Criteria) this;
        }

        public Criteria andCreditlimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("creditLimit not between", value1, value2, "creditlimit");
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