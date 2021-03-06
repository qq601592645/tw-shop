package com.tw.model;

import java.math.BigDecimal;

public class Cart {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.cart_id
     *
     * @mbg.generated
     */
    private Integer cartId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.goods_id
     *
     * @mbg.generated
     */
    private String goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.goods_name
     *
     * @mbg.generated
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.sku_id
     *
     * @mbg.generated
     */
    private String skuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.sku_value_text
     *
     * @mbg.generated
     */
    private String skuValueText;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.goods_img_url
     *
     * @mbg.generated
     */
    private String goodsImgUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.number
     *
     * @mbg.generated
     */
    private Integer number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.label_price
     *
     * @mbg.generated
     */
    private BigDecimal labelPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.market_price
     *
     * @mbg.generated
     */
    private BigDecimal marketPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.checked
     *
     * @mbg.generated
     */
    private Integer checked;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_cart.way
     *
     * @mbg.generated
     */
    private Integer way;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.cart_id
     *
     * @return the value of twshop_cart.cart_id
     *
     * @mbg.generated
     */
    public Integer getCartId() {
        return cartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.cart_id
     *
     * @param cartId the value for twshop_cart.cart_id
     *
     * @mbg.generated
     */
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.user_id
     *
     * @return the value of twshop_cart.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.user_id
     *
     * @param userId the value for twshop_cart.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.goods_id
     *
     * @return the value of twshop_cart.goods_id
     *
     * @mbg.generated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.goods_id
     *
     * @param goodsId the value for twshop_cart.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.goods_name
     *
     * @return the value of twshop_cart.goods_name
     *
     * @mbg.generated
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.goods_name
     *
     * @param goodsName the value for twshop_cart.goods_name
     *
     * @mbg.generated
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.sku_id
     *
     * @return the value of twshop_cart.sku_id
     *
     * @mbg.generated
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.sku_id
     *
     * @param skuId the value for twshop_cart.sku_id
     *
     * @mbg.generated
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.sku_value_text
     *
     * @return the value of twshop_cart.sku_value_text
     *
     * @mbg.generated
     */
    public String getSkuValueText() {
        return skuValueText;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.sku_value_text
     *
     * @param skuValueText the value for twshop_cart.sku_value_text
     *
     * @mbg.generated
     */
    public void setSkuValueText(String skuValueText) {
        this.skuValueText = skuValueText == null ? null : skuValueText.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.goods_img_url
     *
     * @return the value of twshop_cart.goods_img_url
     *
     * @mbg.generated
     */
    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.goods_img_url
     *
     * @param goodsImgUrl the value for twshop_cart.goods_img_url
     *
     * @mbg.generated
     */
    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl == null ? null : goodsImgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.number
     *
     * @return the value of twshop_cart.number
     *
     * @mbg.generated
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.number
     *
     * @param number the value for twshop_cart.number
     *
     * @mbg.generated
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.label_price
     *
     * @return the value of twshop_cart.label_price
     *
     * @mbg.generated
     */
    public BigDecimal getLabelPrice() {
        return labelPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.label_price
     *
     * @param labelPrice the value for twshop_cart.label_price
     *
     * @mbg.generated
     */
    public void setLabelPrice(BigDecimal labelPrice) {
        this.labelPrice = labelPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.market_price
     *
     * @return the value of twshop_cart.market_price
     *
     * @mbg.generated
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.market_price
     *
     * @param marketPrice the value for twshop_cart.market_price
     *
     * @mbg.generated
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.checked
     *
     * @return the value of twshop_cart.checked
     *
     * @mbg.generated
     */
    public Integer getChecked() {
        return checked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.checked
     *
     * @param checked the value for twshop_cart.checked
     *
     * @mbg.generated
     */
    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_cart.way
     *
     * @return the value of twshop_cart.way
     *
     * @mbg.generated
     */
    public Integer getWay() {
        return way;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_cart.way
     *
     * @param way the value for twshop_cart.way
     *
     * @mbg.generated
     */
    public void setWay(Integer way) {
        this.way = way;
    }
}