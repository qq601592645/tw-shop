package com.tw.view;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by aisiA on 2019/5/24.
 */
public class CouponView {
    private Integer userCouponId;
    private String name;
    private Integer id;
    private String useEndDate;
    private BigDecimal minGoodsAmount;
    private Byte couponStatus;
    private BigDecimal couponPrice;
    private BigDecimal typeMoney;

    public BigDecimal getTypeMoney() {
        return typeMoney;
    }

    public void setTypeMoney(BigDecimal typeMoney) {
        this.typeMoney = typeMoney;
    }

    public Integer getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(Integer userCouponId) {
        this.userCouponId = userCouponId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseEndDate() {
        return useEndDate;
    }

    public void setUseEndDate(String useEndDate) {
        this.useEndDate = useEndDate;
    }

    public BigDecimal getMinGoodsAmount() {
        return minGoodsAmount;
    }

    public void setMinGoodsAmount(BigDecimal minGoodsAmount) {
        this.minGoodsAmount = minGoodsAmount;
    }

    public Byte getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Byte couponStatus) {
        this.couponStatus = couponStatus;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }
}
