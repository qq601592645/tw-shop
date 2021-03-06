package com.tw.mapper;

import com.tw.model.GoodsSku;
import com.tw.model.GoodsSkuCriteria.Criteria;
import com.tw.model.GoodsSkuCriteria.Criterion;
import com.tw.model.GoodsSkuCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class GoodsSkuSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_goods_sku
     *
     * @mbg.generated
     */
    public String countByExample(GoodsSkuCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("twshop_goods_sku");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_goods_sku
     *
     * @mbg.generated
     */
    public String deleteByExample(GoodsSkuCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("twshop_goods_sku");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_goods_sku
     *
     * @mbg.generated
     */
    public String insertSelective(GoodsSku record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("twshop_goods_sku");
        
        if (record.getSkuId() != null) {
            sql.VALUES("sku_id", "#{skuId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsId() != null) {
            sql.VALUES("goods_id", "#{goodsId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuStatus() != null) {
            sql.VALUES("sku_status", "#{skuStatus,jdbcType=BIT}");
        }
        
        if (record.getStorageNum() != null) {
            sql.VALUES("storage_num", "#{storageNum,jdbcType=INTEGER}");
        }
        
        if (record.getLabelPrice() != null) {
            sql.VALUES("label_price", "#{labelPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getMarketPrice() != null) {
            sql.VALUES("market_price", "#{marketPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getCostPrice() != null) {
            sql.VALUES("cost_price", "#{costPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAwardScore() != null) {
            sql.VALUES("award_score", "#{awardScore,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBarCode() != null) {
            sql.VALUES("bar_code", "#{barCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.VALUES("weight", "#{weight,jdbcType=DECIMAL}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuImgUrl() != null) {
            sql.VALUES("sku_img_url", "#{skuImgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuName() != null) {
            sql.VALUES("sku_name", "#{skuName,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuValues() != null) {
            sql.VALUES("sku_values", "#{skuValues,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_goods_sku
     *
     * @mbg.generated
     */
    public String selectByExample(GoodsSkuCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("sku_id");
        } else {
            sql.SELECT("sku_id");
        }
        sql.SELECT("goods_id");
        sql.SELECT("sku_status");
        sql.SELECT("storage_num");
        sql.SELECT("label_price");
        sql.SELECT("market_price");
        sql.SELECT("cost_price");
        sql.SELECT("award_score");
        sql.SELECT("create_time");
        sql.SELECT("bar_code");
        sql.SELECT("weight");
        sql.SELECT("remark");
        sql.SELECT("sku_img_url");
        sql.SELECT("sku_name");
        sql.SELECT("sku_values");
        sql.FROM("twshop_goods_sku");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_goods_sku
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        GoodsSku record = (GoodsSku) parameter.get("record");
        GoodsSkuCriteria example = (GoodsSkuCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("twshop_goods_sku");
        
        if (record.getSkuId() != null) {
            sql.SET("sku_id = #{record.skuId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsId() != null) {
            sql.SET("goods_id = #{record.goodsId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuStatus() != null) {
            sql.SET("sku_status = #{record.skuStatus,jdbcType=BIT}");
        }
        
        if (record.getStorageNum() != null) {
            sql.SET("storage_num = #{record.storageNum,jdbcType=INTEGER}");
        }
        
        if (record.getLabelPrice() != null) {
            sql.SET("label_price = #{record.labelPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getMarketPrice() != null) {
            sql.SET("market_price = #{record.marketPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getCostPrice() != null) {
            sql.SET("cost_price = #{record.costPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAwardScore() != null) {
            sql.SET("award_score = #{record.awardScore,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBarCode() != null) {
            sql.SET("bar_code = #{record.barCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.SET("weight = #{record.weight,jdbcType=DECIMAL}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuImgUrl() != null) {
            sql.SET("sku_img_url = #{record.skuImgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuName() != null) {
            sql.SET("sku_name = #{record.skuName,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuValues() != null) {
            sql.SET("sku_values = #{record.skuValues,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_goods_sku
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("twshop_goods_sku");
        
        sql.SET("sku_id = #{record.skuId,jdbcType=VARCHAR}");
        sql.SET("goods_id = #{record.goodsId,jdbcType=VARCHAR}");
        sql.SET("sku_status = #{record.skuStatus,jdbcType=BIT}");
        sql.SET("storage_num = #{record.storageNum,jdbcType=INTEGER}");
        sql.SET("label_price = #{record.labelPrice,jdbcType=DECIMAL}");
        sql.SET("market_price = #{record.marketPrice,jdbcType=DECIMAL}");
        sql.SET("cost_price = #{record.costPrice,jdbcType=DECIMAL}");
        sql.SET("award_score = #{record.awardScore,jdbcType=DECIMAL}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("bar_code = #{record.barCode,jdbcType=VARCHAR}");
        sql.SET("weight = #{record.weight,jdbcType=DECIMAL}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("sku_img_url = #{record.skuImgUrl,jdbcType=VARCHAR}");
        sql.SET("sku_name = #{record.skuName,jdbcType=VARCHAR}");
        sql.SET("sku_values = #{record.skuValues,jdbcType=VARCHAR}");
        
        GoodsSkuCriteria example = (GoodsSkuCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_goods_sku
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(GoodsSku record) {
        SQL sql = new SQL();
        sql.UPDATE("twshop_goods_sku");
        
        if (record.getGoodsId() != null) {
            sql.SET("goods_id = #{goodsId,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuStatus() != null) {
            sql.SET("sku_status = #{skuStatus,jdbcType=BIT}");
        }
        
        if (record.getStorageNum() != null) {
            sql.SET("storage_num = #{storageNum,jdbcType=INTEGER}");
        }
        
        if (record.getLabelPrice() != null) {
            sql.SET("label_price = #{labelPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getMarketPrice() != null) {
            sql.SET("market_price = #{marketPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getCostPrice() != null) {
            sql.SET("cost_price = #{costPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAwardScore() != null) {
            sql.SET("award_score = #{awardScore,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBarCode() != null) {
            sql.SET("bar_code = #{barCode,jdbcType=VARCHAR}");
        }
        
        if (record.getWeight() != null) {
            sql.SET("weight = #{weight,jdbcType=DECIMAL}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuImgUrl() != null) {
            sql.SET("sku_img_url = #{skuImgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuName() != null) {
            sql.SET("sku_name = #{skuName,jdbcType=VARCHAR}");
        }
        
        if (record.getSkuValues() != null) {
            sql.SET("sku_values = #{skuValues,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("sku_id = #{skuId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_goods_sku
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, GoodsSkuCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}