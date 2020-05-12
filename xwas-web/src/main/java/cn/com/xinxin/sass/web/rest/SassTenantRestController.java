package cn.com.xinxin.sass.web.rest;

import cn.com.xinxin.sass.auth.model.SassUserInfo;
import cn.com.xinxin.sass.auth.web.AclController;
import cn.com.xinxin.sass.biz.log.SysLog;
import cn.com.xinxin.sass.biz.service.OrganizationService;
import cn.com.xinxin.sass.biz.service.TenantBaseInfoService;
import cn.com.xinxin.sass.biz.service.TenantDataSyncConfigService;
import cn.com.xinxin.sass.common.enums.SassBizResultCodeEnum;
import cn.com.xinxin.sass.common.enums.TaskTypeEnum;
import cn.com.xinxin.sass.common.model.PageResultVO;
import cn.com.xinxin.sass.repository.model.TenantBaseInfoDO;
import cn.com.xinxin.sass.repository.model.TenantDataSyncConfigDO;
import cn.com.xinxin.sass.web.form.DeleteOrgForm;
import cn.com.xinxin.sass.web.form.TenantForm;
import cn.com.xinxin.sass.web.vo.*;
import com.alibaba.fastjson.JSONObject;
import com.xinxinfinance.commons.exception.BusinessException;
import com.xinxinfinance.commons.idgen.SnowFakeIdGenerator;
import com.xinxinfinance.commons.util.BaseConvert;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author: zhouyang
 * @created: 17/04/2020.
 * @updater:
 * @description: 租户管理接口
 */
@RestController
@RequestMapping(value = "/tenant",produces = "application/json; charset=UTF-8")
public class SassTenantRestController extends AclController {

    private static final Logger loger = LoggerFactory.getLogger(SassTenantRestController.class);

    private final TenantBaseInfoService tenantBaseInfoService;

    private final TenantDataSyncConfigService tenantDataSyncConfigService;

    private static final String OG = "OG";

    private static final String DATE_FORMAT_NOSIGN = "yyyyMMdd";

    private static final String PADDING = "000";

