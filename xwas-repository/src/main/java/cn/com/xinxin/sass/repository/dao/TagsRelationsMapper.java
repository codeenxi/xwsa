package cn.com.xinxin.sass.repository.dao;

import cn.com.xinxin.sass.repository.model.TagsRelationsDO;

public interface TagsRelationsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags_relations
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags_relations
     *
     * @mbg.generated
     */
    int insert(TagsRelationsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags_relations
     *
     * @mbg.generated
     */
    int insertSelective(TagsRelationsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags_relations
     *
     * @mbg.generated
     */
    TagsRelationsDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags_relations
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TagsRelationsDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tags_relations
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TagsRelationsDO record);
}