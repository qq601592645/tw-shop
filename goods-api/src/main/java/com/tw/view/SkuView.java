package com.tw.view;

import com.tw.model.GoodsSkuValue;

import java.util.List;

/**
 * Created by aisiA on 2019/4/18.
 */
public class SkuView {
    private String keyId;
    private String keyName;
    private List<GoodsSkuValue> list;

    public String getKeyId() {
        return keyId;
    }
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public List<GoodsSkuValue> getList() {
        return list;
    }

    public void setList(List<GoodsSkuValue> list) {
        this.list = list;
    }
}
