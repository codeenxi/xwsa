package cn.com.xinxin.portal.biz.service;

import cn.com.xinxin.portal.common.Page;
import cn.com.xinxin.portal.repository.model.OrganizationDO;

/**
 * Created by dengyunhui on 2018/5/1
 **/
public interface OrganizationService {

    OrganizationDO createOrganization(OrganizationDO organizationDO);

    OrganizationDO updateOrganization(OrganizationDO organizationDO);

    OrganizationDO findById(Long id);

    Page<OrganizationDO> findByCondition(Page page,OrganizationDO condition);

    Boolean deleteById(Long id);

}
