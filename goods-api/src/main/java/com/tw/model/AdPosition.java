package com.tw.model;

public class AdPosition {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_ad_position.id
     *
     * @mbg.generated
     */
    private Byte id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_ad_position.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_ad_position.width
     *
     * @mbg.generated
     */
    private Short width;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_ad_position.height
     *
     * @mbg.generated
     */
    private Short height;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_ad_position.desc
     *
     * @mbg.generated
     */
    private String desc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_ad_position.id
     *
     * @return the value of twshop_ad_position.id
     *
     * @mbg.generated
     */
    public Byte getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_ad_position.id
     *
     * @param id the value for twshop_ad_position.id
     *
     * @mbg.generated
     */
    public void setId(Byte id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_ad_position.name
     *
     * @return the value of twshop_ad_position.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_ad_position.name
     *
     * @param name the value for twshop_ad_position.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_ad_position.width
     *
     * @return the value of twshop_ad_position.width
     *
     * @mbg.generated
     */
    public Short getWidth() {
        return width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_ad_position.width
     *
     * @param width the value for twshop_ad_position.width
     *
     * @mbg.generated
     */
    public void setWidth(Short width) {
        this.width = width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_ad_position.height
     *
     * @return the value of twshop_ad_position.height
     *
     * @mbg.generated
     */
    public Short getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_ad_position.height
     *
     * @param height the value for twshop_ad_position.height
     *
     * @mbg.generated
     */
    public void setHeight(Short height) {
        this.height = height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_ad_position.desc
     *
     * @return the value of twshop_ad_position.desc
     *
     * @mbg.generated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_ad_position.desc
     *
     * @param desc the value for twshop_ad_position.desc
     *
     * @mbg.generated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}