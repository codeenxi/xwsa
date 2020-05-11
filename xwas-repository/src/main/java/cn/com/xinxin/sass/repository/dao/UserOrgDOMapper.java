package cn.com.xinxin.sass.repository.dao;

import cn.com.xinxin.sass.repository.model.UserOrgDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserOrgDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_org
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_org
     *
     * @mbg.generated
     */
    int insert(UserOrgDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_org
     *
     * @mbg.generated
     */
    int insertSelective(UserOrgDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_org
     *
     * @mbg.generated
     */
    UserOrgDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_org
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserOrgDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_org
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserOrgDO record);

    /**
     * 查询接口
     * @param account
     * @return
     */
    List<UserOrgDO> queryUserOrgsByAccount(@Param("account") String account);


    /**
     * 删除
     * @param account
     * @return
     */
    int removeUserOrgRelationByAccount(@Param("account") String account);

    /**
     * 删除接口
     * @param orgCode
     * @return
     */
    int removeUserOrgRelationByOrgCode(@Param("orgCode")String orgCode);

    /**
     * 批量查询
     * @param lists
     * @return
     */
    int insertByBatch(@Param("lists") List<UserOrgDO> lists);
}