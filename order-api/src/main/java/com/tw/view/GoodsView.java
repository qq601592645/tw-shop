package com.tw.view;

import java.math.BigDecimal;

/**
 * Created by aisiA on 2019/5/23.
 */
public class GoodsView {
    private String goodsId;
    private String goodsCode;
    private String goodsName;
    private String skuId;
    private String skuValueText;
    private String goodsImgUrl;
    private BigDecimal labelPrice;
    private BigDecimal marketPrice;
    private Integer storageNum;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuValueText() {
        return skuValueText;
    }

    public void setSkuValueText(String skuValueText) {
        this.skuValueText = skuValueText;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public BigDecimal getLabelPrice() {
        return labelPrice;
    }

    public void setLabelPrice(BigDecimal labelPrice) {
        this.labelPrice = labelPrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(Integer storageNum) {
        this.storageNum = storageNum;
    }
}
