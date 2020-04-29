package cn.com.xinxin.sass.sal.wechatwork.impl;

import cn.com.xinxin.sass.sal.model.wechatwork.WeChatWorkUserBO;
import cn.com.xinxin.sass.sal.model.wechatwork.response.WeChatWorkUserQueryResponseBO;
import cn.com.xinxin.sass.sal.wechatwork.WeChatWorkInteractionClient;
import cn.com.xinxin.sass.sal.wechatwork.WeChatWorkUserClient;
import cn.com.xinxin.sass.common.enums.SassBizResultCodeEnum;
import cn.com.xinxin.sass.sal.utils.HttpClientUtils;
import com.alibaba.fastjson.JSON;
import com.xinxinfinance.commons.exception.BusinessException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuhangzhou
 * @created: 2020/4/20.
 * @updater:
 * @description: 企业微信成员信息管理Service
 */
@Service
public class WeChatWorkUserClientImpl implements WeChatWorkUserClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatWorkUserClientImpl.class);

    private final WeChatWorkInteractionClient weChatWorkInteractionClient;

    public WeChatWorkUserClientImpl(final WeChatWorkInteractionClient weChatWorkInteractionClient) {
        this.weChatWorkInteractionClient = weChatWorkInteractionClient;
    }

    /**
     * 查询用户信息列表
     * @param token 企业微信token
     * @param departmentId 部门id
     * @return 用户信息列表
     */
    @Override
    public List<WeChatWorkUserBO> queryUserList(String token, Long departmentId) {
        //参数检查
        if (StringUtils.isBlank(token)) {
            LOGGER.error("查询企业微信成员信息，token不能为空.");
            throw new BusinessException(SassBizResultCodeEnum.ILLEGAL_PARAMETER, "查询企业微信成员信息，token不能为空.");
        }
        if (null == departmentId) {
            LOGGER.error("查询企业微信成员信息，departmentId不能为空");
            throw new BusinessException(SassBizResultCodeEnum.ILLEGAL_PARAMETER, "查询企业微信成员信息，departmentId不能为空");
        }

        //查询成员信息列表
        String response = HttpClientUtils.sendGet(
                "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=" + token + "&department_id=" + departmentId);

        //将结果转化为BO
        WeChatWorkUserQueryResponseBO responseBO = JSON.parseObject(response, WeChatWorkUserQueryResponseBO.class);

        //检查查询是否成功
        weChatWorkInteractionClient.checkResponseStatus(responseBO.getErrorCode(), responseBO.getErrorMessage(),
                "向企业微信查询成员信息列表失败");

        return responseBO.getWeChatWorkUserBOS();
    }

    /**
     * 查询用户信息列表
     * @param token 企业微信token
     * @param departmentIdS 部门id列表
     * @return 用户信息列表
     */
    @Override
    public List<WeChatWorkUserBO> queryUserList(String token, List<Long> departmentIdS) {
        //参数检查
        if (StringUtils.isBlank(token)) {
            LOGGER.error("查询企业微信成员信息，token不能为空");
            throw new BusinessException(SassBizResultCodeEnum.ILLEGAL_PARAMETER, "查询企业微信成员信息，token不能为空");
        }
        if (CollectionUtils.isEmpty(departmentIdS)) {
            LOGGER.error("查询企业微信成员信息，departmentIdS不能为空");
            throw new BusinessException(SassBizResultCodeEnum.ILLEGAL_PARAMETER, "查询企业微信成员信息，departmentIdS不能为空");
        }

        //查询成员信息列表
        List<String> urls = new ArrayList<>();
        departmentIdS.forEach(d -> urls.add("https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=" + token +
                "&department_id=" + d));
        List<String> responseList = HttpClientUtils.sendGetList(urls);


        List<WeChatWorkUserBO> weChatWorkUserBOS = new ArrayList<>();
        responseList.forEach(r -> {
            //将结果转化为BO
            WeChatWorkUserQueryResponseBO responseBO = JSON.parseObject(r, WeChatWorkUserQueryResponseBO.class);
            //检查查询是否成功
            weChatWorkInteractionClient.checkResponseStatus(responseBO.getErrorCode(), responseBO.getErrorMessage(),
                    "向企业微信查询成员信息列表失败");
            weChatWorkUserBOS.addAll(responseBO.getWeChatWorkUserBOS());
        });

        return weChatWorkUserBOS;
    }
}