    public SassTenantRestController(TenantBaseInfoService tenantBaseInfoService, TenantDataSyncConfigService tenantDataSyncConfigService) {
        this.tenantBaseInfoService = tenantBaseInfoService;
        this.tenantDataSyncConfigService = tenantDataSyncConfigService;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("/tenant/list")
    public Object tenantList(HttpServletRequest request, @RequestBody TenantForm tenantForm){

        if(null == tenantForm){
            throw new BusinessException(SassBizResultCodeEnum.PARAMETER_NULL,"租户查询参数不能为空","租户查询参数不能为空");
        }

        loger.info("SassTenantRestController,tenantList, tenantForm = {}",tenantForm.getName());

        SassUserInfo sassUserInfo = this.getSassUser(request);
        // 参数转换设置

        PageResultVO page = new PageResultVO();
        page.setPageSize(tenantForm.getPageSize());
        page.setPageNumber(tenantForm.getPageIndex());

        TenantBaseInfoDO condition = BaseConvert.convert(tenantForm, TenantBaseInfoDO.class);
        PageResultVO<TenantBaseInfoDO> result = tenantBaseInfoService.findByCondition(page, condition);
        PageResultVO<TenantInfoVO> resultVO = BaseConvert.convert(result,PageResultVO.class);
        resultVO.setItems(BaseConvert.convertList(result.getItems(),TenantInfoVO.class));
        return resultVO;
    }

    @RequestMapping(value = "/query/{code}",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("/tenant/query")
    public Object queryTenantDetail(HttpServletRequest request, @PathVariable(value = "code")String code){

        if(StringUtils.isEmpty(code)){
            throw new BusinessException(SassBizResultCodeEnum.PARAMETER_NULL,"组织机构查询参数不能为空","组织机构查询参数");
        }

        loger.info("SassTenantRestController,queryTenantDetail, code = {}",code);

        TenantBaseInfoDO tenantBaseInfoDO = tenantBaseInfoService.selectByTenantId(code);
        if(tenantBaseInfoDO == null){
            throw new BusinessException(SassBizResultCodeEnum.DATA_NOT_EXIST);
        }
        TenantDetailVO result = BaseConvert.convert(tenantBaseInfoDO, TenantDetailVO.class);
        result.setTenantId(tenantBaseInfoDO.getTenantId());
        result.setTenantName(tenantBaseInfoDO.getTenantName());

        return result;

    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @RequiresPermissions("/tenant/create")
    @SysLog("创建租户操作")
    public Object createTenant(HttpServletRequest request, @RequestBody TenantForm tenantForm){

        if(null == tenantForm){
            throw new BusinessException(SassBizResultCodeEnum.PARAMETER_NULL,"创建租户参数不能为空","创建租户参数不能为空");
        }

        loger.info("SassTenantRestController,createTenant, tenantForm:{}",JSONObject.toJSONString(tenantForm));

        SassUserInfo sassUserInfo = this.getSassUser(request);
        // 参数转换设置
        TenantBaseInfoDO tenantBaseInfoDO = BaseConvert.convert(tenantForm, TenantBaseInfoDO.class);
        StringBuilder code = new StringBuilder();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOSIGN);
        code.append(OG).append(sdf.format(now)).append(PADDING);
        try {
            code.append(SnowFakeIdGenerator.getInstance().generateLongId());
        }catch (Exception e){
            loger.error("雪花算法生成id失败");
            throw new BusinessException(SassBizResultCodeEnum.GENERATE_ID_ERROR);
        }
        tenantBaseInfoDO.setTenantId(code.toString());
        tenantBaseInfoDO.setTenantName(tenantForm.getName());
        tenantBaseInfoDO.setGmtCreator(sassUserInfo.getAccount());
        tenantBaseInfoDO.setGmtUpdater(sassUserInfo.getAccount());

        boolean result = tenantBaseInfoService.createOrgBaseInfo(tenantBaseInfoDO);

        if(result){
            return SassBizResultCodeEnum.SUCCESS.getAlertMessage();
        }else {
            return SassBizResultCodeEnum.FAIL.getAlertMessage();
        }

    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @RequiresPermissions("/tenant/update")
    @SysLog("更新租户操作")
    public Object updateTenant(HttpServletRequest request,
                                     @RequestBody TenantForm tenantForm){

        if(null == tenantForm){
            throw new BusinessException(SassBizResultCodeEnum.PARAMETER_NULL,"更新租户参数不能为空","更新租户参数不能为空");
        }

        loger.info("SassTenantRestController,updateTenant, orgName = {}",tenantForm.getName());

        SassUserInfo sassUserInfo = this.getSassUser(request);

        TenantBaseInfoDO tenantBaseInfoDO = BaseConvert.convert(tenantForm, TenantBaseInfoDO.class);
        tenantBaseInfoDO.setTenantId(tenantForm.getCode());
        tenantBaseInfoDO.setTenantName(tenantForm.getName());
        tenantBaseInfoDO.setGmtUpdater(sassUserInfo.getAccount());
        boolean result = this.tenantBaseInfoService.updateByOrgId(tenantBaseInfoDO);

        if(result){
            return SassBizResultCodeEnum.SUCCESS.getAlertMessage();
        }else {
            return SassBizResultCodeEnum.FAIL.getAlertMessage();
        }

    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @RequiresPermissions("/tenant/delete")
    @SysLog("删除租户操作")
    public Object deleteTenant(@RequestBody DeleteOrgForm deleteOrgForm, HttpServletRequest request){

        if(deleteOrgForm == null){
            throw new BusinessException(SassBizResultCodeEnum.ILLEGAL_PARAMETER);
        }

        if(CollectionUtils.isEmpty(deleteOrgForm.getCodes())){
            throw new BusinessException(SassBizResultCodeEnum.ILLEGAL_PARAMETER,"组织机构列表不能为空");
        }

        int result = this.tenantBaseInfoService.deleteByCodes(deleteOrgForm.getCodes());
        if(result > 0){
            return SassBizResultCodeEnum.SUCCESS.getAlertMessage();
        }else {
            return SassBizResultCodeEnum.FAIL.getAlertMessage();
        }
    }

    @RequestMapping(value = "/queryConfig",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("/tenant/queryConfig")
    public Object queryTenantConfig(@RequestParam(required = false) String tenantId, HttpServletRequest request){

        SassUserInfo sassUserInfo = this.getSassUser(request);
        if(StringUtils.isEmpty(tenantId)){
            tenantId = sassUserInfo.getTenantId();
        }
        List<TenantDataSyncConfigDO> tenantDataSyncConfigDOS = tenantDataSyncConfigService.selectByTenantId(tenantId);
        return tenantDataSyncConfigDOS;
    }

}
