package com.tw.model;

public class AttributeCategory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_attribute_category.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_attribute_category.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column twshop_attribute_category.enabled
     *
     * @mbg.generated
     */
    private Boolean enabled;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_attribute_category.id
     *
     * @return the value of twshop_attribute_category.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_attribute_category.id
     *
     * @param id the value for twshop_attribute_category.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_attribute_category.name
     *
     * @return the value of twshop_attribute_category.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_attribute_category.name
     *
     * @param name the value for twshop_attribute_category.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column twshop_attribute_category.enabled
     *
     * @return the value of twshop_attribute_category.enabled
     *
     * @mbg.generated
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column twshop_attribute_category.enabled
     *
     * @param enabled the value for twshop_attribute_category.enabled
     *
     * @mbg.generated
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}