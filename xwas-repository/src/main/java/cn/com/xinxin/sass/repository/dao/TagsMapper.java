package cn.com.xinxin.sass.repository.dao;

import cn.com.xinxin.sass.repository.model.TagsDO;

public interface TagsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags
     *
     * @mbg.generated
     */
    int insert(TagsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags
     *
     * @mbg.generated
     */
    int insertSelective(TagsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags
     *
     * @mbg.generated
     */
    TagsDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TagsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TagsDO record);
}