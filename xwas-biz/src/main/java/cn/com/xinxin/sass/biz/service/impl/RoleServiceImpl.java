package cn.com.xinxin.sass.biz.service.impl;

import cn.com.xinxin.sass.biz.service.RoleService;
import cn.com.xinxin.sass.common.model.PageResultVO;
import cn.com.xinxin.sass.repository.dao.RoleMapper;
import cn.com.xinxin.sass.repository.model.RoleDO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dengyunhui on 2018/5/1
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDO createRole(RoleDO roleDO) {
        roleMapper.insertSelective(roleDO);
        return roleDO;
    }

    @Override
    public int updateRole(RoleDO roleDO) {
        return roleMapper.updateByPrimaryKeySelective(roleDO);
    }

    @Override
    public int deleteRole(Long roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public RoleDO findOne(long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public PageResultVO<RoleDO> findByConditionPage(PageResultVO page, RoleDO condition) {
        com.github.pagehelper.Page page1 = PageHelper.startPage(page.getPageNumber(),page.getPageSize());
        List<RoleDO> roleDOS = roleMapper.findByCondition(condition);

        PageResultVO<RoleDO> result = new PageResultVO<>();
        result.setPageNumber(page.getPageNumber());
        result.setPageSize(page.getPageSize());
        result.setItems(roleDOS);
        result.setTotal(page1.getTotal());
        return result;
    }

    @Override
    public List<RoleDO> findRoles(List<Long> roleIds) {
        return roleMapper.findRoles(roleIds);
    }

    @Override
    public RoleDO findByRoleCode(String code) {
        return roleMapper.findByRoleCode(code);
    }

}
