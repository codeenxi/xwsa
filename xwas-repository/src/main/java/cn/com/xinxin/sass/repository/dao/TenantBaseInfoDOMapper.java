package cn.com.xinxin.sass.repository.dao;

import cn.com.xinxin.sass.repository.model.TenantBaseInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenantBaseInfoDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_base_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_base_info
     *
     * @mbg.generated
     */
    int insert(TenantBaseInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_base_info
     *
     * @mbg.generated
     */
    int insertSelective(TenantBaseInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_base_info
     *
     * @mbg.generated
     */
    TenantBaseInfoDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_base_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TenantBaseInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_base_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TenantBaseInfoDO record);

    /**
     * 通过机构id查询
     * @param tenantId 机构id
     * @return 机构基础信息
     */
    TenantBaseInfoDO selectByOrgId(@Param(value = "tenantId") String tenantId);

    int updateByOrgIdSelective(TenantBaseInfoDO tenantBaseInfoDO);

    int deleteByCodes(@Param("codes") List<String> codes);

    List<TenantBaseInfoDO> listAlltenants();


}