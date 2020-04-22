package cn.com.xinxin.sass.repository.dao;

import cn.com.xinxin.sass.repository.model.ResourceDO;
import cn.com.xinxin.sass.repository.model.RoleResourceDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated
     */
    int insert(RoleResourceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated
     */
    int insertSelective(RoleResourceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated
     */
    RoleResourceDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RoleResourceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RoleResourceDO record);

    /**
     *
     * @param roleCode
     * @return
     */
    List<ResourceDO> findResourceByRoleCode(@Param("roleCode") String roleCode);

    /**
     *
     * @param roleCodes
     * @return
     */
    List<ResourceDO> findResources(List<String> roleCodes);

    /**
     *
     * @param list
     * @return
     */
    int batchInsert(List<RoleResourceDO> list);

    /**
     *
     * @param condition
     * @return
     */
    List<RoleResourceDO> findByCondition(RoleResourceDO condition);

    /**
     *
     * @param roleCode
     * @param resourceCodes
     * @return
     */
    int delete(@Param("roleCode") String roleCode,@Param("list")List<String> resourceCodes);

    /**
     *
     * @param rsCode
     * @return
     */
    List<RoleResourceDO> queryRolesAndResourcesByRSCode(@Param("rsCode") String rsCode);


    /**
     *
     * @param rsCodeList
     * @return
     */
    List<RoleResourceDO> queryRolesAndResourcesByRSCodeList(@Param("rsCodeList") List<String> rsCodeList);


}