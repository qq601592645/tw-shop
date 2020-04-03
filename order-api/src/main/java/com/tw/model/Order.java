package com.tw.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.order_sn
     *
     * @mbg.generated
     */
    private String orderSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.order_status
     *
     * @mbg.generated
     */
    private Integer orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.shipping_status
     *
     * @mbg.generated
     */
    private Integer shippingStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.pay_status
     *
     * @mbg.generated
     */
    private Integer payStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.consignee
     *
     * @mbg.generated
     */
    private String consignee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.country
     *
     * @mbg.generated
     */
    private String country;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.province
     *
     * @mbg.generated
     */
    private String province;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.city
     *
     * @mbg.generated
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.district
     *
     * @mbg.generated
     */
    private String district;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.mobile
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.postscript
     *
     * @mbg.generated
     */
    private String postscript;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.shipping_id
     *
     * @mbg.generated
     */
    private Byte shippingId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.shipping_name
     *
     * @mbg.generated
     */
    private String shippingName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.pay_id
     *
     * @mbg.generated
     */
    private String payId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.pay_name
     *
     * @mbg.generated
     */
    private String payName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.shipping_fee
     *
     * @mbg.generated
     */
    private BigDecimal shippingFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.actual_price
     *
     * @mbg.generated
     */
    private BigDecimal actualPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.integral
     *
     * @mbg.generated
     */
    private Integer integral;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.integral_money
     *
     * @mbg.generated
     */
    private BigDecimal integralMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.order_price
     *
     * @mbg.generated
     */
    private BigDecimal orderPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.goods_price
     *
     * @mbg.generated
     */
    private BigDecimal goodsPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.add_time
     *
     * @mbg.generated
     */
    private Date addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.confirm_time
     *
     * @mbg.generated
     */
    private Date confirmTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.pay_time
     *
     * @mbg.generated
     */
    private Date payTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.freight_price
     *
     * @mbg.generated
     */
    private Integer freightPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.coupon_id
     *
     * @mbg.generated
     */
    private Integer couponId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.parent_id
     *
     * @mbg.generated
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.coupon_price
     *
     * @mbg.generated
     */
    private BigDecimal couponPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.callback_status
     *
     * @mbg.generated
     */
    private String callbackStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.shipping_no
     *
     * @mbg.generated
     */
    private String shippingNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.full_cut_price
     *
     * @mbg.generated
     */
    private BigDecimal fullCutPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.order_type
     *
     * @mbg.generated
     */
    private String orderType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.brand_id
     *
     * @mbg.generated
     */
    private Integer brandId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.settlement_total_fee
     *
     * @mbg.generated
     */
    private Integer settlementTotalFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.all_price
     *
     * @mbg.generated
     */
    private BigDecimal allPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.all_order_id
     *
     * @mbg.generated
     */
    private String allOrderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.promoter_id
     *
     * @mbg.generated
     */
    private Integer promoterId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_order.brokerage
     *
     * @mbg.generated
     */
    private BigDecimal brokerage;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.id
     *
     * @return the value of twshop_order.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.id
     *
     * @param id the value for twshop_order.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.order_sn
     *
     * @return the value of twshop_order.order_sn
     *
     * @mbg.generated
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.order_sn
     *
     * @param orderSn the value for twshop_order.order_sn
     *
     * @mbg.generated
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.user_id
     *
     * @return the value of twshop_order.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.user_id
     *
     * @param userId the value for twshop_order.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.order_status
     *
     * @return the value of twshop_order.order_status
     *
     * @mbg.generated
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.order_status
     *
     * @param orderStatus the value for twshop_order.order_status
     *
     * @mbg.generated
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.shipping_status
     *
     * @return the value of twshop_order.shipping_status
     *
     * @mbg.generated
     */
    public Integer getShippingStatus() {
        return shippingStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.shipping_status
     *
     * @param shippingStatus the value for twshop_order.shipping_status
     *
     * @mbg.generated
     */
    public void setShippingStatus(Integer shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.pay_status
     *
     * @return the value of twshop_order.pay_status
     *
     * @mbg.generated
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.pay_status
     *
     * @param payStatus the value for twshop_order.pay_status
     *
     * @mbg.generated
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.consignee
     *
     * @return the value of twshop_order.consignee
     *
     * @mbg.generated
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.consignee
     *
     * @param consignee the value for twshop_order.consignee
     *
     * @mbg.generated
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.country
     *
     * @return the value of twshop_order.country
     *
     * @mbg.generated
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.country
     *
     * @param country the value for twshop_order.country
     *
     * @mbg.generated
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.province
     *
     * @return the value of twshop_order.province
     *
     * @mbg.generated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.province
     *
     * @param province the value for twshop_order.province
     *
     * @mbg.generated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.city
     *
     * @return the value of twshop_order.city
     *
     * @mbg.generated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.city
     *
     * @param city the value for twshop_order.city
     *
     * @mbg.generated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.district
     *
     * @return the value of twshop_order.district
     *
     * @mbg.generated
     */
    public String getDistrict() {
        return district;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.district
     *
     * @param district the value for twshop_order.district
     *
     * @mbg.generated
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.address
     *
     * @return the value of twshop_order.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.address
     *
     * @param address the value for twshop_order.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.mobile
     *
     * @return the value of twshop_order.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.mobile
     *
     * @param mobile the value for twshop_order.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.postscript
     *
     * @return the value of twshop_order.postscript
     *
     * @mbg.generated
     */
    public String getPostscript() {
        return postscript;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.postscript
     *
     * @param postscript the value for twshop_order.postscript
     *
     * @mbg.generated
     */
    public void setPostscript(String postscript) {
        this.postscript = postscript == null ? null : postscript.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.shipping_id
     *
     * @return the value of twshop_order.shipping_id
     *
     * @mbg.generated
     */
    public Byte getShippingId() {
        return shippingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.shipping_id
     *
     * @param shippingId the value for twshop_order.shipping_id
     *
     * @mbg.generated
     */
    public void setShippingId(Byte shippingId) {
        this.shippingId = shippingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.shipping_name
     *
     * @return the value of twshop_order.shipping_name
     *
     * @mbg.generated
     */
    public String getShippingName() {
        return shippingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.shipping_name
     *
     * @param shippingName the value for twshop_order.shipping_name
     *
     * @mbg.generated
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.pay_id
     *
     * @return the value of twshop_order.pay_id
     *
     * @mbg.generated
     */
    public String getPayId() {
        return payId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.pay_id
     *
     * @param payId the value for twshop_order.pay_id
     *
     * @mbg.generated
     */
    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.pay_name
     *
     * @return the value of twshop_order.pay_name
     *
     * @mbg.generated
     */
    public String getPayName() {
        return payName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.pay_name
     *
     * @param payName the value for twshop_order.pay_name
     *
     * @mbg.generated
     */
    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.shipping_fee
     *
     * @return the value of twshop_order.shipping_fee
     *
     * @mbg.generated
     */
    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.shipping_fee
     *
     * @param shippingFee the value for twshop_order.shipping_fee
     *
     * @mbg.generated
     */
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.actual_price
     *
     * @return the value of twshop_order.actual_price
     *
     * @mbg.generated
     */
    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.actual_price
     *
     * @param actualPrice the value for twshop_order.actual_price
     *
     * @mbg.generated
     */
    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.integral
     *
     * @return the value of twshop_order.integral
     *
     * @mbg.generated
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.integral
     *
     * @param integral the value for twshop_order.integral
     *
     * @mbg.generated
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.integral_money
     *
     * @return the value of twshop_order.integral_money
     *
     * @mbg.generated
     */
    public BigDecimal getIntegralMoney() {
        return integralMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.integral_money
     *
     * @param integralMoney the value for twshop_order.integral_money
     *
     * @mbg.generated
     */
    public void setIntegralMoney(BigDecimal integralMoney) {
        this.integralMoney = integralMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.order_price
     *
     * @return the value of twshop_order.order_price
     *
     * @mbg.generated
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.order_price
     *
     * @param orderPrice the value for twshop_order.order_price
     *
     * @mbg.generated
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.goods_price
     *
     * @return the value of twshop_order.goods_price
     *
     * @mbg.generated
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.goods_price
     *
     * @param goodsPrice the value for twshop_order.goods_price
     *
     * @mbg.generated
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.add_time
     *
     * @return the value of twshop_order.add_time
     *
     * @mbg.generated
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.add_time
     *
     * @param addTime the value for twshop_order.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.confirm_time
     *
     * @return the value of twshop_order.confirm_time
     *
     * @mbg.generated
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.confirm_time
     *
     * @param confirmTime the value for twshop_order.confirm_time
     *
     * @mbg.generated
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.pay_time
     *
     * @return the value of twshop_order.pay_time
     *
     * @mbg.generated
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.pay_time
     *
     * @param payTime the value for twshop_order.pay_time
     *
     * @mbg.generated
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.freight_price
     *
     * @return the value of twshop_order.freight_price
     *
     * @mbg.generated
     */
    public Integer getFreightPrice() {
        return freightPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.freight_price
     *
     * @param freightPrice the value for twshop_order.freight_price
     *
     * @mbg.generated
     */
    public void setFreightPrice(Integer freightPrice) {
        this.freightPrice = freightPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.coupon_id
     *
     * @return the value of twshop_order.coupon_id
     *
     * @mbg.generated
     */
    public Integer getCouponId() {
        return couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.coupon_id
     *
     * @param couponId the value for twshop_order.coupon_id
     *
     * @mbg.generated
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.parent_id
     *
     * @return the value of twshop_order.parent_id
     *
     * @mbg.generated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.parent_id
     *
     * @param parentId the value for twshop_order.parent_id
     *
     * @mbg.generated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.coupon_price
     *
     * @return the value of twshop_order.coupon_price
     *
     * @mbg.generated
     */
    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.coupon_price
     *
     * @param couponPrice the value for twshop_order.coupon_price
     *
     * @mbg.generated
     */
    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.callback_status
     *
     * @return the value of twshop_order.callback_status
     *
     * @mbg.generated
     */
    public String getCallbackStatus() {
        return callbackStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.callback_status
     *
     * @param callbackStatus the value for twshop_order.callback_status
     *
     * @mbg.generated
     */
    public void setCallbackStatus(String callbackStatus) {
        this.callbackStatus = callbackStatus == null ? null : callbackStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.shipping_no
     *
     * @return the value of twshop_order.shipping_no
     *
     * @mbg.generated
     */
    public String getShippingNo() {
        return shippingNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.shipping_no
     *
     * @param shippingNo the value for twshop_order.shipping_no
     *
     * @mbg.generated
     */
    public void setShippingNo(String shippingNo) {
        this.shippingNo = shippingNo == null ? null : shippingNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.full_cut_price
     *
     * @return the value of twshop_order.full_cut_price
     *
     * @mbg.generated
     */
    public BigDecimal getFullCutPrice() {
        return fullCutPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.full_cut_price
     *
     * @param fullCutPrice the value for twshop_order.full_cut_price
     *
     * @mbg.generated
     */
    public void setFullCutPrice(BigDecimal fullCutPrice) {
        this.fullCutPrice = fullCutPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.order_type
     *
     * @return the value of twshop_order.order_type
     *
     * @mbg.generated
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.order_type
     *
     * @param orderType the value for twshop_order.order_type
     *
     * @mbg.generated
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.brand_id
     *
     * @return the value of twshop_order.brand_id
     *
     * @mbg.generated
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.brand_id
     *
     * @param brandId the value for twshop_order.brand_id
     *
     * @mbg.generated
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.settlement_total_fee
     *
     * @return the value of twshop_order.settlement_total_fee
     *
     * @mbg.generated
     */
    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.settlement_total_fee
     *
     * @param settlementTotalFee the value for twshop_order.settlement_total_fee
     *
     * @mbg.generated
     */
    public void setSettlementTotalFee(Integer settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.all_price
     *
     * @return the value of twshop_order.all_price
     *
     * @mbg.generated
     */
    public BigDecimal getAllPrice() {
        return allPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.all_price
     *
     * @param allPrice the value for twshop_order.all_price
     *
     * @mbg.generated
     */
    public void setAllPrice(BigDecimal allPrice) {
        this.allPrice = allPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.all_order_id
     *
     * @return the value of twshop_order.all_order_id
     *
     * @mbg.generated
     */
    public String getAllOrderId() {
        return allOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.all_order_id
     *
     * @param allOrderId the value for twshop_order.all_order_id
     *
     * @mbg.generated
     */
    public void setAllOrderId(String allOrderId) {
        this.allOrderId = allOrderId == null ? null : allOrderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.promoter_id
     *
     * @return the value of twshop_order.promoter_id
     *
     * @mbg.generated
     */
    public Integer getPromoterId() {
        return promoterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.promoter_id
     *
     * @param promoterId the value for twshop_order.promoter_id
     *
     * @mbg.generated
     */
    public void setPromoterId(Integer promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_order.brokerage
     *
     * @return the value of twshop_order.brokerage
     *
     * @mbg.generated
     */
    public BigDecimal getBrokerage() {
        return brokerage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_order.brokerage
     *
     * @param brokerage the value for twshop_order.brokerage
     *
     * @mbg.generated
     */
    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }
}