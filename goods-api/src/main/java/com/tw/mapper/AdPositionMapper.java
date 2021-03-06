package com.tw.mapper;

import com.tw.model.AdPosition;
import com.tw.model.AdPositionCriteria;
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

public interface AdPositionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @SelectProvider(type=AdPositionSqlProvider.class, method="countByExample")
    long countByExample(AdPositionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @DeleteProvider(type=AdPositionSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdPositionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @Delete({
        "delete from twshop_ad_position",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @Insert({
        "insert into twshop_ad_position (id, name, ",
        "width, height, ",
        "desc)",
        "values (#{id,jdbcType=TINYINT}, #{name,jdbcType=VARCHAR}, ",
        "#{width,jdbcType=SMALLINT}, #{height,jdbcType=SMALLINT}, ",
        "#{desc,jdbcType=VARCHAR})"
    })
    int insert(AdPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @InsertProvider(type=AdPositionSqlProvider.class, method="insertSelective")
    int insertSelective(AdPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @SelectProvider(type=AdPositionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.SMALLINT),
        @Result(column="height", property="height", jdbcType=JdbcType.SMALLINT),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR)
    })
    List<AdPosition> selectByExampleWithRowbounds(AdPositionCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @SelectProvider(type=AdPositionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.SMALLINT),
        @Result(column="height", property="height", jdbcType=JdbcType.SMALLINT),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR)
    })
    List<AdPosition> selectByExample(AdPositionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, name, width, height, desc",
        "from twshop_ad_position",
        "where id = #{id,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.SMALLINT),
        @Result(column="height", property="height", jdbcType=JdbcType.SMALLINT),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR)
    })
    AdPosition selectByPrimaryKey(Byte id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @UpdateProvider(type=AdPositionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdPosition record, @Param("example") AdPositionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @UpdateProvider(type=AdPositionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdPosition record, @Param("example") AdPositionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @UpdateProvider(type=AdPositionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table twshop_ad_position
     *
     * @mbg.generated
     */
    @Update({
        "update twshop_ad_position",
        "set name = #{name,jdbcType=VARCHAR},",
          "width = #{width,jdbcType=SMALLINT},",
          "height = #{height,jdbcType=SMALLINT},",
          "desc = #{desc,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(AdPosition record);
}