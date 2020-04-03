package com.tw.model;

import java.util.Date;

public class GoodsSkuKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_goods_sku_key.key_id
     *
     * @mbg.generated
     */
    private String keyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_goods_sku_key.key_name
     *
     * @mbg.generated
     */
    private String keyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_goods_sku_key.status
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_goods_sku_key.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_goods_sku_key.goods_id
     *
     * @mbg.generated
     */
    private String goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_goods_sku_key.sort
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_goods_sku_key.key_id
     *
     * @return the value of twshop_goods_sku_key.key_id
     *
     * @mbg.generated
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_goods_sku_key.key_id
     *
     * @param keyId the value for twshop_goods_sku_key.key_id
     *
     * @mbg.generated
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId == null ? null : keyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_goods_sku_key.key_name
     *
     * @return the value of twshop_goods_sku_key.key_name
     *
     * @mbg.generated
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_goods_sku_key.key_name
     *
     * @param keyName the value for twshop_goods_sku_key.key_name
     *
     * @mbg.generated
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_goods_sku_key.status
     *
     * @return the value of twshop_goods_sku_key.status
     *
     * @mbg.generated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_goods_sku_key.status
     *
     * @param status the value for twshop_goods_sku_key.status
     *
     * @mbg.generated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_goods_sku_key.create_time
     *
     * @return the value of twshop_goods_sku_key.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_goods_sku_key.create_time
     *
     * @param createTime the value for twshop_goods_sku_key.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_goods_sku_key.goods_id
     *
     * @return the value of twshop_goods_sku_key.goods_id
     *
     * @mbg.generated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_goods_sku_key.goods_id
     *
     * @param goodsId the value for twshop_goods_sku_key.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_goods_sku_key.sort
     *
     * @return the value of twshop_goods_sku_key.sort
     *
     * @mbg.generated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_goods_sku_key.sort
     *
     * @param sort the value for twshop_goods_sku_key.sort
     *
     * @mbg.generated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}