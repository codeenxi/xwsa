package cn.com.xinxin.sass.biz.service;

import cn.com.xinxin.sass.common.model.PageResultVO;
import cn.com.xinxin.sass.repository.model.ResourceDO;
import cn.com.xinxin.sass.repository.model.RoleDO;
import cn.com.xinxin.sass.repository.model.RoleResourceDO;

import java.util.List;

/**
 * Created by dengyunhui on 2018/5/1
 **/
public interface RoleResourceService {

    RoleResourceDO createRoleResource(RoleResourceDO roleResourceDO);

    boolean createRoleResources(List<RoleResourceDO> roleResources);

    boolean createRoleResources(RoleDO role, List<ResourceDO> resources);

    boolean updateRoleResource(RoleResourceDO roleResourceDO);

    boolean deleteRoleResource(long id);

    List<ResourceDO> findResources(String roleCode);

    List<ResourceDO> findResources(List<String> roleCodes);

    PageResultVO<RoleResourceDO> findByConditionPage(PageResultVO page, RoleResourceDO condition);

    RoleResourceDO findById(Long id);

    Boolean delete(String roleCode,List<String> resourceCodes);


    List<RoleResourceDO> queryRolesAndResourcesByRSCode(String rsCode);


    List<RoleResourceDO> queryRolesAndResourcesByRSCodeList(List<String> rsCodes);

    boolean updateByRoleCode(RoleResourceDO roleResourceDO);

    boolean updateByResourceCode(RoleResourceDO roleResourceDO);

    boolean deleteByRoleCodes(List<String> roleCode);
}
