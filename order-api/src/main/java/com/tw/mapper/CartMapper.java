package com.tw.mapper;

import com.tw.model.Cart;
import com.tw.model.CartCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface CartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @SelectProvider(type=CartSqlProvider.class, method="countByExample")
    long countByExample(CartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @DeleteProvider(type=CartSqlProvider.class, method="deleteByExample")
    int deleteByExample(CartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @Delete({
        "delete from twshop_cart",
        "where cart_id = #{cartId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer cartId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @Insert({
        "insert into twshop_cart (cart_id, user_id, ",
        "goods_id, goods_name, ",
        "sku_id, sku_value_text, ",
        "goods_img_url, number, ",
        "label_price, market_price, ",
        "checked, way)",
        "values (#{cartId,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, ",
        "#{goodsId,jdbcType=VARCHAR}, #{goodsName,jdbcType=VARCHAR}, ",
        "#{skuId,jdbcType=VARCHAR}, #{skuValueText,jdbcType=VARCHAR}, ",
        "#{goodsImgUrl,jdbcType=VARCHAR}, #{number,jdbcType=INTEGER}, ",
        "#{labelPrice,jdbcType=DECIMAL}, #{marketPrice,jdbcType=DECIMAL}, ",
        "#{checked,jdbcType=INTEGER}, #{way,jdbcType=INTEGER})"
    })
    int insert(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @InsertProvider(type=CartSqlProvider.class, method="insertSelective")
    int insertSelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @SelectProvider(type=CartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="cart_id", property="cartId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_name", property="goodsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_value_text", property="skuValueText", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_img_url", property="goodsImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="label_price", property="labelPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="market_price", property="marketPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="checked", property="checked", jdbcType=JdbcType.INTEGER),
        @Result(column="way", property="way", jdbcType=JdbcType.INTEGER)
    })
    List<Cart> selectByExampleWithRowbounds(CartCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @SelectProvider(type=CartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="cart_id", property="cartId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_name", property="goodsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_value_text", property="skuValueText", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_img_url", property="goodsImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="label_price", property="labelPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="market_price", property="marketPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="checked", property="checked", jdbcType=JdbcType.INTEGER),
        @Result(column="way", property="way", jdbcType=JdbcType.INTEGER)
    })
    List<Cart> selectByExample(CartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "cart_id, user_id, goods_id, goods_name, sku_id, sku_value_text, goods_img_url, ",
        "number, label_price, market_price, checked, way",
        "from twshop_cart",
        "where cart_id = #{cartId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="cart_id", property="cartId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_name", property="goodsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_id", property="skuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sku_value_text", property="skuValueText", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_img_url", property="goodsImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="label_price", property="labelPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="market_price", property="marketPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="checked", property="checked", jdbcType=JdbcType.INTEGER),
        @Result(column="way", property="way", jdbcType=JdbcType.INTEGER)
    })
    Cart selectByPrimaryKey(Integer cartId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @UpdateProvider(type=CartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @UpdateProvider(type=CartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Cart record, @Param("example") CartCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @UpdateProvider(type=CartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_cart
     *
     * @mbg.generated
     */
    @Update({
        "update twshop_cart",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "goods_id = #{goodsId,jdbcType=VARCHAR},",
          "goods_name = #{goodsName,jdbcType=VARCHAR},",
          "sku_id = #{skuId,jdbcType=VARCHAR},",
          "sku_value_text = #{skuValueText,jdbcType=VARCHAR},",
          "goods_img_url = #{goodsImgUrl,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=INTEGER},",
          "label_price = #{labelPrice,jdbcType=DECIMAL},",
          "market_price = #{marketPrice,jdbcType=DECIMAL},",
          "checked = #{checked,jdbcType=INTEGER},",
          "way = #{way,jdbcType=INTEGER}",
        "where cart_id = #{cartId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Cart record);
}